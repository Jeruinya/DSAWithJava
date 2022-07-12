package com.collections.programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

class Student {

	private int id;
	private String name;
	private String address;

	public Student() {
	}

	public Student(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(this.address, other.address) && Objects.equals(this.name, other.name);
	}

	@Override
	public String toString() {
		return id + " " + name + " " + address;
	}

}

public class AddingCustomObjectToHashSet {

	public static void main(String[] args) {
		Student e1 = new Student(1000, "Liton", "KK");
		Student e2 = new Student(1001, "Liton", "Falakata");
		Student e3 = new Student(1000, "Liton", "Falakata");
		Student e4 = new Student(1003, "Debabrata", "Birati");
		Student e5 = new Student(1000, "Souvik", "Kalighat");

		Set<Student> set = new HashSet<>();
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);
		System.out.println(set);

		List<Student> list = new ArrayList<>(set);
		System.out.println(list);

		Collections.sort(list, new Mycomarator());
		System.out.println(list);

		// for (Employee employee : set) {
		// System.out.println(employee);
		// }

		// set.stream().forEach(s -> System.out.println(s));
	}
}

class Mycomarator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		if (s1.getId() > s2.getId())
			return 1;
		else if (s1.getId() < s2.getId())
			return -1;
		else
			return 0;
	}

}
