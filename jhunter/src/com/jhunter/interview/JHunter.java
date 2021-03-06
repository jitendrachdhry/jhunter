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
		
		LinkedListIQ lIQ = new LinkedListIQ();
		lIQ.insertNode(new Character('a'));
		lIQ.insertNode(new Character('b'));
		lIQ.insertNode(new Character('c'));
		lIQ.insertNode(new Character('d'));
		lIQ.insertNode(new Character('e'));
		lIQ.reverseTwoNodes();
		lIQ.reverseTwoNodes();
		
		TreeIQ tIQ1 = new TreeIQ();
		int resArr[][] = tIQ1.findRangeIndex(arrRange, 0);
		if(resArr == null) System.out.println("tIQ.findRangeIndex() : NO RANGE FOUND");
		else System.out.println("tIQ.findRangeIndex() : " + resArr[0][0] + " , " + resArr[0][1]);
		
		TreeIQ tIQ  = new TreeIQ();
		tIQ.insertNode(new Integer(7));
		tIQ.insertNode(new Integer(5));
		tIQ.insertNode(new Integer(10));
		tIQ.insertNode(new Integer(3));
		tIQ.insertNode(new Integer(1));
		tIQ.insertNode(new Integer(20));
		tIQ.insertNode(new Integer(15));
		tIQ.insertNode(new Integer(40));

		tIQ.connectTreeSiblinges();
		
		int arrN[] = {1,9,9};
		arrN = NumericIQ.add1ToNumberRepresentedAsArray(arrN);
		System.out.print("add1ToNumberRepresentedAsArray() - ");
		for(int i=0; i<arrN.length;i++)
			System.out.print(" " + arrN[i]);
		
		if(StringIQ.compareString("\\cabc\\bd\\b", "ab")) System.out.print("StringIQ.compareString() return true ");
		else System.out.print("StringIQ.compareString() return false ");
		
		int arrT[] = {7,9,5,10,1000};
		tIQ = new TreeIQ();
		res = tIQ.findMAXEvenSumOfTree(arrT);
		System.out.println("tIQ.findMAXEvenSumOfTree() : " + res);
		
		System.out.println("StringIQ.arrange1stStringBasedOn2ndString() - " + 
		StringIQ.arrange1stStringBasedOn2ndString("abcdedadf", "cae")); //google","dog" ));
		
		System.out.println("NumericIQ.printSmallerNumComposedOf1and0(1113) : ");
		NumericIQ.printSmallerNumComposedOf1and0(1113);
		System.out.println("NumericIQ.smallerNumComposedOf1and0(1113) : " + NumericIQ.smallerNumComposedOf1and0(1113));
	}
}
