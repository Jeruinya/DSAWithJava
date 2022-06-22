package com.scaler.multithreading;

class RunnableImpl implements Runnable {

	public void run() {
		System.out.println("Hello World from a different thread than Main");
	}
}