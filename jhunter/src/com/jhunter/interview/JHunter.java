package com.jhunter.interview;

public class JHunter {
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String base03No = NumericIQ.base10tobase03(10);
		System.out.println("NumericIQ.base10tobase03(10): " + base03No);
	
		int a[] = {1,2,3,4,5,6,7,8};
		int res = NumericIQ.findNumberInShortedArrayWithoutArrayLength(a, 1);
		System.out.println("NumericIQ.findNumberInShortedArrayWithoutArrayLength() : " + res);
		
		int arr[][] = {{1,1,1,1,1,1}, 
				 	   {0,1,1,1,1,1}, 
				 	   {0,0,0,0,1,1},
				 	   {0,0,1,1,1,1}, 
				 	   {0,0,0,0,1,1}};
		res = Matrix.find1stLeftMost1FromSortedRowsArray(arr);
		System.out.println("Matrix.find1stLeftMost1FromSortedRowsArray() : " + res);
		
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
		if(resArr == null) System.out.println("tIQ.findRangeIndex() : NO RANGE FOUND");
		else System.out.println("tIQ.findRangeIndex() : " + resArr[0][0] + " , " + resArr[0][1]);
		
		int arrN[] = {1,9,9};
		arrN = NumericIQ.add1ToNumberRepresentedAsArray(arrN);
		System.out.print("add1ToNumberRepresentedAsArray() - ");
		for(int i=0; i<arrN.length;i++)
			System.out.print(" " + arrN[i]);
		
		if(StringIQ.compareString("abc\\b", "ab")) System.out.print("StringIQ.compareString() return true ");
		else System.out.print("StringIQ.compareString() return false ");
	}
}
