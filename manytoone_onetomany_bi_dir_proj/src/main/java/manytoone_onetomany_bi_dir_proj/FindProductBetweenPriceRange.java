package manytoone_onetomany_bi_dir_proj;

import java.util.List;
import java.util.Scanner;
import javax.persistence.*;

public class FindProductBetweenPriceRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the min cost:");
        double min = sc.nextDouble();
        System.out.println("Enter the max cost:");
        double max = sc.nextDouble();
        sc.close();

        EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
        EntityManager man = fac.createEntityManager();

        try {
            Query q = man.createQuery("SELECT p FROM Product p WHERE p.cost BETWEEN ?1 AND ?2");
            q.setParameter(1, min);
            q.setParameter(2, max);

            List<Product> pl = q.getResultList();

            if (pl.isEmpty()) 
            {
                System.err.println("No products found in the given price range.");
            } 
            else {
                for (Product p : pl) 
                {
                    System.out.println(p);
                }
            }
        } 
        finally {
            man.close();
            fac.close();
        }
    }
}
