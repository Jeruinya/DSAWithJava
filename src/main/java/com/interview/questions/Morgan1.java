package com.interview.questions;

public class Morgan1 {

	static Morgan1 t;
	static int count = 0;

	public static void main(String[] args) throws InterruptedException {
		Morgan1 t1 = new Morgan1();
		t1 = null;
		System.gc();
		Thread.sleep(1000);
		t = null;
		System.gc();
		Thread.sleep(1000);
		System.out.println("Finalize method is called " + count);
	}

	@Override
	protected void finalize() {
		count++;
		t = this;
	}

}
