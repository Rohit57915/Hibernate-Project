package manytomany_bi_dir_proj;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FilterTheStudentBetweenPercentageRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First percentage range: ");
        double perc1 = sc.nextDouble();
        System.out.println("Enter the Second percentage range: ");
        double perc2 = sc.nextDouble();

        EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
        EntityManager man = fac.createEntityManager();

        Query q = man.createQuery("SELECT s FROM Student s WHERE s.perc BETWEEN ?1 AND ?2");
        q.setParameter(1, perc1);
        q.setParameter(2, perc2);

        List<Student> ls = q.getResultList();

        if (!ls.isEmpty()) {
            for (Student student : ls) {
                System.out.println(student);
            }
        } else {
            System.err.println("No students found between " + perc1 + " and " + perc2);
        }

        sc.close();
        man.close();
        fac.close();
    }
}
