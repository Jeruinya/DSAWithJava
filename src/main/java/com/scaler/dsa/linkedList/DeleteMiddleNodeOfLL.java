package com.scaler.dsa.linkedList;

public class DeleteMiddleNodeOfLL {

	public static void main(String[] args) {
		int n = 10;
		Node head = createLinkedList(n);
		print(head);
		System.out.println();
		Node newHead = deleteMiddleElement(head);
		print(newHead);

	}

	public static Node deleteMiddleElement(Node A) {
		if (A == null || A.next == null) {
			return null;
		}
		Node slow = A;
		Node fast = A;
		Node prev = null;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = slow.next;
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
