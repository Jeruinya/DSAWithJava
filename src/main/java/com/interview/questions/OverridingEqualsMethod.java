package com.interview.questions;

class Employees {
	private String name;
	private int age;

	Employees(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Employees)) {
			return false;
		}
		Employees emp = (Employees) obj;
		return (this.name.equals(emp.getName())) && (Integer.compare(this.age, emp.getAge()) == 0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

public class OverridingEqualsMethod {

	public static void main(String[] args) {
		Employees emp1 = new Employees("Jhon", 19);
		Employees emp2 = new Employees("Jhon", 19);
		// Comparing the two objects
		boolean bool = emp1.equals(emp2);
		System.out.println(bool);
	}

}
