package orr.jsp.hib_proj;
import java.util.Scanner;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class VerifyEmployeePhoneAndPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter  Phone Number:");
        long ph = sc.nextLong();
        System.out.println("Enter Password:");
        String pw = sc.next();

        Configuration conf = new Configuration();
        conf.configure();

        SessionFactory sef = conf.buildSessionFactory();
        Session ses = sef.openSession();

        Query<Employee> q = ses.createQuery(
            "SELECT e FROM Employee e WHERE e.phone = ?1 AND e.password = ?2",
            Employee.class);
        q.setParameter(1, ph);
        q.setParameter(2, pw);

        try {
            Employee e = q.getSingleResult();
            System.out.println("Employee verified: " + e.getName());
        } catch (NoResultException ex) {
            System.err.println("Invalid phone number or password.");
        }

        ses.close();
        sef.close();
        sc.close();
    }
}
