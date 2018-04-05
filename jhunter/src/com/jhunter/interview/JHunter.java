package com.jhunter.interview;

public class JHunter {
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String base03No = NumericIQ.base10tobase03(10);
		System.out.print("NumericIQ.base10tobase03(10): " + base03No);
	
		int a[] = {1,2,3,4,5,6,7,8};
		int res = NumericIQ.findNumberInShortedArrayWithoutArrayLength(a, 1);
		System.out.print("NumericIQ.findNumberInShortedArrayWithoutArrayLength() : " + res);
		
		int arr[][] = {{1,1,1,1,1,1}, 
				 	   {0,1,1,1,1,1}, 
				 	   {0,0,0,0,1,1},
				 	   {0,0,1,1,1,1}, 
				 	   {0,0,0,0,1,1}};
		res = Matrix.find1stLeftMost1FromSortedRowsArray(arr);
		System.out.print("Matrix.find1stLeftMost1FromSortedRowsArray() : " + res);
		
		int arrRange[][] = {
				{3,6},
				{10,20},
				{7,9},
				{1,2},
				{40,100},
				{21,30},
				{31,39}
				};
		
		TreeIQ tIQ = new TreeIQ();
		int resArr[][] = tIQ.findRangeIndex(arrRange, 0);
		if(resArr == null) System.out.print("tIQ.findRangeIndex() : NO RANGE FOUND");
		else System.out.print("tIQ.findRangeIndex() : " + resArr[0][0] + " , " + resArr[0][1]);
	}

}
