package com.collections.programs;

import java.util.HashMap;

class Student1 {

	private int rollno;
	private String name;

	public Student1(int rollno, String name) {
		this.rollno = rollno;
		this.name = name;
	}

	@Override
	public String toString() {
		return rollno + " "+name ;
	}

	public String getname() {
		return this.name;
	}

	public int getmarks() {
		return this.rollno;
	}

	public void setname(String name) {
		this.name = name;
	}

	public void setmarks(int rollno) {
		this.rollno = rollno;
	}

	@Override
	public int hashCode() {
		final int temp = 14;
		int ans = 1;
		ans = temp * ans + rollno;
		return ans;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (this.getClass() != o.getClass()) {
			return false;
		}
		Student1 other = (Student1) o;
		if (this.rollno != other.rollno) {
			return false;
		}
		return true;
	}
}

public class AddingCustomObjectAsKeyToHashMap {

	public static void main(String[] args) {
		HashMap<Student1, String> map = new HashMap<>();

		Student1 one = new Student1(1, "Geeks1");
		Student1 two = new Student1(2, "Geeks2");
		Student1 three = new Student1(2, "Geeks2");

		map.put(one, one.getname());
		map.put(two, two.getname());
		map.put(three, two.getname());

		one.setname("Not Geeks1");
		two.setname("Not Geeks2");

		System.out.println(map.get(one));

		System.out.println(map.get(two));

		Student1 four = new Student1(1, "Geeks3");

		System.out.println(map.get(four));
	}

}
