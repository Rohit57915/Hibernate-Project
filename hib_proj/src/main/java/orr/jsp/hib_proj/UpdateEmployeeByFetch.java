package orr.jsp.hib_proj;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateEmployeeByFetch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id to update:");
        int eid = sc.nextInt();
        
        Configuration conf = new Configuration().configure(); // loads hibernate.cfg.xml
        SessionFactory sef = conf.buildSessionFactory();
        Session ses = sef.openSession();
        
        Transaction trans = ses.beginTransaction();
        
        Employee e = ses.get(Employee.class, eid);
        
        if (e != null) {
            e.setName("yash");
            e.setDesg("Manager");
            e.setPhone(1554842154L);
            e.setEmail("rocy@gmail.com");
            e.setPassword("puji242");
            e.setSalary(50000);
            
            trans.commit(); // commit the update
            System.out.println("Employee updated successfully.");
        } else {
            System.err.println("Employee not updated — invalid ID.");
            trans.rollback(); // optional: roll back if you want to be safe
        }
        
        ses.close();
        sef.close();
        sc.close();
    }
}
