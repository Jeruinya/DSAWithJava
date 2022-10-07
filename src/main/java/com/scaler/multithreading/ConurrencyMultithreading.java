package com.scaler.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConurrencyMultithreading {

	    public static void main(String[] args) throws InterruptedException, ExecutionException {
	        ExecutorService executorService = Executors.newSingleThreadExecutor();

	        Callable<String> stringCallable = () -> {
	            Thread.sleep(1000);
	            return "hello edpresso";
	        };

	        Future<String> stringFuture = executorService.submit(stringCallable);

	        while(!stringFuture.isDone() && !stringFuture.isCancelled()) {
	            Thread.sleep(200);
	            System.out.println("Waiting for task completion...");
	        }

	        String result = stringFuture.get();
	        System.out.println("Retrieved result from the task - " + result);

	        executorService.shutdown();
	    }
	}