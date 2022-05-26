package com.scaler.dsa.queue;

public class QueueImpUsingArray {
	int size = 0;
	int n = 1000;
	int arr[] = new int[n];
	int front = 0, rear = -1;

	public void enque(int x) {
		if (rear == n - 1)
			System.out.println("Queue if full");
		else {
			rear++;
			arr[rear] = x;
			size++;
		}
	}

	public int deque() {
		int x;
		if (rear - front + 1 == 0) {
			System.out.println("Queue if Empty");
			return Integer.MIN_VALUE;
		} else {
			x = arr[front];
			front++;
			size--;
		}
		return x;
	}

	public int front() {
		if (rear - front + 1 == 0)
			return Integer.MIN_VALUE;

		return arr[front];
	}

	public int rear() {
		if (rear - front + 1 == 0)
			return Integer.MIN_VALUE;

		return arr[rear];
	}

	public boolean isEmpty() {
		if (size == 0)
			return false;
		else
			return true;
	}

	public int size() {
		return size;
	}

	public void print() {
		if (rear - front + 1 == 0)
			System.out.println("Queue is empty");
		else
			for (int i =front;i<=rear;i++)
				System.out.print(arr[i]+" ");
	}

	public static void main(String[] args) {
		QueueImpUsingArray queue = new QueueImpUsingArray();

		queue.enque(10);
		queue.enque(20);
		queue.enque(30);
		queue.enque(40);
		queue.enque(300);
		queue.enque(400);
		
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		queue.print();

		//System.out.println(queue.deque() + " dequeued from queue\n");
		System.out.println("Front item is " + queue.front());
		System.out.println("Rear item is " + queue.rear());

	}

}
