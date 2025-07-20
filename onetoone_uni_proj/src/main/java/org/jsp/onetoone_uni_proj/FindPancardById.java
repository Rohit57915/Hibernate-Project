package org.jsp.onetoone_uni_proj;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindPancardById {
  public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter Pancard id");
	  int pid=sc.nextInt();
	  
	  EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	  EntityManager man=fac.createEntityManager();
	  
	  Pancard p=man.find(Pancard.class, pid);
	  if(p!=null) {
		  System.out.println(p);
	  }
	  else 
	  {
		  System.out.println("No Pancard info found");
	  }
}
}
