package orr.jsp.hib_proj;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
      @Id
	  private int id;
	  private String name;
	  private long phone;
	  private String desg;
	  private double salary;
	  private String email;
	  private String password;
	  
	  
	public Employee(int id, String name, long phone, String desg, double salary, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.desg = desg;
		this.salary = salary;
		this.email = email;
		this.password = password;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + ", desg=" + desg + ", salary=" + salary
				+ ", email=" + email + ", password=" + password + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
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
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
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
	 
	
}
