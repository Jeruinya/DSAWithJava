package com.interview.questions;

import java.util.HashMap;
import java.util.Map;

/*
1: The class must be declared as final so that child classes can�t be created.
2: Data members in the class must be declared private so that direct access is not allowed.
3: Data members in the class must be declared as final so that we can�t change the value of it after object creation.
4: A parameterized constructor should initialize all the fields performing a deep copy so that data members can�t be modified with an object reference.
5: Deep Copy of objects should be performed in the getter methods to return a copy rather than returning the actual object reference)
 */

/*final class Employee {
	private final int empId;
	private final String empName;
	private final List<String> address;

	public Employee(int empId, String empName, List<String> address) {
		super();
		this.empId = empId;
		this.empName = empName;
		List<String> addr = new ArrayList<>();
		for (String adr : address)
			addr.add(adr);
		this.address = address;
	}

	public int getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public List<String> getAddress() {
		List<String> listAddr = new ArrayList<>();
		for (String str : this.address)
			listAddr.add(str);
		return listAddr;
	}

}*/

public final class CreateImmutableClass {

	private final String name;
	private final int regNo;
	private final Map<String, String> metadata;

	public CreateImmutableClass(String name, int regNo, Map<String, String> metadata) {
		this.name = name;
		this.regNo = regNo;
		Map<String, String> tempMap = new HashMap<>();
		for (Map.Entry<String, String> entry : metadata.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		this.metadata = tempMap;
	}

	public String getName() {
		return name;
	}

	public int getRegNo() {
		return regNo;
	}

	public Map<String, String> getMetadata() {

		Map<String, String> tempMap = new HashMap<>();

		for (Map.Entry<String, String> entry : this.metadata.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		return tempMap;
	}

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("1", "first");
		map.put("2", "second");

		CreateImmutableClass s = new CreateImmutableClass("ABC", 101, map);

		Map<String, String> map1 = new HashMap<>();
		map.put("101", "first");
		map.put("102", "second");

		CreateImmutableClass s1 = new CreateImmutableClass("Ram", 2300, map1);
		System.out.println(s.getName());
		System.out.println(s.getRegNo());
		Map<String,String> hm=s.getMetadata();
		hm.put("ktrix", "onetrix");
		System.out.println(hm);

		map.put("3", "third");
		System.out.println(s.getMetadata());
		s.getMetadata().put("4", "fourth");
		System.out.println(s.getMetadata());

		System.out.println(s);
		System.out.println(s1);
	}

}
