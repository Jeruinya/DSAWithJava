package com.scaler.dsa.linkedList;

public class InsertInSortedLL {

	public static void main(String[] args) {
		Node head= createLinkedList(10);
		
		Node newHead=insertSorted(head,66);
		print(newHead);
		

	}

	private static Node insertSorted(Node head, int data) {
		if(head==null || data<head.data) {
			Node n= new Node(data);
			n.next=head;
			return n;
		}
		
		Node t= head;
		while(t.next!=null && t.next.data<data)
			t=t.next;
		Node n= new Node(data);
		n.next=t.next;
		t.next=n;
		
		return head;
	}
	
	private static void print(Node res) {
		while (res != null) {
			System.out.print(res.data + " ");
			res = res.next;
		}
	}

	public static Node createLinkedList(int n) {
		Node head = new Node(1);
		Node t = head;
		for (int i = 2; i <= n; i++) {
			t.next = new Node(i);
			t = t.next;
		}
		return head;
	}
}
