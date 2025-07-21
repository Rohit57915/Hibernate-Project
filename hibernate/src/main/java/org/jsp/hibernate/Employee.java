package org.jsp.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Employee {
	
	@Id
	private int id;
	private String name;
	private long phone;
	private String designation;
	private double salary;
	private String email;
	private String password;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String name, long phone, String designation, double salary, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.designation = designation;
		this.salary = salary;
		this.email = email;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + ", designation=" + designation
				+ ", salary=" + salary + ", email=" + email + ", password=" + password + "]";
	}
	
	

}
