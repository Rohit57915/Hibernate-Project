package manytomany_bi_dir_proj;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindStudentWhosePercentageIsGreaterThanThirtyFive {
	public static void main(String[] args) {
		
		  Scanner sc=new Scanner(System.in);
		  System.out.println("Enter the Student percentage: ");
		  double perc=sc.nextDouble();
		  
		  EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		  EntityManager man=fac.createEntityManager();
		  
		  Query q = man.createQuery("SELECT s FROM Student s WHERE s.perc > ?1");
		  q.setParameter(1, perc);
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
