package org.jsp.onetoone_uni_proj;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPancardByPersonPhone {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter person Phone no");
	        long pnm = sc.nextLong();
	        sc.close();

	        EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
	        EntityManager man = fac.createEntityManager();

	        Query q = man.createQuery("Select p.card from Person p Where p.phone = ?1");
	        q.setParameter(1, pnm);

	        try {
	            Pancard card = (Pancard) q.getSingleResult();
	            System.out.println(card);
	        } catch (NoResultException e) {
	            System.err.println("Pancard Number info not found");
	        }
	    }
}
