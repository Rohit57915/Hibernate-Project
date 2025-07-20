package org.jsp.jpa_proj;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchMerchantById {
  public static void main(String[] args) {
	
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter merchant id");
	  int mid=sc.nextInt();
	  
	  EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	  EntityManager man=fac.createEntityManager();
	  Merchant m=man.find(Merchant.class, mid);
	  
	  if(m!=null)
	  {
		  System.out.println(m);
	  }
	  else
	  {
		  System.err.println("No Merchant info found!!");
	  }
}
}
