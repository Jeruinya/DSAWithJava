package com.scaler.dsa.queue;

class QNode {
	int key;
	QNode next;

	// constructor to create a new linked list node
	public QNode(int key) {
		this.key = key;
		this.next = null;
	}
}

public class QueueImpUsingLinkedList {

	QNode front, rear;
	int size=0;

	public QueueImpUsingLinkedList() {
		this.front = null;
		this.rear = null;
	}

	public void enqueue(int key) {
		QNode nn = new QNode(key);

		if (front == null) {
			front = nn;
			rear = nn;
		} else {
			rear.next = nn;
			rear = nn;
		}
		size++;
	}

	public void dequeue() {
		if (front == null)
			return;
		front = front.next;
		if (front == null)
			rear = null;
		size--;
	}
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int getFront() {
		return front.key;
	}
	
	public int getRear() {
		return rear.key;
	}

	public static void main(String[] args) {
		QueueImpUsingLinkedList q = new QueueImpUsingLinkedList();
		q.enqueue(10);
		q.enqueue(20);
		q.dequeue();
		q.dequeue();
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.dequeue();
		System.out.println("Queue Front : " + q.front.key);
		System.out.println("Queue Rear : " + q.rear.key);

	}

}
