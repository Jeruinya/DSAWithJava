package com.scaler.lld.polymorphism;

public class OverLoadingDemo {

	int doSomething() {
		System.out.println("Doing something without param");
		return 0;
	}

	String doSomething(String hello) {
		System.out.println("Doing something with return String");
		return "";
	}

}