package manytoone_uni_dir_proj;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAnswerDataByQuestionedByAttribute {
   
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the QuestionedBy?");
        String qes = sc.next();
        sc.close();

        EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
        EntityManager man = fac.createEntityManager();

        Query q = man.createQuery("SELECT a FROM AnswerData a WHERE a.q.questionedBy = ?1");
        q.setParameter(1, qes);

        List<AnswerData> lans = q.getResultList();
        if (!lans.isEmpty()) {
            for (AnswerData a : lans) {
                System.out.println(a);
            }
        } else {
            System.err.println("No answers found for the given questionedBy.");
        }
    }
}
