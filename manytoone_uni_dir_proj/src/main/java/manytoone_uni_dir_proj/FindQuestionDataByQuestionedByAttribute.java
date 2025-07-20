package manytoone_uni_dir_proj;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindQuestionDataByQuestionedByAttribute {
 public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	 System.out.println("Enter the QuestionBy??");
	 String ques=sc.next();
	 sc.close();
	 
	 EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	 EntityManager man=fac.createEntityManager();
	 
	 Query q=man.createQuery("Select q from QuestionData q Where q.questionedBy=?1");
	 q.setParameter(1, ques);
	 
	 List<QuestionData> ql=q.getResultList();
	 if(ql.size()>0)
	 {
		 for (QuestionData questionData : ql) {
			System.out.println(questionData);
		}
	 }
	 else {
		 System.err.println(" QuestionBy info Do not Find");
	 }
}
}
