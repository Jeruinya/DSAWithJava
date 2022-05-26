package com.scaler.dsa.linkedList;

public class CreateLinkedListOfSizeN {

	public static void main(String[] args) {
		int n = 10;
		Node head = createLinkedList(n);
		System.out.println(head);

		int count = countNumberOfNodesInLL(head);
		System.out.println();
		System.out.println(count);
		int k = 5, x = 10001;
		Node head1 = insertNode(k, x, head);

		int count1 = countNumberOfNodesInLL(head1);
		System.out.println();
		System.out.println(count1);

		Node headEnd = insertAtEnd(head1);
		System.out.println();
		// System.out.println(count2);

	}

	private static Node insertAtEnd(Node head) {
		if (head == null)
			head = new Node(2000);
		Node last = head;
		Node nn = new Node(2000);
		while (last.getNext() != null)
			last = last.getNext();

		last.setNext(nn);
		nn.setNext(null);

		return head;
	}

	private static Node insertNode(int k, int x, Node head) {
		Node nn = new Node(x);
		Node temp = head;
		if (k == 0) {
			nn.setNext(temp);
			head = nn;
			return head;
		}
		// if(k>size of linked list head)
		// return head.
		for (int i = 0; i < k - 1; i++)
			temp = temp.getNext();
		Node kthNode = temp.getNext();
		temp.setNext(nn);
		nn.setNext(kthNode);

		return head;
	}

	private static int countNumberOfNodesInLL(Node head) {
		int c = 0;
		Node temp = head;
		while (temp != null) {
			c++;
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
		return c;
	}

	private static Node createLinkedList(int n) {
		Node head = new Node(1);
		Node temp = head;
		for (int i = 2; i <= n; i++) {
			Node curr_node = new Node(i);
			temp.setNext(curr_node);
			temp = curr_node;
		}
		return head;
	}
}
