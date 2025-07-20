 package manytomany_bi_dir_proj;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindStudentByPhone {
   public static void main(String[] args) {
	   
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter the Student Phone no :");
	   long sph=sc.nextLong();
	  	   
	   EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	   EntityManager man=fac.createEntityManager();
	   
	  Query q=man.createQuery("Select s from Student s Where s.phone=?1");
	  q.setParameter(1, sph);
	  
	  try {
			Student s=(Student) q.getSingleResult();
			System.out.println(s);
		  } 
	  catch (NoResultException e) 
	    {
			System.err.println("No Student found Phone Number");
		}
	    sc.close();
	    man.close();
	    fac.close();
  }
}
