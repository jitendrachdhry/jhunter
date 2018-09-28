package com.jhunter.interview;

public class LinkedListIQ {
	class LinkedListNode{
		Object info;
		LinkedListNode next;
		
		public LinkedListNode(Object info) {
			this.info = info;
			next = null;
		}
		public Object getInfo() { return info; }
	}
	
	public LinkedListIQ() { root = null; }
	LinkedListNode root;
	
	void insertNode(Object obj) {
		if(root == null) {
			root = new LinkedListNode(obj);
			return;
		}
		LinkedListNode nodePtr = root;
		while(nodePtr.next!=null) nodePtr = nodePtr.next;
		nodePtr.next = new LinkedListNode(obj);
	}
	
	void deleteNode(LinkedListNode deleteNodeP) {
		if(root == null) return;
		
		LinkedListNode pPtr = null, cPtr = root;
		while(cPtr != deleteNodeP && cPtr != null) {
			pPtr = cPtr;
			cPtr = cPtr.next;
		}
		
		if(cPtr != null && cPtr == deleteNodeP) {
			if(cPtr == root) {
				root = cPtr.next;
			} else
				pPtr.next = cPtr.next;
		}
	}
	
	void printLinkedList(){
		LinkedListNode cPtr = root;
		System.out.print("Print Linked List:");
		while(cPtr != null) {
			System.out.print(cPtr.info.toString() + " ");
			cPtr = cPtr.next;
		}
		System.out.println(" ");
	}
	
	/*
	 * a->b->c->d->e change it to b->a->d->c->e
	 */
	
	void reverseTwoNodes() {
		printLinkedList();
		LinkedListNode cPtr = root, pPtr = root;
		
		if(root == null || root.next == null) return;
		
		root = root.next;
		
		do {
			pPtr.next = cPtr.next;
			LinkedListNode tPtr = cPtr.next;
			//t = b
			cPtr.next = tPtr.next;
			//a -> c
			tPtr.next = cPtr;
			// b -> a
			pPtr = cPtr;
			//pPtr = a
			cPtr = cPtr.next;
			//cPtr = c
		}while(cPtr!=null && cPtr.next !=null);
		
		printLinkedList();
	}
}
