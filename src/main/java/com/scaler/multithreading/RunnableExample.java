package com.scaler.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExample {
	static ExecutorService executor = Executors.newFixedThreadPool(2);

	public static void main(String[] args) {
		RunnableImpl task = new RunnableImpl();
		Thread thread = new Thread(task);
		thread.start();
		executor.submit(task);
	}
}