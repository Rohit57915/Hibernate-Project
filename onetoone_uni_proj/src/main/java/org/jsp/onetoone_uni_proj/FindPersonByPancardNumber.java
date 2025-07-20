package org.jsp.onetoone_uni_proj;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPersonByPancardNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter pancard Number:");
        String snm=sc.next();
        sc.close();

        EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
        EntityManager man = fac.createEntityManager();

        Query q = man.createQuery("Select p from Person p Where p.card.number = ?1");
        q.setParameter(1, snm);

        try {
            Person person = (Person) q.getSingleResult();
            System.out.println(person);
        } catch (NoResultException e) {
            System.err.println("No Person found for the given Pancard number.");
        }
    }
}
