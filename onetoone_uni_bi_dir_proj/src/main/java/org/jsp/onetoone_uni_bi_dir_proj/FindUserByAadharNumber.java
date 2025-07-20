package org.jsp.onetoone_uni_bi_dir_proj;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindUserByAadharNumber {
	 public static void main(String[] args) {
		  
		  Scanner sc=new Scanner(System.in);
		  System.out.println("Enter the Aadhar Number");
		  long anm=sc.nextLong();
		  sc.close();
		  
		  EntityManagerFactory fact=Persistence.createEntityManagerFactory("dev");
		  EntityManager man=fact.createEntityManager();
		  
		  Query q=man.createQuery("Select u from User u Where u.card.aadharNo=?1");
		  q.setParameter(1,anm);
		  
		  
		try {
			User u = (User) q.getSingleResult();
			System.out.println(u);
		} catch (NoResultException e) {
			System.err.println("User Info Not Found");
		}
		  
	}
}
