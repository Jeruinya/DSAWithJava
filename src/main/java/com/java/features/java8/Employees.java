package com.java.features.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Employees {

	private String empName;
	private String deptNo;
	private String empId;
	private int salary;

	public Employees(String empName, String deptNo, String empId, int salary) {
		super();
		this.empName = empName;
		this.deptNo = deptNo;
		this.empId = empId;
		this.salary = salary;
	}

	public String getEmpName() {
		return empName;
	}

	@Override
	public String toString() {
		return "Employees [empName=" + empName + ", deptNo=" + deptNo + ", empId=" + empId + ", salary=" + salary + "]";
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public static void main(String[] args) {
		List<Employees> employeeList = new ArrayList<>();

		employeeList.add(new Employees("Mayur", "IT", "100", 1000));
		employeeList.add(new Employees("Raj", "IT", "101", 2000));
		employeeList.add(new Employees("Anshul", "IT", "102", 3000));
		employeeList.add(new Employees("Hari", "EC", "102", 3000));
		employeeList.add(new Employees("Ram", "EC", "102", 3000));

		Map<String, Optional<Employees>> map = employeeList.stream().collect(Collectors.groupingBy(Employees::getDeptNo,
				Collectors.maxBy(Comparator.comparingInt(Employees::getSalary))));
		map.entrySet().forEach(System.out::println);

		Map<String, Employees> stringEmployeeMap = employeeList.stream()
				.collect(Collectors.groupingBy(Employees::getDeptNo, Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparingInt(Employees::getSalary)), Optional::get)));
		
		System.out.println(stringEmployeeMap);
		
	}

}
