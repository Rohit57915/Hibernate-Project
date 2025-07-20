package jpa.jsp.user_proj;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestCFG {
  public static void main(String[] args) {
	   Configuration conf=new Configuration();
	   conf.configure();
	   
	   SessionFactory sef=conf.buildSessionFactory();
	   Session ses=sef.openSession();
	   
	   Transaction tran=ses.getTransaction();
	   tran.begin();
	   
	   User u=new User();
	  
	   u.setName("Kundan");
		u.setPhone(5454845445l);
		u.setEmail("kundan@gmail.com");
		u.setPassword("Kushi123");
		
		int id=(Integer) ses.save(u);
		  tran.commit();
		  System.out.println("Employee is saved with an id" +id);
}
}
