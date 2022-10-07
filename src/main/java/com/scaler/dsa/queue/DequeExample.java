package com.scaler.dsa.queue;

import java.util.Deque;
import java.util.LinkedList;

public class DequeExample {

	public static void main(String[] args) throws IllegalStateException {
		Deque<Integer> q = new LinkedList<Integer>();

		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(10);
		q.add(20);
		q.add(30);

		System.out.println(q);

		System.out.println("Deque's front: " + q.getFirst());
		System.out.println("Deque's rear: " + q.getLast());
		q.remove();
		System.out.println(q);// [2, 3, 4, 10, 20, 30]
		q.removeFirst();
		System.out.println(q);// [3, 4, 10, 20, 30]
		q.removeLast();
		System.out.println(q);// [3, 4, 10, 20]

	}
}