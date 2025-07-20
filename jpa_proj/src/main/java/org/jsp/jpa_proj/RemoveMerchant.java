package org.jsp.jpa_proj;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class RemoveMerchant {
  public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	   System.out.println("Enter the merchant id to delete");
	   int mid=sc.nextInt();
	   
	   EntityManagerFactory fact=Persistence.createEntityManagerFactory("dev");
	   EntityManager man=fact.createEntityManager();
	   EntityTransaction tran=man.getTransaction();
	   tran.begin();
	   Merchant m=man.find(Merchant.class, mid);
	   
	   if(m!=null)
	   {
		man.remove(m);
		 tran.commit();
	   }
	   else
	   {
		   System.err.println("Merchant is not delete since mid is not valid");
	   }
}
}
