package orr.jsp.hib_proj;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class VerifyEmployeeByEmailAndPassword {
   public static void main(String[] args) {
	   
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter Email Id");
	   String em=sc.next();
	   System.out.println("Enter password");
	   String pw=sc.next();
	   
	   Configuration conf=new Configuration();
	   conf.configure();
	   
	   SessionFactory sef=conf.buildSessionFactory();
	   Session ses=sef.openSession();
	   
	   Query<Employee> q=ses.createQuery("Select e from Employee e Where e.email=?1 and e.password=?2",Employee.class);
	   q.setParameter(1, em);
	   q.setParameter(2, pw);
	   
	   try {
		   Employee e=q.getSingleResult();
		   System.out.println("Employee is Verified");
		   
	   }
	   catch(NoResultException e)
	   {
		   System.err.println("Employee is not verified");
	   }
} 
}
