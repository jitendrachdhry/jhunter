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
}
