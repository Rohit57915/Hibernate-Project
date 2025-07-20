package org.jsp.onetoone_uni_bi_dir_proj;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindUserById {
     public static void main(String[] args) {
		
    	 Scanner sc=new Scanner(System.in);
    	 System.out.println("Enter the user id??");
    	 int uid=sc.nextInt();
    	  sc.close();
    	 
    	 EntityManagerFactory fact=Persistence.createEntityManagerFactory("dev");
    	 EntityManager man=fact.createEntityManager();
    	 
    	 User u=man.find(User.class, uid);
    	 
    	 if(u!=null)
    	 {
    		 System.out.println(u);
    	 }
    	 else {
    		 System.err.println("No user info found");
    	 }
	}
}
