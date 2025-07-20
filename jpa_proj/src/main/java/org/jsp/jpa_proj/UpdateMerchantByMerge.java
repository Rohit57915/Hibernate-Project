package org.jsp.jpa_proj;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateMerchantByMerge {
  public static void main(String[] args) {
	
	  
	   
	   EntityManagerFactory fact=Persistence.createEntityManagerFactory("dev");
	   EntityManager man=fact.createEntityManager();
	   EntityTransaction tran=man.getTransaction();
	   tran.begin();
	   
	  Merchant m=new Merchant();
	     m.setId(4);
		 m.setName("Rohit");
		 m.setPhone(1234867890l);
		 m.setGst_num("rs1234");
		 m.setEmail("ray@gmail.com");
		 m.setPassword("yadav@123");
		 
		 man.merge(m);
		 tran.commit();
	   
}
}
