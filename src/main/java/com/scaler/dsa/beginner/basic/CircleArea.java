package com.scaler.dsa.beginner.basic;

import java.util.Scanner;

public class CircleArea {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int radius=s.nextInt();
		float pi=3.14f;
		float area=pi*radius*radius;
		
		System.out.println(Math.ceil(area));
	}

}
