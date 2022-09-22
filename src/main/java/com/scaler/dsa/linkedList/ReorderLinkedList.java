package com.scaler.dsa.linkedList;

/*
Problem Description
Given a singly linked list A

 A: A0 → A1 → … → An-1 → An 
reorder it to:
 A0 → An → A1 → An-1 → A2 → An-2 → … 
You must do this in-place without altering the nodes' values.

Problem Constraints
1 <= |A| <= 106

Input Format
The first and the only argument of input contains a pointer to the head of the linked list A.

Output Format
Return a pointer to the head of the modified linked list.

Input 1: A = [1, 2, 3, 4, 5] 
Input 2: A = [1, 2, 3, 4] 

Output 1: [1, 5, 2, 4, 3] 
Output 2: [1, 4, 2, 3] 

Explanation 1:
 The array will be arranged to [A0, An, A1, An-1, A2].

Explanation 2:
 The array will be arranged to [A0, An, A1, An-1, A2].
 
 There are below steps need to follow on problem:
 1- find the mid element
 2- break list into parts based on middle element
 3- reverse the second part of LL
 4- merge the two parts
 */
public class ReorderLinkedList {

	public static void main(String[] args) {
		Node n1 = new Node(5);
		Node n2 = new Node(8);
		Node n3 = new Node(2);
		Node n4 = new Node(11);
		Node n5 = new Node(12);
		Node n6 = new Node(6);
		Node n7 = new Node(89);

		n6.next = n7;
		n5.next = n6;
		n4.next = n5;
		n3.next = n4;
		n2.next = n3;
		n1.next = n2;
		print(n1);

		Node res = reorderList(n1);
		System.out.println();
		print(res);

	}

	public static Node reorderList(Node A) {
		Node mid = middleNode(A);

		Node h2 = mid.next;
		mid.next = null;

		h2 = reverse(h2);

		Node h1 = A;
		return mergeList(h1, h2);

	}

	public static Node middleNode(Node A) {
		Node slow = A;
		Node fast = A;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static Node reverse(Node h2) {
		Node prev = null;
		Node curr = h2;
		Node temp = null;

		while (curr != null) {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}

		return prev;
	}

	public static Node mergeList(Node A, Node B) {
		Node h1 = A;
		Node h2 = B;
		Node ans = A;

		while (h2 != null) {
			Node temp = h2.next;
			h2.next = h1.next;
			h1.next = h2;
			h1 = h1.next.next;
			h2 = temp;
		}

		return ans;
	}

	private static void print(Node res) {
		while (res != null) {
			System.out.print(res.data + " ");
			res = res.next;
		}
	}

}
