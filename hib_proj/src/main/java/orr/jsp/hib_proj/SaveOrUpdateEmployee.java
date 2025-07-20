package orr.jsp.hib_proj;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveOrUpdateEmployee {
  public static void main(String[] args) {
	  Configuration conf = new Configuration();
	  conf.configure();
	  
	  SessionFactory sef=conf.buildSessionFactory();
	  Session ses=sef.openSession();
	
	  Transaction tran=ses.getTransaction();
	  tran.begin();
	  
	  Employee e=new Employee();
	  e.setId(4);
	  e.setName("pushpa");
	  e.setPhone(9154568796l);
	  e.setDesg("Manager");
	  e.setSalary(7000.0);
	  e.setEmail("pushapa@gmail.com");
	  e.setPassword("pushapa@123");
	  
	  ses.saveOrUpdate(e);
	  tran.commit();
}
}
