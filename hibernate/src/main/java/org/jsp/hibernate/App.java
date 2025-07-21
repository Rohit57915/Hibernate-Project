package org.jsp.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	Configuration conf= new Configuration();   
    	conf.configure();
    	
    	SessionFactory fac = conf.buildSessionFactory();
    	Session s = fac.openSession();
    	
    	Transaction ts = s.beginTransaction();
    	Employee e = new Employee(100, "Rohit", 949038843, "Software Developer", 100000, "rohit@gmail.com", "123456");
    	
    	s.persist(e);
    	ts.commit();
    	
    }
}
