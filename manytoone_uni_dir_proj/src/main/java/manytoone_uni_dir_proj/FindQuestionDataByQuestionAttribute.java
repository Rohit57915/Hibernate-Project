package manytoone_uni_dir_proj;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindQuestionDataByQuestionAttribute {
   public static void main(String[] args) {
	   
	 Scanner sc=new Scanner(System.in);
	 System.out.println("Enter the Question??");
	 String ques=sc.nextLine();
	 sc.close();
	   
	EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	EntityManager man=fac.createEntityManager();
	
	Query q=man.createQuery("Select q from QuestionData q Where q.question=?1");
	q.setParameter(1, ques);
	
	try {
		QuestionData qd = (QuestionData) q.getSingleResult();
		System.out.println(qd);
	} 
	catch (NoResultException e) {
		System.err.println("No Data Found with respect to this question");
	}
	
}
}
