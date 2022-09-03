package com.collections.programs.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class User {

	private String name;
	private int age;

	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return name + "-" + age;
	}

}

public class CustomSorting {

	public static void main(String args[]) {

		List<User> userList = new ArrayList<>(Arrays.asList(new User("John", 33), new User("Robert", 26),
				new User("Mark", 26), new User("Brandon", 42)));

		List<User> list = userList.stream().sorted(Comparator.comparingInt(User::getAge)).collect(Collectors.toList());
		System.out.println(list);

		List<User> sortedList = userList.stream().sorted((o1, o2) -> {
			if (o1.getAge() == o2.getAge())
				return o1.getName().compareTo(o2.getName());
			else if (o1.getAge() > o2.getAge())
				return 1;
			else
				return -1;
		}).collect(Collectors.toList());

		System.out.println(sortedList);
	}

}
