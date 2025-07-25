package jpa.jsp.user_proj;

import javax.persistence.*;

@Entity
@Table(name="user_Info")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int id;
	@Column(name="uname",nullable=false)
	private String name;
	@Column (nullable=false,unique=true)
	private long phone;
	@Column(nullable=false,unique=true)
	private String email;
	@Column(nullable=false)
	private String password;
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
