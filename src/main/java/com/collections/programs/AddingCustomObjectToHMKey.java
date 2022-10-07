package com.collections.programs;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

final class EmployeeTest {

	private final long id;
	private final String name;
	private final Date dateOfBirth;
	private final BigDecimal salary;

	public EmployeeTest(EmployeeBuilder employeeBuilder) {
		this.id = employeeBuilder.id;
		this.name = employeeBuilder.name;
		this.dateOfBirth = employeeBuilder.dateOfBirth;
		this.salary = employeeBuilder.salary;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		EmployeeTest employee = (EmployeeTest) o;

		if (id != employee.id)
			return false;
		if (name != null ? !name.equals(employee.name) : employee.name != null)
			return false;
		if (dateOfBirth != null ? !dateOfBirth.equals(employee.dateOfBirth) : employee.dateOfBirth != null)
			return false;
		return salary != null ? salary.equals(employee.salary) : employee.salary == null;
	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
		result = 31 * result + (salary != null ? salary.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", dateOfBirth=" + dateOfBirth + ", salary="
				+ salary + '}';
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getDateOfBirth() {
		return (Date) dateOfBirth.clone();
	}

	public BigDecimal getSalary() {
		return salary;
	}

	static final class EmployeeBuilder {
		private long id;
		private String name;
		private Date dateOfBirth;
		private BigDecimal salary;

		private EmployeeBuilder() {
		}

		public static EmployeeBuilder anEmployee() {
			return new EmployeeBuilder();
		}

		public static EmployeeBuilder anEmployee(EmployeeTest employee) {
			return anEmployee().withId(employee.getId()).withName(employee.getName())
					.withDateOfBirth(employee.getDateOfBirth()).withSalary(employee.getSalary());
		}

		public EmployeeBuilder withId(long id) {
			this.id = id;
			return this;
		}

		public EmployeeBuilder withName(String name) {
			this.name = name;
			return this;
		}

		public EmployeeBuilder withDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
			return this;
		}

		public EmployeeBuilder withSalary(BigDecimal salary) {
			this.salary = salary;
			return this;
		}

		public EmployeeTest build() {
			return new EmployeeTest(this);
		}
	}
}

public class AddingCustomObjectToHMKey {

	public static void main(String[] args) {

		HashMap<EmployeeTest, String> employeeMap = new HashMap<EmployeeTest, String>();

		EmployeeTest employee1 = EmployeeTest.EmployeeBuilder.anEmployee().withId(1).withName("Sachin")
				.withDateOfBirth(new Date(1987, 2, 1)).withSalary(new BigDecimal(100000)).build();

		employeeMap.put(employee1, "India");

		for (Map.Entry<EmployeeTest, String> employeeStringEntry : employeeMap.entrySet()) {
			System.out.println(employeeStringEntry.getKey().hashCode());
		}

		EmployeeTest immutableUpdatedEmployee1 = EmployeeTest.EmployeeBuilder.anEmployee(employee1).withName("Rahul")
				.build();

		for (Map.Entry<EmployeeTest, String> employeeStringEntry : employeeMap.entrySet()) {
			System.out.println(employeeStringEntry.getKey().hashCode());
		}

		System.out.println(employeeMap.get(immutableUpdatedEmployee1));
		// Returns null

		EmployeeTest employee2 = EmployeeTest.EmployeeBuilder.anEmployee().withId(1).withName("Sachin")
				.withDateOfBirth(new Date(1987, 2, 1)).withSalary(new BigDecimal(100000)).build();

		System.out.println(employee2.hashCode());

		System.out.println(employeeMap.get(employee2));
		// Now this works fine and it shall return the correct object from the HashMap

	}

}
