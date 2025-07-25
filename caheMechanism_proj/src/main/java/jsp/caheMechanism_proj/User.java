package jsp.caheMechanism_proj;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Cacheable
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   	private int id;
	private String name;
	private String emailId;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", emailId=" + emailId + "]";
	}
	
	
}
