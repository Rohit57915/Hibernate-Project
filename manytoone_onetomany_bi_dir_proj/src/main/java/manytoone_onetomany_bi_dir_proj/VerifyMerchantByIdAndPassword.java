package manytoone_onetomany_bi_dir_proj;

import java.util.Scanner;
import javax.persistence.*;

public class VerifyMerchantByIdAndPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Merchant Id:");
        int mid = sc.nextInt();
        System.out.println("Enter the Merchant Password:");
        String pasw = sc.next();
        sc.close();

        EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
        EntityManager man = fac.createEntityManager();

        try {
            Query q = man.createQuery("SELECT m FROM Merchant m WHERE m.id = :id AND m.password = :password");
            q.setParameter("id", mid);
            q.setParameter("password", pasw);

            Merchant mer = (Merchant) q.getSingleResult();
            System.out.println("Merchant Verified: " + mer);
        }
        catch (NoResultException e) 
        {
            System.err.println("Merchant ID and Password do not match.");
        }
        finally 
        {
            man.close();
            fac.close();
        }
    }
}
