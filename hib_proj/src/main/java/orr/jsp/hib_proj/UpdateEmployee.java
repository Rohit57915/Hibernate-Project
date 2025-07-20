package orr.jsp.hib_proj;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateEmployee {
  public static void main(String[] args) {
	  Configuration conf = new Configuration();
	  conf.configure();
	  
	  SessionFactory sef=conf.buildSessionFactory();
	  Session ses=sef.openSession();
	
	  Transaction tran=ses.getTransaction();
	  tran.begin();
	  
	  Employee e=new Employee();
	  e.setId(1);
	  e.setName("JayaPrakash");
	  e.setPhone(9186892796l);
	  e.setDesg("Manager");
	  e.setSalary(8000.0);
	  e.setEmail("jaya@gmail.com");
	  e.setPassword("parkashk@123");
	  
	  ses.update(e);
	  tran.commit();
}
}
