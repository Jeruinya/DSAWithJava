package com.scaler.dsa.linkedList;

/*
Problem Description
Sort a linked list, A in O(n log n) time using constant space complexity.

Problem Constraints
0 <= |A| = 105

Input Format
The first and the only arugment of input contains a pointer to the head of the linked list, A.

Output Format
Return a pointer to the head of the sorted linked list.

Input 1:A = [3, 4, 2, 8]
Input 2:A = [1]

Output 1:[2, 3, 4, 8]
Output 2:[1]

Explanation 1: The sorted form of [3, 4, 2, 8] is [2, 3, 4, 8].

Explanation 2: The sorted form of [1] is [1].
 */
public class SortLinkedList {

	public static void main(String[] args) {
		Node n1 = new Node(44);
		Node n2 = new Node(8);
		Node n3 = new Node(20);
		Node n4 = new Node(5);
		Node n5 = new Node(7);
		Node n6 = new Node(19);
		n5.next = n6;
		n4.next = n5;
		n3.next = n4;
		n2.next = n3;
		n1.next = n2;
		
		Node head=sortList(n1);
		print(head);

	}

	public static Node sortList(Node A) {

		if (A == null || A.next == null)
			return A;

		Node head = A;
		Node mid = getMid(A);

		Node a = head;
		Node b = mid.next;
		mid.next = null;

		a = sortList(a);
		b = sortList(b);

		return merge(a, b);
	}

	public static Node getMid(Node A) {
		if (A == null) {
			return A;
		}
		Node slow = A;
		Node fast = A;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static Node merge(Node A, Node B) {

		if (A == null)
			return B;
		if (B == null)
			return A;

		Node head;
		if (A.data <= B.data) {
			head = A;
			head.next = merge(A.next, B);
		}

		else {
			head = B;
			head.next = merge(A, B.next);
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
