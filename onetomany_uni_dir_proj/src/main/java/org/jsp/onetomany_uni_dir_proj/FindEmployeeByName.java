package org.jsp.onetomany_uni_dir_proj;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindEmployeeByName {
	 public static void main(String[] args) {
		 
	    	Scanner sc=new Scanner(System.in);
	    	System.out.println("Enter the Employee Name");
	    	String enm=sc.next();
	    	sc.close();
	    	
	    	EntityManagerFactory fact=Persistence.createEntityManagerFactory("dev");
	    	EntityManager man=fact.createEntityManager();
	    	
	    	Query q=man.createQuery("Select e from Employee e where e.name=?1");
	    	q.setParameter(1,enm);
	    	
	    	List<Employee>  e=q.getResultList();
	    	
	    	if(e.size()>0)
	    	{
	    		for (Employee employee : e) {
					System.out.println(employee);
				}
	    	}
	    	else
	    	{
	    		System.err.println("Employee Name is not match");
	    	}
		}
}
