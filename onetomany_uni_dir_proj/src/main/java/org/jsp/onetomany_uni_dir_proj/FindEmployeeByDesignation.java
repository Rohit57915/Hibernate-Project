package org.jsp.onetomany_uni_dir_proj;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindEmployeeByDesignation {
	 public static void main(String[] args) {
		 
	    	Scanner sc=new Scanner(System.in);
	    	System.out.println("Enter the Employee Designation");
	    	String des=sc.next();
	    	sc.close();
	    	
	    	EntityManagerFactory fact=Persistence.createEntityManagerFactory("dev");
	    	EntityManager man=fact.createEntityManager();
	    	
	    	Query q=man.createQuery("Select e from Employee e where e.desg=?1");
	    	q.setParameter(1,des);
	    	
	    	List<Employee>  edes=q.getResultList();
	    	
	    	if(edes.size()>0)
	    	{
	    		for (Employee employee : edes) {
					System.out.println(employee);
				}
	    	}
	    	else
	    	{
	    		System.err.println("Employee Designation is not match");
	    	}
		}
}
