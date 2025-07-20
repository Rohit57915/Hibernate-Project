package org.jsp.onetomany_uni_dir_proj;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindDepartmentByLocation {
	public static void main(String[] args) {
		 
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter the Department Location");
    	String loc=sc.next();
    	sc.close();
    	
    	EntityManagerFactory fact=Persistence.createEntityManagerFactory("dev");
    	EntityManager man=fact.createEntityManager();
    	
    	Query q=man.createQuery("Select d from Department d where d.location=?1");
    	q.setParameter(1,loc);
    	
    	List<Department>  ll=q.getResultList();
    	
    	if(ll.size()>0)
    	{
    		for (Department department : ll) {
				System.out.println(department);
			}
    	}
    	else
    	{
    		System.err.println("Department Location is not match");
    	}
	}
	
}
