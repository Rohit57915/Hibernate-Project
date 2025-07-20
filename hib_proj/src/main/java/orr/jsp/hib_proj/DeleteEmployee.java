package orr.jsp.hib_proj;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteEmployee {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Employee id to delete");	
	int eid=sc.nextInt();
	
	Configuration conf=new Configuration();
	conf.configure();
	
	SessionFactory sef=conf.buildSessionFactory();
	Session ses=sef.openSession();
	
	Transaction tran=ses.getTransaction();
	tran.begin();
	
	Employee e=ses.get(Employee.class, eid);// persistent state
	
	if(e!=null) {
		ses.delete(e);
		tran.commit();
	}
	else
	{
		System.out.println("Employee is not deleted since eid is invalid");
	}
}
}
