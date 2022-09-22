package com.scaler.dsa.linkedList;

/*
Problem Description
Given a sorted linked list, delete all duplicates such that each element appears only once.


Problem Constraints
0 <= length of linked list <= 106

Input Format
First argument is the head pointer of the linked list.

Output Format
Return the head pointer of the linked list after removing all duplicates.

Input 1: 1->1->2
Input 2: 1->1->2->3->3

Output 1: 1->2
Output 2: 1->2->3

Explanation 1:
 Each element appear only once in 1->2.
 */
public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		Node head= new Node(1);		
		Node n1= new Node(1);
		Node n2= new Node(2);
		
		n1.next=n2;
		head.next=n1;
		
		Node newHead=deleteDuplicates(head);
		print(newHead);
		

	}

	public static Node deleteDuplicates(Node A) {

		if (A == null || A.next == null)
			return A;

		Node curr = A;

		while (curr.next != null) {

			if (curr.data == curr.next.data)
				curr.next = curr.next.next;
			else
				curr = curr.next;
		}
		return A;
	}
	
	private static void print(Node res) {
		while (res != null) {
			System.out.print(res.data + " ");
			res = res.next;
		}
	}
}
