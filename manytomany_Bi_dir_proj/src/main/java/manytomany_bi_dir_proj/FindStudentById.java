package manytomany_bi_dir_proj;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindStudentById {
	public static void main(String[] args) {
	  	  Scanner sc=new Scanner(System.in);
	  	  System.out.println("Enter the Student Id :");
	  	  int sid=sc.nextInt();
	  	  sc.close();
	  	  
	  	  EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	  	  EntityManager man=fac.createEntityManager();
	  	  
	  	  Student s=man.find(Student.class, sid);
	  	  
	  	  if(s!=null)
	  	  {
	  		  System.out.println(s);
	  	  }
	  	  else {
	  		  System.err.println("No Batch Info Found");
	  	  }
		}
}
