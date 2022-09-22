package com.scaler.dsa.linkedList;

public class CreateLinkedListOfNElements {

	public static void main(String[] args) {
		int n = 10;
		Node head = createLinkedList(n);
		System.out.println(size(head));
		print(head);
		System.out.println();
		System.out.println(findKthElement(head, 4));
		System.out.println(recursiveSearch(head, 4));

		// Nodes newHead = insertNode(head, 6, 22);

		// Nodes newHead1 = insertNode(head, 0, 21);
		// print(newHead1);

		Node newHead2 = insertNode(head, 10, 2000);
		print(newHead2);

	}

	private static Node insertNode(Node head, int k, int data) {
		if (k > size(head))
			return head;
		else if (k == 0) {
			Node n = new Node(data);
			n.next = head;
			return n;
		} else {
			Node t = head;
			for (int i = 1; i <= k - 1; i++)
				t = t.next;

			Node n = new Node(data);
			n.next = t.next;
			t.next = n;

		}
		return head;
	}

	//This method will return the value at index k
	private static int findKthElement(Node head, int k) {
		Node t = head;

		if (k >= size(t))
			return -1;
		while (k > 0) {
			t = t.next;
			k--;
		}

		return t.data;
	}

	//This method will return the index of the kth element in the list
	private static int recursiveSearch(Node head, int k) {
		if (head == null)
			return -1;

		if (head.data == k) {
			return 0;
		} else {
			int subIndex = recursiveSearch(head.next, k);
			if (subIndex == -1)
				return -1;
			else
				return subIndex + 1;
		}

	}

	private static void print(Node res) {
		while (res != null) {
			System.out.print(res.data + " ");
			res = res.next;
		}
	}

	private static int size(Node res) {
		int count = 0;
		while (res != null) {
			count++;
			res = res.next;
		}
		return count;
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
