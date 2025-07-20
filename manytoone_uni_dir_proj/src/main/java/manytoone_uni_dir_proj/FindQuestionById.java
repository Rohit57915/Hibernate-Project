package manytoone_uni_dir_proj;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindQuestionById {
   public static void main(String[] args) {
       
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter the Questiondata Id??");
	   int qid=sc.nextInt();
	   sc.close();
	   
	   EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	   EntityManager man=fac.createEntityManager();
	   
	   QuestionData qd=man.find(QuestionData.class, qid);
	   
	   if(qd!=null)
	   {
		   System.out.println(qd);
	   }
	   else
	   {
		   System.err.println("NO QuestionData info Found");
	   }
}
}
