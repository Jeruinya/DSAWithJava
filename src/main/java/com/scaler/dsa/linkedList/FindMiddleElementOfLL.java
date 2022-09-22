package com.scaler.dsa.linkedList;

/*
Problem Description
Given a linked list of integers, find and return the middle element of the linked list.
NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.

Problem Constraints
1 <= length of the linked list <= 100000
1 <= Node value <= 109
Input Format
The only argument given head pointer of linked list.

Output Format
Return the middle element of the linked list.

Input 1: 1 -> 2 -> 3 -> 4 -> 5
Input 2: 1 -> 5 -> 6 -> 2 -> 3 -> 4

Output 1: 3
Output 2: 2

Explanation 1: The middle element is 3.

Explanation 2:
 The middle element in even length linked list of length N is ((N/2) + 1)th element which is 2.
 */
public class FindMiddleElementOfLL {

	public static void main(String[] args) {
		int n = 10;
		Node head = createLinkedList(n);

		System.out.println(findMiddleElement(head));
		System.out.println(findMiddleElementNew(head));

	}

	public static int findMiddleElement(Node A) {
		Node mid = A;

		int count = 0;
		while (A != null) {
			count++;
			A = A.next;
		}

		int i = count / 2;
		while (i > 0) {
			mid = mid.next;
			i--;
		}
		return mid.data;
	}

	public static int findMiddleElementNew(Node A) {
		if (A == null) {
			return A.data;
		}
		Node slow = A;
		Node fast = A;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;
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
