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
}
