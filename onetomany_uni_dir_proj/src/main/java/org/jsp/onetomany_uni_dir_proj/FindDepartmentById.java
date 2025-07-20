package org.jsp.onetomany_uni_dir_proj;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindDepartmentById {
      public static void main(String[] args) {
		
    	  Scanner sc=new Scanner(System.in);
    	  System.out.println("Enter the Department id");
    	  int dip=sc.nextInt();
    	  sc.close();
    	  
    	  EntityManagerFactory fact=Persistence.createEntityManagerFactory("dev");
    	  EntityManager man=fact.createEntityManager();
    	  
    	  Department d=man.find(Department.class, dip);
    	  
    	  if(d!=null) {
    		  System.out.println(d);
    	  }
    	  else 
    	  {
    		  System.out.println("Departmentr Info is not found");
    	  }	
    	}
}
