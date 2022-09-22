package com.scaler.dsa.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueBasics {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < 5; i++)
			q.add(i);

		System.out.println(q);

		int removedele = q.remove();
		System.out.println("removed element-" + removedele);

		System.out.println(q);

		int head = q.peek();
		System.out.println("head of queue-" + head);

		int size = q.size();
		System.out.println("Size of queue-" + size);
	}
}