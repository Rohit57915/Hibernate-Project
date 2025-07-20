package org.jsp.onetoone_uni_bi_dir_proj;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindUserByName {
    public static void main(String[] args) {
    	  Scanner sc=new Scanner(System.in);
    	  System.out.println("Enter the name");
    	  String unm=sc.next();
    	  sc.close();
    	
		  EntityManagerFactory fact=Persistence.createEntityManagerFactory("dev");
		  EntityManager man=fact.createEntityManager();
		  
		  Query q=man.createQuery("Select u from User u where u.name=?1");
		  q.setParameter(1,unm);
		  List<User> lu=q.getResultList();
		  if(lu.size()>0)
		  {
			  for (User user : lu) {
				System.out.println(user);
			}
		  }
		  else {
			  System.err.println("No user info found");
		  }
	}
}
