package com.jhunter.interview;

public class NumericIQ {
	public static int findNumberInShortedArrayWithoutArrayLength(int arr[], int findNo) {
		if(arr == null) return -1;

		int startIdx = 0, endIdx = 1, midIdx = 0;
		do {
			midIdx = (startIdx + endIdx )/2;
			try {
				if(arr[midIdx] == findNo) 
					return midIdx;
			}catch(ArrayIndexOutOfBoundsException e) {
				endIdx = midIdx-1;
				continue;
			}

			if(arr[midIdx] < findNo) {
				startIdx = midIdx + 1;
				try {
					if(arr[endIdx]>findNo)
						endIdx --;
					else
						endIdx *= 2;
				}catch(ArrayIndexOutOfBoundsException e) {
					endIdx --;
				}
			}else {
				endIdx = midIdx - 1;
			}
		}while(startIdx<=endIdx);
		return -1;
	}

	public static String base10tobase03(int base10no) {
		StringBuilder base03no = new StringBuilder();
		final int base3 = 3;
		do {
			if(base10no<base3) {
				base03no.append(base10no); 
				break;
			}
			base03no.append(base10no%base3);
			base10no = base10no/base3;
		}while(true);
		return base03no.toString();
	}
	
	public static int[] add1ToNumberRepresentedAsArray(int arr[]) {
		if(arr == null || arr.length == 0){
			arr = new int[1];
			arr[0] = 1;
			return arr;
		}
		
		int idx = arr.length-1;
		do {
			if((arr[idx] + 1) == 10 ) {
				arr[idx] = 0; // 9+1 should be 0 and pass carry for next index number.
			} else {
				arr[idx]++; // No needs to add further as there is no carry.
				return arr;
			}
		}while(--idx>=0);
		
		/*
		 * Looks like adding 1 overpass number boundary like 9,9 + 1
		 * needs to create new array of arr.length + 1 and set array first element to 1.
		 */
		int arrResult[] = new int[arr.length + 1];
		arrResult[0] = 1;
		return arrResult;
		
	}
	
	/*
	 * Give a decimal number, such as 123. Asking a total of smaller num 
	 * than 123 made up by 1 and 0 composed of decimal numbers. 
	 * 111, 110, 101, 100, 11, 10, 1, 0.
	 */
	public static int smallerNumComposedOf1and0(final int compareNo) {
		int noOfColumn = 0, tmp=compareNo;
		
		if(compareNo == 0) return 0;
		else if(compareNo==1) return 1;
		
		/*
		 * Find out how many digit we have in given compareNo.
		 * Based on this we construct array which have value made up by 1 and 0 composed 
		 * of decimal number(compareNo).
		 */
		while(tmp != 0) {
			noOfColumn++;
			tmp /=10;
		}
		
		/*
		 * Create array to store value made up by 1 and 0 composed of decimal number(compareNo).
		 */
		int noOfRow = (int) ((noOfColumn <= 2)? 2 : Math.pow(2, noOfColumn-1));
		int dp[][] = new int[noOfRow][noOfColumn];
		
		/*
		 * Initialize array based on each column value based on pattern. 
		 * Example for 4 digit.
		 * 1000
		 * 1001
		 * 1010
		 * 1011
		 * 1100
		 * 1101
		 * 1110
		 * 1111 
		 */
		dp[0][0] = 1;
		dp[noOfRow-1][0] = 1;
		for(int i=noOfColumn-1; i>0; i--) {
			dp[i][0] = 1;
			int relationShip = (int)Math.pow(2, (noOfColumn-1)-i);
			byte setToZeroOrOne = 0;
			for(int j=0; j<noOfRow;j++) {
				dp[j][i] = setToZeroOrOne;
				if(relationShip == 1 || (((j+1) % relationShip) == 0)){
					setToZeroOrOne = (byte) ((setToZeroOrOne == 1) ? 0 : 1);
				}
			}
		}
		
		//Check where does given number exist in dp of 1/0
		for(int i=noOfRow-1; i>=0; i++) {
			int constructNo = 1;
			for(int j=1; j<noOfColumn;j++)
				constructNo = (constructNo * 10) + dp[i][j];
			if(compareNo > constructNo) {
				int result = 0;
				for(int k=noOfColumn-1; k>0; k--)
					result += (k==1) ? 2 : Math.pow(2, k-1);
				return result + i + 1 ;
			}
		}
		return 0;
	}
	
	public static void printSmallerNumComposedOf1and0(final int compareNo)  {
		int k = 0;
		while (true) {
			int result = Integer.parseInt(Integer.toBinaryString(k));
			if (result > compareNo) {
				break;
			}
			System.out.print(result + " ");
			k++;
		}
	}
}
