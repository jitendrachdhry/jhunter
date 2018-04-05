package com.jhunter.interview;

public class TreeIQ {	
	class TreeNode{
		Object info;
		TreeNode next;
		
		public TreeNode(Object info) {
			this.info = info;
			next = null;
		}
		public Object getInfo() { return info; }
	}
	
	public TreeIQ() { root = null; }
	TreeNode root;
	
	class PairInfo{
		int start, end;
		public PairInfo(int start, int end) { this.start = start; this.end = end; }
		public int getStart() {return start; }
		public int getEnd() {return end; }
	}
	
	public void insert(PairInfo obj) {
		if(root == null) {
			root = new TreeNode(obj);
			return;
		}
		
	}
	public void constructTree(int arr[][]) {
		if(arr == null  || arr.length == 0) return;
		
		for(int i=0; i<arr.length; i++) {
			insert(new PairInfo(arr[i][0], arr[i][1]));
		}
	}
}
