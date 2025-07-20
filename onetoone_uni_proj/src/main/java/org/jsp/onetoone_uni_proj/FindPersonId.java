package org.jsp.onetoone_uni_proj;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindPersonId {
  public static void main(String[] args) {
	 
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter the person id");
	  int pid=sc.nextInt();
	  
	  EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	  EntityManager man=fac.createEntityManager();
	  
	  Person p=man.find(Person.class, pid);
	  if(p!=null)
	  {
		  System.out.println(p);
	  }
	  else
	  {
		  System.err.println("Person info does ot exist");
	  }
}
}
