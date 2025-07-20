package manytoone_uni_dir_proj;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAnswerDataByQuestionAttribute {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Question?");
        String qes = sc.nextLine();
        sc.close();

        EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
        EntityManager man = fac.createEntityManager();

        Query q = man.createQuery("SELECT a FROM AnswerData a WHERE a.q.question = ?1");
        q.setParameter(1, qes);

        List<AnswerData> answers = q.getResultList();
        if (!answers.isEmpty()) {
            for (AnswerData a : answers) {
                System.out.println(a);
            }
        } else {
            System.err.println("No answers found for the given question.");
        }
    }
}
