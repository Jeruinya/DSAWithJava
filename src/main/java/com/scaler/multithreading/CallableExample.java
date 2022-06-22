package com.scaler.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableExample {
	static ExecutorService executor = Executors.newFixedThreadPool(2);

	public static void main(String[] args) throws Exception {
		CallableImpl task = new CallableImpl();
		Future<String> message = executor.submit(task);
		System.out.println(message.get().toString());
	}
}
