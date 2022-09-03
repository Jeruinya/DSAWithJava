package com.collections.programs.stream;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertingListToMap {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		Employee e1 = new Employee(201, "Ram");
		Employee e2 = new Employee(101, "Mohan");
		Employee e3 = new Employee(501, "Raju");
		Employee e4 = new Employee(10, "Manoj");
		Employee e5 = new Employee(201, "Kamal");

		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		System.out.println(list);

		// This code will throw exception when will try to add duplicate key into
		// hashMap
		// Map<Integer,String> hm=
		// list.stream().collect(Collectors.toMap(Employee::getEmpId,
		// Employee::getEmpName));
		// System.out.println(hm);

		// (oldValue, newValue) -> newValue) or (oldValue, newValue) -> oldValue)
		Map<Integer, String> hm = list.stream()
				.collect(Collectors.toMap(Employee::getEmpId, Employee::getEmpName, (oldValue, newValue) -> newValue));
		System.out.println(hm);

		Map<Integer, String> result = hm.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors
				.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		System.out.println(result);

	}

}
