package manytoone_onetomany_bi_dir_proj;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindMerchantByProductId {
   public static void main(String[] args) {
	
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter the Product Id??");
	   int pid=sc.nextInt();
	   sc.close();
	   
	   EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	   EntityManager man=fac.createEntityManager();
	   
	   try {
		Query q = man.createQuery("Select p.merchant from Product p Where p.id=?1");
		q.setParameter(1, pid);
		Merchant m = (Merchant) q.getSingleResult();
		System.out.println(m);
	} 
	   catch (NoResultException e)
	   {
		System.err.println("Product Id Is not Match");
	}
	   finally {
		   man.close();
		   fac.close();
	   }
		
}
}
