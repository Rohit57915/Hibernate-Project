package orr.jsp.hib_proj;

import java.util.Scanner;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindEmployeeById {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Id:");
        int id = sc.nextInt();

        Configuration conf = new Configuration();
        conf.configure();

        SessionFactory sef = conf.buildSessionFactory();
        Session ses = sef.openSession();

        Query<Employee> q = ses.createQuery(
            "SELECT e FROM Employee e WHERE e.id = ?1",
            Employee.class);
        q.setParameter(1, id);

        try {
            Employee e = q.getSingleResult();
            System.out.println("Employee found: " + e.getName());
        } catch (NoResultException ex) {
            System.err.println("No employee found with the given ID.");
        }

        ses.close();
        sef.close();
        sc.close();
    }
}
