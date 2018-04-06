package com.jhunter.interview;

import java.util.LinkedList;
import java.util.Queue;

public class TreeIQ {	
	class TreeNode{
		Object info;
		TreeNode left, right;
		
		public TreeNode(Object info) {
			this.info = info;
			left = right = null;
		}
		public Object getInfo() { return info; }
	}
	
	public TreeIQ() { root = null; }
	TreeNode root;
	
	class RangePairInfo{
		int start, end;
		public RangePairInfo(int start, int end) { this.start = start; this.end = end; }
		public int getStartRange() {return start; }
		public int getEndRange() {return end; }
	}
	
	void insertNode(Integer obj) {
		if(root == null) {
			root = new TreeNode(obj);
			return;
		}
		
		TreeNode nodePtr = root;
		
		do {
			if(obj <= (Integer)nodePtr.info) {
				if(nodePtr.left != null) nodePtr = nodePtr.left;
				else {
					nodePtr.left = new TreeNode(obj);
					return;
				}
			}
			else {
				if(nodePtr.right != null) nodePtr = nodePtr.right;
				else {
					nodePtr.right = new TreeNode(obj);
					return;
				}				
			}
		}while(true);
	}
	
	/*
	 * Given a binary tree, output the maximum EVEN sum along any path
      	  10
     	/    \
    	2      50
   	  /  \      \
  	 1   101    13
	Maximum even sum = 101 +2 +10 + 50 + 13 = 176
	 */
	public int findMAXEvenSumOfTree(int arr[]) {
		if(arr == null  || arr.length == 0) return -1;
		
		for(int i=0; i<arr.length; i++) {
			insertNode(new Integer(arr[i]));
		}
		
		int sum = 0, smallestOddNumber=Integer.MAX_VALUE;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		
		do {
			TreeNode ptr = q.poll();
			sum += (Integer)ptr.info;
			if((Integer)ptr.info %2 != 0)
				smallestOddNumber = Math.min(smallestOddNumber, (Integer)ptr.info);
			if(ptr.left != null)
				q.offer(ptr.left);
			if(ptr.right != null)
				q.offer(ptr.right);
		}while(!q.isEmpty());
		
		if(sum %2 != 0) sum-=smallestOddNumber;
		return sum;
	}
	void insertRangeNode(RangePairInfo obj) {
		if(root == null) {
			root = new TreeNode(obj);
			return;
		}
		
		TreeNode nodePtr = root;
		
		do {
			if(obj.getStartRange() <= ((RangePairInfo)nodePtr.info).getStartRange()) {
				if(nodePtr.left != null) nodePtr = nodePtr.left;
				else {
					nodePtr.left = new TreeNode(obj);
					return;
				}
			}else {
				if(nodePtr.right != null) nodePtr = nodePtr.right;
				else {
					nodePtr.right = new TreeNode(obj);
					return;
				}
			}
		}while(true);
	}
	
    void constructTree(int arr[][]) {
		if(arr == null  || arr.length == 0) return;
		
		for(int i=0; i<arr.length; i++) {
			insertRangeNode(new RangePairInfo(arr[i][0], arr[i][1]));
		}
	}
    
    void constructTree(int arr[]) {
		if(arr == null  || arr.length == 0) return;
		
		for(int i=0; i<arr.length; i++) {
			insertNode(new Integer(arr[i]));
		}
    }
	
	public int[][] findRangeIndex(int arr[][], int findNo) {
		if(arr==null || arr.length == 0 )
			return null;
		
		constructTree(arr);
		
		TreeNode nodePtr = root;
		while(nodePtr != null){
			if( findNo >= ((RangePairInfo)nodePtr.info).getStartRange() && findNo <= ((RangePairInfo)nodePtr.info).getEndRange()) {
				int res[][] = new int[1][2];
				res[0][0] = ((RangePairInfo)nodePtr.info).getStartRange();
				res[0][1] = ((RangePairInfo)nodePtr.info).getEndRange();
				return res;
			}else if( findNo < ((RangePairInfo)nodePtr.info).getStartRange())
				nodePtr = nodePtr.left;
			else
				nodePtr = nodePtr.right;
		}
		return null;
	}
}
