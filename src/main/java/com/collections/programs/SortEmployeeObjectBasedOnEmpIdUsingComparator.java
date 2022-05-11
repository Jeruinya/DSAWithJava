package com.collections.programs;

import java.util.Comparator;
import java.util.TreeSet;

public class SortEmployeeObjectBasedOnEmpIdUsingComparator {

	public static void main(String[] args) {
		TreeSet<Employees> t = new TreeSet<>(new MyComp1() );
		t.add(new Employees(101, "Ram"));
		t.add(new Employees(10, "Raj"));
		t.add(new Employees(11, "Kiran"));
		t.add(new Employees(12, "Mohan"));
		t.add(new Employees(121, "Sohan"));
		t.add(new Employees(141, "Rohan"));
		t.add(new Employees(161, "Eshita"));
		System.out.println(t);

	}

}

class Employees {

	private int empId;
	private String empName;

	public Employees(int empId, String empName) {
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

	public String getEmpName() {
		return empName;
	}
}

 class MyComp1 implements Comparator<Employees>{

	@Override
	public int compare(Employees o1, Employees o2) {
		String s1= o1.getEmpName();
		String s2=o2.getEmpName();
		
		return s1.compareTo(s2);
	}
	 
 }
