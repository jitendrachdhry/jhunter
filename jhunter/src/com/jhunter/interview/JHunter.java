package com.jhunter.interview;

public class JHunter {
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {{1,1,1,1,1,1}, 
				 	   {0,1,1,1,1,1}, 
				 	   {0,0,0,0,1,1},
				 	   {0,0,1,1,1,1}, 
				 	   {0,0,0,0,1,1}};
		Matrix.find1stLeftMost1FromSortedRowsArray(arr);
	}

}
