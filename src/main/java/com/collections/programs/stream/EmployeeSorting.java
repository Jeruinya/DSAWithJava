package com.collections.programs.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class Employee {

	private int empId;
	private String empName;

	public Employee(int empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empId, empName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return empId == other.empId && Objects.equals(empName, other.empName);
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

}

public class EmployeeSorting {

	public static void main(String[] args) {
		List<Employee> list= new ArrayList<>();
		Employee e1= new Employee(201,"Ram");
		Employee e2= new Employee(101,"Mohan");
		Employee e3= new Employee(501,"Raju");
		Employee e4= new Employee(10,"Manoj");
		Employee e5= new Employee(201,"Kamal");
		
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		
		List<Employee> res=list.stream().sorted(Comparator.comparingInt(Employee::getEmpId)).collect(Collectors.toList());
		System.out.println(res);
		
		List<Employee> res1=list.stream().sorted((o1,o2)->{
			if(o1.getEmpId()==o2.getEmpId())
				return o1.getEmpName().compareTo(o2.getEmpName());
			else if(o1.getEmpId()>o2.getEmpId())
				return 1;
			else
				return -1;}).collect(Collectors.toList());
		
		System.out.println(res1);
		
	}

}
