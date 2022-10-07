package com.collections.programs;

import java.util.HashMap;
import java.util.Objects;

final class EmployeeObj {
	private int empId;
	private String empName;
	private String address;

	public EmployeeObj(int empId, String empName, String address) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.address = address;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	@Override
	public String toString() {
		return "[empId=" + empId + ", empName=" + empName + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, empId, empName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeObj other = (EmployeeObj) obj;
		return Objects.equals(address, other.address) && empId == other.empId && Objects.equals(empName, other.empName);
	}

	public String getAddress() {
		return address;
	}

}

public class AddingCustomObjectToHM {

	public static void main(String[] args) {
		HashMap<EmployeeObj, String> hm = new HashMap<>();
		
		EmployeeObj e1= new EmployeeObj(101, "Ram", "Pune");
		EmployeeObj e2= new EmployeeObj(102, "Mohan", "Delhi");
		EmployeeObj e3= new EmployeeObj(103, "Raju", "Mumbai");
		
		hm.put(e1, e1.getEmpName());
		hm.put(e2, e2.getEmpName());
		hm.put(e3, e3.getEmpName());
		System.out.println(hm);
		
		e1.setEmpName("Kamlesh");
		
		System.out.println(hm.get(e1));

	}

}
