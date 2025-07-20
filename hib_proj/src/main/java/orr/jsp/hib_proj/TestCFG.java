package orr.jsp.hib_proj;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestCFG {
  public static void main(String[] args) {
	    Configuration conf=new Configuration();
	    conf.configure();
	    
	    SessionFactory fac=conf.buildSessionFactory();
	    Session ses=fac.openSession();
	    ses.beginTransaction();
	    Employee e=new Employee(101,"pavin",655165,"Software Developer", 1000000.56 , "pavin@gmail.com","pavin@1234");
	    ses.save(e);
	    ses.getTransaction().commit();
	    
	   
}
}
