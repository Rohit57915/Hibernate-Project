package orr.jsp.hib_proj;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchEmployee {
  public static void main(String[] args) {
	 
	  Configuration conf = new Configuration();
	  conf.configure();
	  
	  SessionFactory sef=conf.buildSessionFactory();
	  Session ses=sef.openSession();
	  
	  Employee e=ses.get(Employee.class, 100);
	  if(e!=null)
	  {
		  System.out.println("Employee Id is found" +e.getId());
	  }
	  else
	  {
		  System.out.println("No EMployee into found since id is Invalid");
	  }
}
}
