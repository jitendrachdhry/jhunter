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
		
		int resultIdx = -1;
		for(int i=0; i<arr[0].length;i++) {
			int startIdx = 0, endIdx=arr.length-1, midIdx=0;
			do{
				midIdx = (startIdx + endIdx) / 2;
				if(arr[midIdx][i] == 1) {
					return i;
				}else
					startIdx = midIdx + 1;
			}while(startIdx<endIdx);
		}
		return resultIdx;
	}
}
