package com.jhunter.interview;

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
	
	public void insertRangeNode(RangePairInfo obj) {
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
