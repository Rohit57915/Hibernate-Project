package manytomany_bi_dir_proj;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Batch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String batch_code;
     private String subject;
     private String trainer;
     
     @JoinTable(name="Batch_Info_Student_Info",joinColumns = {@JoinColumn(name="Batch_Id")},
    		 inverseJoinColumns = {@JoinColumn(name="Student_Id")})
     @ManyToMany(cascade = CascadeType.ALL)
     private List<Student> student;
     
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBatch_code() {
		return batch_code;
	}
	public void setBatch_code(String batch_code) {
		this.batch_code = batch_code;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTrainer() {
		return trainer;
	}
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	@Override
	public String toString() {
		return "Batch [id=" + id + ", batch_code=" + batch_code + ", subject=" + subject + ", trainer=" + trainer + "]";
	}
     
     
}
