package com.interview.questions;

interface Scaler {
	void myMethod();

	void getInfo();
}

abstract class X implements Scaler {

	void getData() {
		System.out.println("IB");
	}
}

public class FindOutpur11 extends X {
	public void myMethod() {
		System.out.println("InterviewBit");
	}

	public void getInfo() {
		System.out.println("Scaler");
	}

	public static void main(String[] args) {
		X obj = new FindOutpur11();
		obj.getInfo();
	}
}