package com.collections.programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;

class StudentPojo {

	private Integer id;
	private String name;

	public StudentPojo(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}

public class StreamPrograms {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("Netcracket");
		list.add("Netcracket solution");
		list.add("NC");
		list.add("Netcracket Pvt");
		list.add("Netcracket pvt ltd");

		OptionalInt rees = list.stream().mapToInt(s1 -> s1.length()).max();
		System.out.println(rees.getAsInt());

		int res = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).length() > res)
				res = list.get(i).length();
		}
		System.out.println(res);

		List<StudentPojo> lt = new ArrayList<>();
		lt.add(new StudentPojo(1, "Geeks"));
		lt.add(new StudentPojo(2, "For"));
		lt.add(new StudentPojo(3, "Geeks"));

		HashMap<Integer, String> map = lt.stream().collect(
				Collectors.toMap(StudentPojo::getId, StudentPojo::getName, (x, y) -> x + ", " + y, HashMap::new));
		System.out.println(map);
	}

}
