package orr.jsp.hib_proj;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveEmployee {
  public static void main(String[] args) {
	  Configuration conf = new Configuration();
	  conf.configure();
	  
	  SessionFactory sef=conf.buildSessionFactory();
	  Session ses=sef.openSession();
	  
	  Transaction tran=ses.getTransaction();
	  tran.begin();
	  
	  Employee e=new Employee();
	  e.setId(3);
	  e.setName("Kundan");
	  e.setPhone(5454845445l);
	  e.setDesg("Trainer");
	  e.setSalary(3000.0);
	  e.setEmail("kundan@gmail.com");
	  e.setPassword("Kushi123");
	  
	  int id=(Integer) ses.save(e);
	  tran.commit();
	  System.out.println("Employee is saved with an id" +id);
}
}
