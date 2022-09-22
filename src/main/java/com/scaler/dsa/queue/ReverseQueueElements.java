package com.scaler.dsa.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
Given a queue , reverse each elements of the queue.
 */
public class ReverseQueueElements {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		q.add(10);
		q.add(3);
		q.add(30);
		q.add(100);
		q.add(35);
		q.add(110);
		System.out.println(q);// [10, 3, 30, 100, 35, 110]

		System.out.println(reverseQueue(q));// [110, 35, 100, 30, 3, 10]

	}

	private static Queue<Integer> reverseQueue(Queue<Integer> q) {
		Stack<Integer> s = new Stack<>();

		while (!q.isEmpty())
			s.push(q.poll());

		while (!s.isEmpty()) {
			q.add(s.peek());
			s.pop();
		}
		return q;
	}

}
