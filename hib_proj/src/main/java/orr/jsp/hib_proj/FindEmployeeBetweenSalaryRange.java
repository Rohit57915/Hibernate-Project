package orr.jsp.hib_proj;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindEmployeeBetweenSalaryRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Minimum Salary: ");
        double minSal = sc.nextDouble();
        
        System.out.print("Enter Maximum Salary: ");
        double maxSal = sc.nextDouble();

        Configuration conf = new Configuration().configure();
        SessionFactory sef = conf.buildSessionFactory();
        Session ses = sef.openSession();

        Query<Employee> q = ses.createQuery(
            "SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2",
            Employee.class
        );
        q.setParameter(1, minSal);
        q.setParameter(2, maxSal);

        List<Employee> employees = q.getResultList();

        if (!employees.isEmpty()) {
            for (Employee e : employees) {
                System.out.println("Employee Name: " + e.getName() + ", Salary: " + e.getSalary());
            }
        } else {
            System.err.println("No employees found within the given salary range.");
        }

        ses.close();
        sef.close();
        sc.close();
    }
}
