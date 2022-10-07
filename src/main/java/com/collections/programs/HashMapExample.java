package com.collections.programs;

import java.util.HashMap;
import java.util.Objects;

class Employee1 {
	private int empId;
	private String name;


	public Employee1(int empId, String name) {
		super();
		this.empId = empId;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empId, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee1 other = (Employee1) obj;
		return empId == other.empId && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return empId + " " + name;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

public class HashMapExample {

	public static void main(String[] args) {
		HashMap<Employee1, Integer> hm= new HashMap<>();
		Employee1 e1= new Employee1(101,"Ram");
		hm.put(e1, e1.getEmpId());
		
		e1.setEmpId(102);
		hm.put(e1, e1.getEmpId());
		System.out.println(hm);

	}

}
