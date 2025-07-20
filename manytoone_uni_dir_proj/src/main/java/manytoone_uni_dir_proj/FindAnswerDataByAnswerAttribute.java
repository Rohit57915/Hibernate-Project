package manytoone_uni_dir_proj;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAnswerDataByAnswerAttribute {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Answer??");
        String ans=sc.nextLine();
        sc.close();

        EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
        EntityManager man = fac.createEntityManager();

        Query q = man.createQuery("Select a from AnswerData a Where a.answer = ?1");
        q.setParameter(1, ans);

        try {
            AnswerData ad =(AnswerData) q.getSingleResult();
            System.out.println(ad);
        } catch (NoResultException e) {
            System.err.println("No AnswerData found for the given Answer");
        }
    }
}
