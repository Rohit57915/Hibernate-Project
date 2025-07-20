package manytoone_uni_dir_proj;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAnswerDataQuestionDataId {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the QuestionData Id??");
        int qid = sc.nextInt();
        sc.close();

        EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
        EntityManager man = fac.createEntityManager();

        Query q = man.createQuery("Select a from AnswerData a Where a.q.id = ?1");
        q.setParameter(1, qid);

        List<AnswerData> lans=q.getResultList();
        if(lans.size()>0)
        {
        	for (AnswerData answerData : lans) {
				System.out.println(answerData);
			}
        }
        else
        {
        	System.out.println("No AnswerData found for the given id");
        }
    }
}
