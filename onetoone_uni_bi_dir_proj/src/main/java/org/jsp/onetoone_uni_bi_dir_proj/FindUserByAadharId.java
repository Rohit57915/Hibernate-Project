package org.jsp.onetoone_uni_bi_dir_proj;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindUserByAadharId {
  public static void main(String[] args) {
	  
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter the Aadhar Id");
	  int aid=sc.nextInt();
	  sc.close();
	  
	  EntityManagerFactory fact=Persistence.createEntityManagerFactory("dev");
	  EntityManager man=fact.createEntityManager();
	  
	  Query q = man.createQuery("SELECT u FROM User u WHERE u.card.id = :id");
      q.setParameter("id", aid);
	  
	  
	try {
		User u = (User) q.getSingleResult();
		System.out.println(u);
	} catch (NoResultException e) {
		System.err.println("User Info Not Found");
	}
	  
}
}
