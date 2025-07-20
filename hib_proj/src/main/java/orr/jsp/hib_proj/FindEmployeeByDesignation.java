package orr.jsp.hib_proj;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindEmployeeByDesignation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Designation: ");
        String des = sc.next();

        Configuration conf = new Configuration().configure();
        SessionFactory sef = conf.buildSessionFactory();
        Session ses = sef.openSession();

        Query<Employee> q = ses.createQuery(
            "SELECT e FROM Employee e WHERE e.desg = ?1",
            Employee.class
        );
        q.setParameter(1, des);

        List<Employee> employees = q.getResultList();

        if (!employees.isEmpty()) {
            for (Employee e : employees) {
                System.out.println("Employee Name: " + e.getName());
                // You can also print other details like e.getEmail(), e.getSalary(), etc.
            }
        } else {
            System.err.println("No employees found with the given designation.");
        }

        ses.close();
        sef.close();
        sc.close();
    }
}
