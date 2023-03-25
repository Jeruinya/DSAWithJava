package com.scaler.designPattern;

public class SingletonDesignPatternService {

	public static void main(String args[]) {
		SingletonDesignPattern1 s1= SingletonDesignPattern1.getInstance();
		System.out.println(s1);
		SingletonDesignPattern1 s2= SingletonDesignPattern1.getInstance();
		System.out.println(s2);
	}
}
