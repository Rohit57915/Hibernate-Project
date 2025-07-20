package manytomany_bi_dir_proj;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveBatchsAndStudents {
   public static void main(String[] args) {
	  
	   EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	   EntityManager man=fac.createEntityManager();
	   EntityTransaction tran=man.getTransaction();
	   tran.begin();
	   
	   Batch b1=new Batch();
	   b1.setBatch_code("JavaB1");
	   b1.setSubject("Java");
	   b1.setTrainer("Abhishek");
	   
	   Batch b2=new Batch();
	   b2.setBatch_code("SQLB2");
	   b2.setSubject("SQL");
	   b2.setTrainer("krishana");
	   
	   Student s1=new Student();
	   s1.setName("JP");
	   s1.setPhone(9988776655l);
	   s1.setPerc(99.99);
		
	   Student s2=new Student();
	   s2.setName("Indu");
	   s2.setPhone(9988773655l);
	   s2.setPerc(88.99);
	   
	   Student s3=new Student();
	   s3.setName("surya");
	   s3.setPhone(9988778655l);
	   s3.setPerc(75.99);
	   
	   //Uni Directional
	   b1.setStudent(Arrays.asList(s1,s2,s3));
	   b2.setStudent(Arrays.asList(s1,s3));
	   
	   //Bi Directional
	   s1.setBatches(Arrays.asList(b1,b2));
	   s2.setBatches(Arrays.asList(b1));
	   s3.setBatches(Arrays.asList(b1,b2));
	   
	   man.persist(b1);
	   man.persist(b2);
	   
	   tran.commit();
  }
}
