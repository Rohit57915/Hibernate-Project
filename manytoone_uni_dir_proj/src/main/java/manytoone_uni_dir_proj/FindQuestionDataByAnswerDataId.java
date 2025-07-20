package manytoone_uni_dir_proj;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindQuestionDataByAnswerDataId {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the AnswerData Id??");
        int aid = sc.nextInt();
        sc.close();

        EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
        EntityManager man = fac.createEntityManager();

        Query q = man.createQuery("Select a.q from AnswerData a Where a.id = ?1");
        q.setParameter(1, aid);

        try {
            QuestionData qs = (QuestionData) q.getSingleResult();
            System.out.println(qs);
        } catch (NoResultException e) {
            System.err.println("No AnswerData found for the given ID.");
        }
    }
}
