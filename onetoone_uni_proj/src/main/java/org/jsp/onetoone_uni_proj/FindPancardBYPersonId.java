package org.jsp.onetoone_uni_proj;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPancardBYPersonId {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter person id");
        int pid = sc.nextInt();
        sc.close();

        EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
        EntityManager man = fac.createEntityManager();

        Query q = man.createQuery("Select p.card from Person p Where p.id = ?1");
        q.setParameter(1, pid);

        try {
            Pancard card = (Pancard) q.getSingleResult();
            System.out.println(card);
        } catch (NoResultException e) {
            System.err.println("Pancard info not found");
        }
    }
}
