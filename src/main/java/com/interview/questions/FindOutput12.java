package com.interview.questions;

class Derived {

	protected final void getDetails() {
		System.out.println("Derived class");
	}
}

public class FindOutput12 extends Derived{

	//protected final void getDetails() {
		//System.out.println("Test class");
	//}

	public static void main(String[] args) {
		Derived obj = new Derived();
		obj.getDetails();
	}
}
