package com.scaler.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class RunnableImpl implements Runnable {

	public void run() {
		System.out.println("Hello World from a different thread than Main");
	}
}

public class RunnableExample {
	

	public static void main(String[] args) {
	 ExecutorService executor = Executors.newFixedThreadPool(2);
	 
		RunnableImpl task = new RunnableImpl();
		Thread thread = new Thread(task);
		thread.start();
		executor.submit(task);
	}
}