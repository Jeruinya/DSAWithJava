package com.scaler.dsa.stack;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		next = null;
	}
}

public class StackImplementaionUsingLinkedList {
	static Node head;
	int size = 0;

	public boolean isEmpty() {
		if (head == null)
			return true;
		else
			return false;
	}

	public int size() {
		return size;
	}

	public void push(int data) {
		Node nn = new Node(data);
		if (head == null)
			head = nn;
		else {
			nn.next = head;
			head = nn;
		}
		size++;

	}

	public int pop() {
		int x = 0;
		if (head == null) {
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		} else {
			x = head.data;
			head = head.next;
			size--;
		}
		return x;

	}

	public int peak() {
		int x = 0;
		if (head == null) {
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		} else
			x = head.data;

		return x;

	}

	public void print() {

		Node temp = head;
		if (head == null)
			System.out.println("Stack is empty");

		else {
			for (int i =0; i<size; i++) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
		}

	}

	public static void main(String[] args) {
		StackImplementaionUsingLinkedList sl = new StackImplementaionUsingLinkedList();
		sl.push(100);
		sl.push(200);
		sl.push(300);
		sl.push(400);
		sl.push(500);
		System.out.println(sl.isEmpty());
		System.out.println(sl.size());
		int p = sl.pop();
		System.out.println(p);
		System.out.println(sl.size());

		sl.print();
	}

}
