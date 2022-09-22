package com.scaler.dsa.linkedList;

/*
Problem Description
You are given a singly linked list having head node A. You have to reverse the linked 
list and return the head node of that reversed list.
NOTE: You have to do it in-place and in one-pass.

Problem Constraints
1 <= Length of linked list <= 105
Value of each node is within the range of a 32-bit integer.

Input Format
First and only argument is a linked-list node A.
Output Format
Return a linked-list node denoting the head of the reversed linked list.

Input 1: A = 1 -> 2 -> 3 -> 4 -> 5 -> NULL 
Input 2: A = 3 -> NULL 

Output 1: 5 -> 4 -> 3 -> 2 -> 1 -> NULL 
Output 2: 3 -> NULL 

Explanation 1:
 The linked list has 5 nodes. After reversing them, the list becomes : 5 -> 4 -> 3 -> 2 -> 1 -> NULL 

Expalantion 2:
 The linked list consists of only a single node. After reversing it, the list becomes : 3 -> NULL 
 */
public class ReverseLinkedList {

	public static void main(String[] args) {
		Node head = createLinkedList(10);
		print(head);
		System.out.println();
		Node revNode = reverseLinkedList(head);
		print(revNode);

	}

	public static Node reverseLinkedList(Node A) {
		Node curr = A;
		Node prev = null;
		Node next = null;

		if (A == null || A.next == null)
			return A;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
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

	private static void print(Node res) {
		while (res != null) {
			System.out.print(res.data + " ");
			res = res.next;
		}
	}
}
