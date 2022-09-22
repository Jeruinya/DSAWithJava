package com.scaler.dsa.linkedList;

public class PrintDataOfCircularLL {

	public static void main(String[] args) {
		Node n1=new Node(5);
		Node n2=new Node(8);
		Node n3=new Node(2);
		Node n4=new Node(11);
		Node n5=new Node(12);
		Node n6=new Node(6);
		Node n7=new Node(89);
		
		n7.next=n1;
		
		n6.next=n7;
		n5.next=n6;
		n4.next=n5;
		n3.next=n4;			
		n2.next=n3;
		n1.next=n2;
		
		print(n1);
		System.out.println();
		System.out.println(isCircular(n1));
	}

	private static boolean isCircular(Node head) {
		Node temp=head;
		while (temp!=null) {
			if(temp==head)
					return true;
			temp = temp.next;
		}
		return false;
	}
	
	private static void print(Node head) {
		Node temp=head;
		while (temp.next != head) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.print(temp.data + " ");
	}
}
