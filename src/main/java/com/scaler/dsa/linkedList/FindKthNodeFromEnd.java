package com.scaler.dsa.linkedList;

public class FindKthNodeFromEnd {

	public static void main(String[] args) {
		int n = 10;
		Node head = createLinkedList(n);
		print(head);
		System.out.println();

		System.out.println(findKthNodeFromEnd(head, 4));

	}

	private static int findKthNodeFromEnd(Node head, int k) {

		if (head == null)
			return -1;
		Node slow = head;
		Node fast = head;
		while (k > 0) {
			fast = fast.next;
			k--;
		}

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
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

	private static void print(Node res) {
		while (res != null) {
			System.out.print(res.data + " ");
			res = res.next;
		}
	}
}
