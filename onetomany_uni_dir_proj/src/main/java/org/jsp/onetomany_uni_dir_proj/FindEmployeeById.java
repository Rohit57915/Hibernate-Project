package org.jsp.onetomany_uni_dir_proj;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindEmployeeById {
	public static void main(String[] args) {
		
  	  Scanner sc=new Scanner(System.in);
  	  System.out.println("Enter the Employee id");
  	  int emp=sc.nextInt();
  	  sc.close();
  	  
  	  EntityManagerFactory fact=Persistence.createEntityManagerFactory("dev");
  	  EntityManager man=fact.createEntityManager();
  	  
  	 Employee e=man.find(Employee.class, emp);
  	  
  	  if(e!=null) {
  		  System.out.println(e);
  	  }
  	  else 
  	  {
  		  System.out.println("Employee Info is not found");
  	  }	
  	}
}
