package org.jsp.jpa_proj;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateMerchant {
   public static void main(String[] args) {
	  
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter the merchant id to update");
	   int mid=sc.nextInt();
	   
	   EntityManagerFactory fact=Persistence.createEntityManagerFactory("dev");
	   EntityManager man=fact.createEntityManager();
	   EntityTransaction tran=man.getTransaction();
	   tran.begin();
	   Merchant m=man.find(Merchant.class, mid);
	   
	   if(m!=null)
	   {
		 m.setName("Rajeev");
		 m.setPhone(1234567890l);
		 m.setGst_num("pqrs1234");
		 m.setEmail("chotu@gmail.com");
		 m.setPassword("manisha@123");
		 tran.commit();
	   }
	   else
	   {
		   System.err.println("Merchant is not update since mid invalid");
	   }
}
}
