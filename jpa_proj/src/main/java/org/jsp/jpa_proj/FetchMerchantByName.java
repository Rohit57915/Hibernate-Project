package org.jsp.jpa_proj;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchMerchantByName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name:");
        String nm = sc.next();

        EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
        EntityManager man = fac.createEntityManager();

        Query q = man.createQuery("SELECT m FROM Merchant m WHERE m.name = ?1");
        q.setParameter(1, nm);

        List<Merchant> lm = q.getResultList();

        if (!lm.isEmpty()) {
            for (Merchant merchant : lm) {
                System.out.println(merchant);
            }
        } else {
            System.err.println("No Merchant info found since name is invalid");
        }

        man.close();
        fac.close();
        sc.close();
    }
}
