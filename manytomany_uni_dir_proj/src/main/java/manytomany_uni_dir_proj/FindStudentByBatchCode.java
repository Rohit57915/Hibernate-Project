package manytomany_uni_dir_proj;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindStudentByBatchCode {
	public static void main(String[] args) {
		
		  Scanner sc=new Scanner(System.in);
		  System.out.println("Enter the BatchCode : ");
		  String bc=sc.next();
		  
		  
		  EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		  EntityManager man=fac.createEntityManager();
		  
		  Query q = man.createQuery("SELECT b.student from Batch b where b.batch_code= ?1");
		  q.setParameter(1, bc);

		  List<Student> ls=q.getResultList();
		  
		  if (ls.size() > 0) {
	          for (Student student : ls) {
				System.out.println(student);
			}
	      }
	      else 
	      {
	          System.err.println("Student Info not found");
	      }

	      sc.close();
	      man.close();
	      fac.close();
	}     
}
