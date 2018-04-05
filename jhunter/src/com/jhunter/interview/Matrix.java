/**
 * 
 */
package com.jhunter.interview;

/**
 * @author ram
 *
 */
public class Matrix {

	/*
	 * Find the index of first 1 in a sorted array of 0’s and 1’s
	 */
	public static int find1stLeftMost1FromSortedRowsArray(int arr[][]) {
		if(arr==null  || arr.length == 0) return -1;
		
		/*
		 * Initialize resultIdx with MAX_VALUE.
		 * FYI, Array size never be above MAX_VALUE. So we are safe initialize with MAX_VALUE.
		 * Initialize with MAX_VALUE because if no 1 found in array so that we can return -1.
		 */
		int resultIdx = Integer.MAX_VALUE;
		
		/*
		 * First Loop for each row, because rows are in sorted order.
		 * Second loop for checking each column of given row. Its binary search.
		 * If I found 1 in middle, than i will check middle-1 for 0.
		 * If middle-1 is 0 than this is the end point to break inner loop. else move startIdx to midIdx + 1.
		 * Now I will Initialize resultIdx with middle if its value lower than resultIdx.
		 */
		for(int i=0; i<arr.length;i++) {
			int startIdx = 0, endIdx=arr[i].length-1, midIdx=0;
			do{
				midIdx = (startIdx + endIdx) / 2;
				if(arr[i][midIdx] == 1) {
					if(midIdx == 0 || arr[i][midIdx-1] == 0) { // Check for ArrayIndexOutOfBoundsException 
						resultIdx = Math.min(midIdx, resultIdx);
						/*
						 * Do I need to add resultIdx 0th index check condition?? 
						 * I think this will be extra overhead. 
						 * Please advice.
						 */
						if(resultIdx == 0) { return resultIdx;} 
						break;
					}else 
						endIdx = midIdx - 1;
				}else
					startIdx = midIdx + 1;
			}while(startIdx<=endIdx);
		}
		return (resultIdx == Integer.MAX_VALUE)? -1 : resultIdx;
	}
}
