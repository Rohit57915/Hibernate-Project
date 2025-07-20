package manytoone_onetomany_bi_dir_proj;

import java.util.Scanner;
import javax.persistence.*;

public class VerifyMerchantByPhoneAndPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Phone Number:");
        Long ph = sc.nextLong();
        System.out.println("Enter the Password:");
        String pawd = sc.next();
        sc.close();

        EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
        EntityManager man = fac.createEntityManager();

        try {
            Query q = man.createQuery("SELECT m FROM Merchant m WHERE m.phone = :phone AND m.password = :password");
 
            q.setParameter("phone", ph);
            q.setParameter("password", pawd);

            Merchant mer = (Merchant) q.getSingleResult();
            System.out.println("Merchant Verified: " + mer);
        } 
        catch (NoResultException e) {
            System.err.println("Merchant Phone and Password not found.");
        }
        finally 
        {
            man.close();
            fac.close();
        }
    }
}
