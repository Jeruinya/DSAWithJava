package com.interview.questions;

class Student {

	String name;
	int rollNo;

	Student(int num) {

		rollNo = num;

		name = "abc";
	}

	Student(int num, String str) {
		rollNo = num;
		name = str;
	}

	public void print() {
		System.out.print(name + " " + rollNo + " ");

	}

}

public class FindOutput7 {
	public static void main(String[] args) {

		Student s1 = new Student(101);
		s1.print();
		Student s2 = new Student(150, "xyz");
		s2.print();

	}

}
