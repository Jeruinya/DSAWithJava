package com.scaler.dsa.linkedList;

import java.util.ArrayList;

/*
Problem Description
Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, 
respectively.

Problem Constraints
1 <= |A| <= 105

Input Format
The first and the only argument of input contains a pointer to the head of the given linked list.

Output Format
Return 0, if the linked list is not a palindrome.
Return 1, if the linked list is a palindrome.

Input 1:A = [1, 2, 2, 1]
Input 2:A = [1, 3, 2]

Output 1: 1 
Output 2: 0 

Explanation 1:
 The first linked list is a palindrome as [1, 2, 2, 1] is equal to its reversed form.

Explanation 2:
 The second linked list is not a palindrom as [1, 3, 2] is not equal to [2, 3, 1].
 
 Approach 1: iterate over linked list and put the data either in Array of List and then use two pointer to check palindrome.
 
 Approach 2:
 i-Find middle element for dividing the list into two parts.
 ii-Reverse the second part.
 iii-Check if the first part is equal to the second half or not , if equal then its palindrome.
 */
public class CheckListIsPalindrome {

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(2);
		Node n4 = new Node(1);
		n3.next = n4;
		n2.next = n3;
		n1.next = n2;

		System.out.println(lPalin(n1));
		System.out.println(lPalinEff(n1));

	}

	public static int lPalin(Node A) {

		ArrayList<Integer> list = new ArrayList<>();
		while (A != null) {
			list.add(A.data);
			A = A.next;
		}
		int i = 0;
		int n = list.size() - 1;

		while (i <= n) {
			if (!list.get(i).equals(list.get(n)))
				return 0;
			i++;
			n--;
		}
		return 1;
	}

	public static int lPalinEff(Node A) {

		Node slow = A;
		Node fast = A.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		Node head1 = reverse(slow.next);
		Node head2 = A;

		return equal(head1, head2);
	}

	public static Node reverse(Node A) {
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

	public static int equal(Node head1, Node head2) {

		while (head1 != null && head2 != null) {
			if (head1.data != head2.data)
				return 0;
			head1 = head1.next;
			head2 = head2.next;
		}

		return 1;
	}

}
