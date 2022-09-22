package com.scaler.dsa.linkedList;

public class DeleteKthNodeFromEnd {

	public static void main(String[] args) {
		int n = 10;
		Node head = createLinkedList(n);
		print(head);
		System.out.println();

		Node newNode = removeNthFromEnd(head, 4);
		print(newNode);

	}

	public static Node removeNthFromEnd(Node A, int B) {
		int n = 0;
		Node head = A;
		if (A == null)
			return null;

		while (head != null) {
			n++;
			head = head.next;
		}
		if (B >= n) {
			return A.next;
		}
		head = A;
		for (int i = 0; i < n - B - 1; i++)
			head = head.next;
		head.next = head.next.next;
		return A;
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