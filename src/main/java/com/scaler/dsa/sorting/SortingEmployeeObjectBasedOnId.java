package com.scaler.dsa.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Employee{
	private int empId;
	private String empName;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public Employee(int empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	@Override
	public String toString() {
		return  empId +"-"+ empName ;
	}
}
public class SortingEmployeeObjectBasedOnId {

	public static void main(String[] args) {
		ArrayList<Employee> list= new ArrayList<>();
		list.add(new Employee(101,"Mohan"));
		list.add(new Employee(12,"Sohan"));
		list.add(new Employee(666,"Rohan"));
		list.add(new Employee(23,"Karan"));
		list.add(new Employee(90,"Danny"));
		list.add(new Employee(2,"Donna"));
		list.add(new Employee(123,"Mindi"));
		
		//Collections.sort(list, new Mycomparator());
		Collections.sort(list,(e1,e2)->e1.getEmpId()<e2.getEmpId()?-1:(e1.getEmpId()>e2.getEmpId()?-1:0));
		System.out.println(list);

	}

}


class Mycomparator implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {

		Integer i1 = e1.getEmpId();
		Integer i2 = e2.getEmpId();

		return i1.compareTo(i2);
	}

}

