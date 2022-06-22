package com.scaler.multithreading;

public class ExtendingThread  extends Thread{
	
	@Override
	public void run() {
		for(int i=1;i<15;i++)
			System.out.println("I value is:"+i);
	}

	public static void main(String[] args) {
		ExtendingThread t= new ExtendingThread();
		t.start();

	}

}
