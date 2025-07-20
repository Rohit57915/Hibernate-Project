package org.jsp.onetomany_uni_dir_proj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveDepartmentAndEmployees {
    public static void main(String[] args) {
		
    	EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
    	EntityManager man=fac.createEntityManager();
    	EntityTransaction tran=man.getTransaction();
    	tran.begin();
    	
    	Department d=new Department();
    	d.setName("Training");
    	d.setLocation("Bengaluru");
    	
    	Employee e1=new Employee();
    	e1.setName("praveen");
    	e1.setPhone(9988776655l);
    	e1.setDesg("Trainer");
    	e1.setSalary(50000);
    	
    	Employee e2=new Employee();
    	e2.setName("pravalika");
    	e2.setPhone(9988772255l);
    	e2.setDesg("Trainer");
    	e2.setSalary(40000);
    	
    	Employee e3=new Employee();
    	e3.setName("pavan");
    	e3.setPhone(9988771155l);
    	e3.setDesg("Trainer");
    	e3.setSalary(30000);
    	
    	
    /*	List<Employee> lemps=new ArrayList<Employee>();
    	lemps.add(e1);
    	lemps.add(e2);
    	lemps.add(e3);
    	d.setEmps(lemps);
    */	
    	
    	d.setEmps(Arrays.asList(e1,e2,e3));
    	
    	man.persist(d);
    	tran.commit();
	}
}
