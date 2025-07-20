package manytoone_uni_dir_proj;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveQuestionDataAndAnswerData {
   public static void main(String[] args) {
	
	EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	EntityManager man=fac.createEntityManager();
	EntityTransaction tran=man.getTransaction();
	tran.begin();
	
	QuestionData qdata=new QuestionData();
	qdata.setQuestion("What is the important thing in your life?");
	qdata.setQuestionedBy("Guru");
	
	AnswerData a1=new AnswerData();
	a1.setAnswer("Money");
	a1.setAnsweredBy("Rezvi");
	a1.setQ(qdata);
	
	AnswerData a2=new AnswerData();
	a2.setAnswer("Rating");
	a2.setAnsweredBy("saurin");
	a2.setQ(qdata);
	
	AnswerData a3=new AnswerData();
	a3.setAnswer("Family");
	a3.setAnsweredBy("Parveen");
	a3.setQ(qdata);
	
	man.persist(a1);
	man.persist(a2);
	man.persist(a3);
	
	
	tran.commit();
  }
}
