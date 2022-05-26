package com.scaler.dsa.linkedList;

/*
Problem Description
Given a matrix A of size Nx3 representing operations. Your task is to design the linked list based on these operations.
There are four types of operations:
0 x -1: Add a node of value x before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
1 x -1: Append a node of value x to the last element of the linked list.
2 x index: Add a node of value x before the indexth node in the linked list. 
	If the index equals the length of the linked list, the node will be appended to the end of the linked list. 
	If the index is greater than the length, the node will not be inserted.

3 index -1: Delete the indexth node in the linked list, if the index is valid.
A[i][0] represents the type of operation.
A[i][1], A[i][2] represents the corresponding elements with respect to type of operation.
Note: Indexing is 0 based.
Problem Constraints
1 <= Number of operations <= 1000
1 <= All node values <= 109
Input Format
The only argument given is matrix A.

Output Format
Return the pointer to the starting of the linked list.
Input 1:
A = [[0, 1, -1],
     [1, 2, -1],
     [2, 3, 1]]
Input 2:
A = [[0, 1, -1],
     [1, 2, -1],
     [2, 3, 1],
     [0, 4, -1],
     [3, 1, -1],
     [3, 2, -1]]

Output 1:1 -> 3 -> 2 -> NULL
Output 2:4 -> 3 -> NULL
Explanation 1:
After first operation the list is 1 -> NULL
After second operation the list is 1 -> 2 -> NULL
After third operation the list is 1 -> 3 -> 2 -> NULL

Explanation 2:
After first operation the list is 1 -> NULL
After second operation the list is 1 -> 2 -> NULL
After third operation the list is 1 -> 3 -> 2 -> NULL
After fourth operation the list is 4 -> 1 -> 3 -> 2 -> NULL
After fifth operation the list is 4 -> 3 -> 2 -> NULL
After sixth operation the list is 4 -> 3 -> NULL
 */

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class DesignLinkedList {

//Definition for singly-linked list.

	static ListNode head;
	static int size = 0;

	public static void main(String[] args) {
		int A[][] = { { 0, 1, -1 }, { 1, 2, -1 }, { 2, 3, 1 } };

		head = solve(A);
		printLikedList(head);
	}

	private static void printLikedList(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}

	public static ListNode solve(int[][] A) {
		for (int i = 0; i < A.length; i++) {
			if (A[i][0] == 0)
				addFirst(A[i][1]);
			else if (A[i][0] == 1)
				addLast(A[i][1]);
			else if (A[i][0] == 2)
				addNode(A[i][1], A[i][2]);
			else if (A[i][0] == 3)
				deleteByIndex(A[i][2], A[i][1]);
		}
		return head;
	}

	public static void addFirst(int val) {
		if (head == null)
			head = new ListNode(val);
		else {
			ListNode lnode = new ListNode(val);
			lnode.next = head;
			head = lnode;
		}
		size = size + 1;
	}

	public static void addLast(int val) {
		ListNode last = new ListNode(val);
		ListNode temp = head;
		if (head == null)
			head = last;
		else {
			while (temp.next != null)
				temp = temp.next;
			temp.next = last;

		}
		size = size + 1;
	}

	public static void addAtIndex(int val, int index) {
		int count = 0;
		ListNode temp = head;
		ListNode nn = new ListNode(val);
		while (count < index - 1) {
			temp = temp.next;
			count++;
		}
		nn.next = temp.next;
		temp.next = nn;
		size = size + 1;

	}

	public static void addNode(int val, int index) {
		if (index == size)
			addLast(val);
		else if (index > size || index < 0)
			return;
		else if (index == 0)
			addFirst(val);
		else
			addAtIndex(val, index);
	}

	public static void deleteByIndex(int val, int postion) {
		ListNode temp = head;
		if (head == null)
			return;
		if (postion < size) {
			if (postion == 0)
				head = temp.next;
			else {
				for (int i = 0; i < postion - 1; i++) {
					temp = temp.next;
				}
				temp.next = temp.next.next;
			}
		}
		size = size - 1;
	}
}
