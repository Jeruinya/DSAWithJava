package com.scaler.multithreading;

/*
ScheduledExecutorService:  
ScheduledExecutorService is a similar interface to ExecutorService, but it can perform tasks periodically.

Executor and ExecutorService‘s methods are scheduled on the spot without introducing any artificial delay. 
Zero or any negative value signifies that the request needs to be executed instantly.
We can use both Runnable and Callable interface to define the task.
 */
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableImpl implements Callable<String> {

	@Override
	public String call() throws Exception {

		int sum = 0;
		for (int i = 0; i < 10; i++)
			sum = sum + i;
		return "Hello World!" + sum;
	}
}

class CallableExample {
	static ExecutorService executor = Executors.newSingleThreadExecutor();
	//static ExecutorService executor1 = Executors.newSingleThreadExecutor(null);
	
	//static ExecutorService executor2 = Executors.newFixedThreadPool(10);
	//static ExecutorService executor3 = Executors.newFixedThreadPool(10, null);
	
	//static ExecutorService executor4 = Executors.newCachedThreadPool();
	//static ExecutorService executor5 = Executors.newCachedThreadPool(null);
	
	//static ExecutorService executor6 = Executors.newSingleThreadScheduledExecutor();
	//static ExecutorService executor7 = Executors.newSingleThreadScheduledExecutor(null);
	
	//static ExecutorService executor8 = Executors.newWorkStealingPool();
	//static ExecutorService executor9 = Executors.newWorkStealingPool(0);
	
	//executor.shutdown(); executor.shutdownNow()
	
//awaitTermination(long timeout, TimeUnit unit) which forcefully blocks until all tasks have completed 
	//execution after a shutdown event triggered or execution-timeout occurred,
	
	
	

	public static void main(String[] args) throws Exception {
		CallableImpl task = new CallableImpl();
		Future<String> message = executor.submit(task);
		
		System.out.println(message.get().toString());
	}
}
