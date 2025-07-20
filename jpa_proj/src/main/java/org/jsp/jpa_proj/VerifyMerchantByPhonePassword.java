package org.jsp.jpa_proj;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VerifyMerchantByPhonePassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter phone number: ");
        long ph = sc.nextLong();
        
        System.out.print("Enter password: ");
        String pw = sc.next();
        
        EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
        EntityManager man = fac.createEntityManager();
        
        Query q = man.createQuery("SELECT m FROM Merchant m WHERE m.phone = ?1 AND m.password = ?2");
        q.setParameter(1, ph);
        q.setParameter(2, pw);
        
        try {
            Merchant m = (Merchant) q.getSingleResult();
            System.out.println("Merchant is verified: " + m.getName());
        } catch (NoResultException e) {
            System.err.println("Merchant is not verified.");
        }
        
        man.close();
        fac.close();
        sc.close();
    }
}
