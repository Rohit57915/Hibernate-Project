package orr.jsp.hib_proj;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindEmployeeBySalary {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Salary: ");
        double sal=sc.nextDouble();

        Configuration conf = new Configuration().configure();
        SessionFactory sef = conf.buildSessionFactory();
        Session ses = sef.openSession();

        Query<Employee> q = ses.createQuery(
            "SELECT e FROM Employee e WHERE e.salary = ?1",
            Employee.class);
        q.setParameter(1, sal);

        List<Employee> employees = q.getResultList();

        if (!employees.isEmpty()) {
            for (Employee e : employees) {
                System.out.println("Employee Name: " + e.getName());
                
            }
        } else {
            System.err.println("No employees found with the given Salary.");
        }

        ses.close();
        sef.close();
        sc.close();
    }
}
