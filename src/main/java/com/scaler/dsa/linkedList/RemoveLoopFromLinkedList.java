package com.scaler.dsa.linkedList;

public class RemoveLoopFromLinkedList {

	public static void main(String[] args) {
		Node n1 = new Node(5);
		Node n2 = new Node(8);
		Node n3 = new Node(2);
		Node n4 = new Node(11);
		Node n5 = new Node(12);
		Node n6 = new Node(6);
		Node n7 = new Node(89);

		n7.next = n3;

		n6.next = n7;
		n5.next = n6;
		n4.next = n5;
		n3.next = n4;
		n2.next = n3;
		n1.next = n2;
		// print(n1); this will run infinite time
		Node head = removeCycle(n1);
		print(head);

	}

	public static Node removeCycle(Node A) {

		Node mp = meetingPoint(A);
		if (mp == null)
			return null;

		Node slow = mp;
		Node fast = mp;

		slow = A;

		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		Node temp = slow;

		while (temp.next != slow)
			temp = temp.next;

		temp.next = null;
		return A;

	}

	private static Node meetingPoint(Node head) {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (slow == fast)
				return slow;
		}

		return null;
	}

	private static void print(Node res) {
		while (res != null) {
			System.out.print(res.data + " ");
			res = res.next;
		}
	}
}