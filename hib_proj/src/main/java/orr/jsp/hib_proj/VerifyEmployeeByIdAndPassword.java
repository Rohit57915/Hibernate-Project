package orr.jsp.hib_proj;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class VerifyEmployeeByIdAndPassword {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter  Id Number:");
	        int id =sc.nextInt();
	        System.out.println("Enter Password:");
	        String pw = sc.next();

	        Configuration conf = new Configuration();
	        conf.configure();

	        SessionFactory sef = conf.buildSessionFactory();
	        Session ses = sef.openSession();

	        Query<Employee> q = ses.createQuery(
	            "SELECT e FROM Employee e WHERE e.id = ?1 AND e.password = ?2",
	            Employee.class);
	        q.setParameter(1, id);
	        q.setParameter(2, pw);

	        try {
	            Employee e = q.getSingleResult();
	            System.out.println("Employee verified: " + e.getName());
	        } catch (NoResultException ex) {
	            System.err.println("Invalid Id or password.");
	        }

	        ses.close();
	        sef.close();
	        sc.close();
	    }
}
