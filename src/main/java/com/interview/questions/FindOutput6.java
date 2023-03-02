package com.interview.questions;

class Box {

	int width;

	int height;

	int length;

	void volume() {

		System.out.println(length * width * height);

	}

}

public class FindOutput6 {

	public static void main(String[] args) {
		Box b = new Box();
		b.height = 5;
		b.width = 4;
		b.volume();

	}

}
