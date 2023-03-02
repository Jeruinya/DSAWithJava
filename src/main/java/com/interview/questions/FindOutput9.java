package com.interview.questions;

class IB {
	protected void getData() {
		System.out.println("Inside IB");
	}
}

class InterviewBit extends IB {
	protected void getData() {
		System.out.println("Inside InterviewBit");
	}
}

public class FindOutput9 {

	public static void main(String[] args) {
		IB obj = new InterviewBit();
		obj.getData();

	}

}
