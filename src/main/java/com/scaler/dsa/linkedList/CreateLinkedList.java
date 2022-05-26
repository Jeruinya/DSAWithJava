package com.scaler.dsa.linkedList;

public class CreateLinkedList {

	static class Node {
		int data;
		Node next;

		public Node() {
			this.data = 0;
			this.next = null;
		}
	}

	static Node root = null;
	static int size_of_ll = 0;

	public static void insert_node(int position, int value) {
		if (position >= 1 && position <= size_of_ll + 1) {
			Node temp = new Node();
			temp.data = value;
			if (position == 1) {
				temp.next = root;
				root = temp;
			} else {
				int count = 1;
				Node prev = root;
				while (count < position - 1) {
					prev = prev.next;
					count++;
				}
				temp.next = prev.next;
				prev.next = temp;

			}
			size_of_ll++;
		}
	}

	public static void delete_node(int position) {
		if (position >= 1 && position <= size_of_ll) {
			Node temp = null;
			if (position == 1) {
				temp = root;
				root = root.next;
			} else {
				int count = 1;
				Node prev = root;
				while (count < position - 1) {
					prev = prev.next;
					count++;
				}
				temp = prev.next;
				prev.next = prev.next.next;
			}
			size_of_ll--;
		}
	}

	public static void print_ll() {
		// Output each element followed by a space
		Node temp = root;
		int flag = 0;
		while (temp != null) {
			if (flag == 0) {
				System.out.print(temp.data);
				flag = 1;
			} else
				System.out.print(" " + temp.data);
			temp = temp.next;
		}
	}

	public static void main(String args[]) {
		int pos = 1, value = 120;
		insert_node(pos, value);
		print_ll();
		delete_node(pos);

	}

}