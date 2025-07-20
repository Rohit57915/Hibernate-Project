package org.jsp.onetomany_uni_dir_proj;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindDepartmentByName {
    public static void main(String[] args) {
		 
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter the Department Name");
    	String dnm=sc.next();
    	
    	EntityManagerFactory fact=Persistence.createEntityManagerFactory("dev");
    	EntityManager man=fact.createEntityManager();
    	
    	Query q=man.createQuery("Select d from Department d where d.name=?1");
    	q.setParameter(1,dnm);
    	
    	List<Department>  d=q.getResultList();
    	
    	if(d.size()>0)
    	{
    		for (Department department : d) {
				System.out.println(department);
			}
    	}
    	else
    	{
    		System.err.println("Department Name is not match");
    	}
	}
}
