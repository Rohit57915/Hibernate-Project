package org.jsp.onetoone_uni_bi_dir_proj;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindAadharById {
	public static void main(String[] args) {
		
   	 Scanner sc=new Scanner(System.in);
   	 System.out.println("Enter the Aadhar id??");
   	 int aid=sc.nextInt();
   	  sc.close();
   	 
   	 EntityManagerFactory fact=Persistence.createEntityManagerFactory("dev");
   	 EntityManager man=fact.createEntityManager();
   	 
   	 AadharCard a=man.find(AadharCard.class, aid);
   	 
   	 if(a!=null)
   	 {
   		 System.out.println(a);
   	 }
   	 else {
   		 System.err.println("No user info found");
   	 }
	}
}
