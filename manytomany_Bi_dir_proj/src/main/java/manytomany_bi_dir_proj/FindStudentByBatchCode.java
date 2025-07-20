package manytomany_bi_dir_proj;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindStudentByBatchCode {
	public static void main(String[] args) {
		
		  Scanner sc=new Scanner(System.in);
		  System.out.println("Enter the Batch Code: ");
		  String bcode=sc.next();
		  
		  EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		  EntityManager man=fac.createEntityManager();
		  
		  Query q=man.createQuery("Select b.student from Batch b Where b.batch_code=?1");
		  q.setParameter(1,bcode);
		  List<Student> ls=q.getResultList();
		  
		  if (ls.size() > 0) {
	          for (Student student : ls) {
				System.out.println(student);
			}
	      }
	      else 
	      {
	          System.err.println("Student Name Info not found");
	      }

	      sc.close();
	      man.close();
	      fac.close();
	}     
}
