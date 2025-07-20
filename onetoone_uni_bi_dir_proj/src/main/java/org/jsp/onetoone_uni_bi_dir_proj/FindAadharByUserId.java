package org.jsp.onetoone_uni_bi_dir_proj;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAadharByUserId {
	public static void main(String[] args) {
	   	  Scanner sc=new Scanner(System.in);
	   	  System.out.println("Enter the User Id");
	   	  int uId=sc.nextInt();
	   	  sc.close();
	   	
			  EntityManagerFactory fact=Persistence.createEntityManagerFactory("dev");
			  EntityManager man=fact.createEntityManager();
			  Query q = man.createQuery("SELECT a FROM AadharCard a WHERE a.u.id = :uid");
	            q.setParameter("uid", uId);
			  
			  try {
				AadharCard ac=(AadharCard) q.getSingleResult();
				System.out.println(ac);
			} catch (NoResultException e) {
				System.err.println("AadharCard Number is Not Match");
			}
			 
		}
}
