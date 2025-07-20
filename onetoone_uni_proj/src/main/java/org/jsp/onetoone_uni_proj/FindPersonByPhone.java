package org.jsp.onetoone_uni_proj;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPersonByPhone {
 public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Phone Number");
	long ph=sc.nextLong();
	 
	 EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	 EntityManager man=fac.createEntityManager();
	 
	 Query q=man.createQuery("Select p from Person p where p.phone=?1");
	 q.setParameter(1, ph);
	 
	 try {
		Person p = (Person) q.getSingleResult();
		System.out.println(p);
	} catch (NoResultException e) {
		System.err.println("No Person info found");
	}
}
}
