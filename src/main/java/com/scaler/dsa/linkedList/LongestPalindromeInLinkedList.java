package com.scaler.dsa.linkedList;

/*
Problem Description
Given a linked list of integers. Find and return the length of the longest palindrome 
list that exists in that linked list.

A palindrome list is a list that reads the same backward and forward.
Expected memory complexity : O(1)
Problem Constraints
1 <= length of the linked list <= 2000
1 <= Node value <= 100
Input Format
The only argument given is head pointer of the linked list.
Output Format
Return the length of the longest palindrome list.

Input 1: 2 -> 3 -> 3 -> 3
Input 2: 2 -> 1 -> 2 -> 1 ->  2 -> 2 -> 1 -> 3 -> 2 -> 2

Output 1: 3
Output 2: 5

Explanation 1:
 3 -> 3 -> 3 is largest palindromic sublist

Explanation 2:
 2 -> 1 -> 2 -> 1 -> 2 is largest palindromic sublist.
 */
public class LongestPalindromeInLinkedList {

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(2);
		Node n4 = new Node(1);
		n3.next = n4;
		n2.next = n3;
		n1.next = n2;

		System.out.println(longestPalindrome(n1));

	}

	public static int longestPalindrome(Node A) {
		Node prev = null;
		Node curr = A;
		int ans = 0;

		while (curr != null) {
			Node nxt = curr.next;
			curr.next = prev;

			ans = Math.max(ans, 2 * (count(curr, nxt)));

			ans = Math.max(ans, 2 * (count(prev, nxt)) + 1);
			prev = curr;
			curr = nxt;

		}
		return ans;
	}

	public static int count(Node A, Node B) {
		int num = 0;

		while (A != null && B != null) {
			if (A.data != B.data)
				break;
			num++;
			A = A.next;
			B = B.next;
		}

		return num;
	}
}
