package org.jsp.jpa_proj;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MerchantByPhone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Phone no:");
        long ln = sc.nextLong();

        EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
        EntityManager man = fac.createEntityManager();

        Query q = man.createQuery("SELECT m FROM Merchant m WHERE m.phone = ?1");
        q.setParameter(1, ln);

        List<Merchant> lm = q.getResultList();

        if (!lm.isEmpty()) {
            for (Merchant merchant : lm) {
                System.out.println(merchant);
            }
        } else {
            System.err.println("No Merchant info found since phone is invalid");
        }

        man.close();
        fac.close();
        sc.close();
    }
}
