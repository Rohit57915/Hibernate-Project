package orr.jsp.hib_proj;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchEmployeeUsedTryCatch {
public static void main(String[] args) {
	 Configuration conf = new Configuration();
	  conf.configure();
	  
	  SessionFactory sef=conf.buildSessionFactory();
	  Session ses=sef.openSession();
	  try 
	  {
	  Employee e=ses.load(Employee.class, 22);
	 
		  System.out.println("Employee Id is found" +e.getName());
	  
	  }
	  catch(ObjectNotFoundException e) 
	  {
		System.err.println("No Employee info found since id is invalid");  
	  }
}
}
