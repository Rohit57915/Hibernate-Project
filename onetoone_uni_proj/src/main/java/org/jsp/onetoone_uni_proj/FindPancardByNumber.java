package org.jsp.onetoone_uni_proj;


import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPancardByNumber {
  public static void main(String[] args) {
	  Scanner sc =new Scanner(System.in);
	  System.out.println("Enter Pancard Number");
	  String nm=sc.next();
	  
	  EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	  EntityManager man=fac.createEntityManager();
	  
	  Query q=man.createQuery("Select p from Pancard p where p.number=?1");
	  q.setParameter(1, nm);
	  
	  try {
		Pancard p = (Pancard) q.getSingleResult();
		System.out.println(p);
	} catch (NoResultException e) {
		System.err.println("Pancard number info No match");
	}
}
}
