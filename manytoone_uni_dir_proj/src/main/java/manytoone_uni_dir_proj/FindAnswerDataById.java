package manytoone_uni_dir_proj;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindAnswerDataById {
     public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		 System.out.println("Enter Id??");
		 int aid=sc.nextInt();
    	 
    	 EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
    	 EntityManager man=fac.createEntityManager();
    	 
    	 AnswerData a=man.find(AnswerData.class, aid);
    	 if(a!=null)
    	 {
    		 System.out.println(a);
    	 }
    	 else {
    		 System.err.println("No answerData info found");
    	 }
	}
}
