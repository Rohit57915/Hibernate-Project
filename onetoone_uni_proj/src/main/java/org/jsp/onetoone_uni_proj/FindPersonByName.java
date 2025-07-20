package org.jsp.onetoone_uni_proj;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPersonByName {
  public static void main(String[] args) {
	  
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter Name of Person");
	  String nm=sc.next();
	  
	  EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	  EntityManager man=fac.createEntityManager();
	  
	  Query q=man.createQuery("Select p from Person p where p.name=?1");
	  q.setParameter(1, nm);
	  List<Person> lp=q.getResultList();
	  if(lp.size()>0)
	  {
		  for (Person person : lp) 
		  {
			System.out.println(person);
		}
	  }
	  else {
		 System.err.println("No Person info found since name is invalid"); 
	  }
}
}
