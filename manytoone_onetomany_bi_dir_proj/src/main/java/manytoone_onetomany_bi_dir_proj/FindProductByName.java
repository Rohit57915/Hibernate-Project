package manytoone_onetomany_bi_dir_proj;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class FindProductByName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Product Name:");
        String pnm = sc.next();
        sc.close();

        EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
        EntityManager man = fac.createEntityManager();

        try {
            Query q = man.createQuery("SELECT p FROM Product p WHERE p.name = ?1");
            q.setParameter(1, pnm);

            List<Product> pl = q.getResultList();

            if (pl.isEmpty())
            {
                System.err.println("No product found with that name.");
            } 
            else 
            {
                for (Product p : pl) 
                {
                    System.out.println(p);
                }
            }

        } 
        finally 
        {
            man.close();
            fac.close();
        }
    }
}
