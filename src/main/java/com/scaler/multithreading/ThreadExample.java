package com.scaler.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Runnable runnable = () -> {
		    try {
		        String name = Thread.currentThread().getName();
		        System.out.println("Foo " + name);
		        TimeUnit.SECONDS.sleep(5);
		        System.out.println("Bar " + name);
		    }
		    catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		};

		Thread thread = new Thread(runnable);
		thread.start();
		
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
		    String threadName = Thread.currentThread().getName();
		    System.out.println("Hello " + threadName);
		});
		
		
		
		Callable<Integer> task = () -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		        return 123;
		    }
		    catch (InterruptedException e) {
		        throw new IllegalStateException("task interrupted", e);
		    }
		};

		ExecutorService executor1 = Executors.newFixedThreadPool(1);
		Future<Integer> future1 = executor1.submit(task);
		System.out.println(future1.isDone());
		System.out.println(future1.isCancelled());
		System.out.println(future1.get());
	}
	
	
}
