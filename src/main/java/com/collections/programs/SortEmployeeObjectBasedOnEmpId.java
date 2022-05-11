package com.collections.programs;

import java.util.TreeSet;

public class SortEmployeeObjectBasedOnEmpId {

	public static void main(String[] args) {
		TreeSet<Employee> t = new TreeSet<>();
		t.add(new Employee(101, "Ram"));
		t.add(new Employee(10, "Raj"));
		t.add(new Employee(11, "Kiran"));
		t.add(new Employee(12, "Mohan"));
		t.add(new Employee(121, "Sohan"));
		t.add(new Employee(141, "Rohan"));
		t.add(new Employee(161, "Eshita"));
		System.out.println(t);// [10 Raj, 11 Kiran, 12 Mohan, 101 Ram, 121 Sohan, 141 Rohan, 161 Eshita]
		// [161 Eshita, 141 Rohan, 121 Sohan, 101 Ram, 12 Mohan, 11 Kiran, 10 Raj]

	}

}

class Employee implements Comparable {

	private int empId;
	private String empName;

	public Employee(int empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}

	@Override
	public String toString() {
		return empId + " " + empName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public int compareTo(Object o) {
		int empId1 = this.empId;
		Employee e = (Employee) o;
		int empId2 = e.getEmpId();
		if (empId1 > empId2)
			return -1;
		else if (empId1 < empId2)
			return 1;
		else
			return 0;
	}
}
