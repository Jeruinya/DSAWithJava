package com.scaler.dsa.linkedList;

public class ReversePartOfLinkedListBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Node reverseBetween(Node A, int m, int n) {
		int i;
		Node node = A;
		Node prev = null;
		m--;
		n--;
		for (i = 0; i < m; i++) {
			prev = node;
			node = node.next;
		}
		if (prev != null)
			prev.next = reverseList(node, n - m + 1);
		else
			A = reverseList(node, n - m + 1);
		return A;
	}

	public static Node reverseList(Node A, int count) {
		Node node, prev, temp, last;
		node = A;
		last = A;
		if (node == null)
			return null;
		prev = null;
		while (node != null && count > 0) {
			temp = node.next;
			node.next = prev;
			prev = node;
			node = temp;
			count--;
		}
		last.next = node;
		return prev;
	}
}
