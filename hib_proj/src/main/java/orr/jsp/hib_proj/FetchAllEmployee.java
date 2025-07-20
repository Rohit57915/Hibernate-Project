package orr.jsp.hib_proj;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchAllEmployee {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure();
        SessionFactory sef = conf.buildSessionFactory();
        Session ses = sef.openSession();

        Query<Employee> q = ses.createQuery("SELECT e FROM Employee e", Employee.class);
        List<Employee> le = q.getResultList();// java.util.List;

        if (!le.isEmpty()) {
            for (Employee employee : le) {
                System.out.println(employee);
            }
        } else {
            System.err.println("No Employee info found.");
        }

        ses.close();
        sef.close();
    }
}
