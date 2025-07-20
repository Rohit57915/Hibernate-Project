package manytoone_onetomany_bi_dir_proj;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindMerchantByName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Merchant Name:");
        String mnm = sc.next(); 

        EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
        EntityManager man = fac.createEntityManager();

        Query q = man.createQuery("SELECT m FROM Merchant m WHERE m.name = :name");
        q.setParameter("name", mnm);

        List<Merchant> lm = q.getResultList();

        if (lm.size() > 0) {
            for (Merchant merchant : lm) {
                System.out.println(merchant);
            }
        }
        else 
        {
            System.err.println("Merchant name does not match.");
        }

        sc.close();
        man.close();
        fac.close();
    }
}
