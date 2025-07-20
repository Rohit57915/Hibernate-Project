package manytomany_uni_dir_proj;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindBatchByBatchCode {
   public static void main(String[] args) {
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter batch_code");
	   String bc=sc.next();
	   
	    EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	    EntityManager man=fac.createEntityManager();
	    	    
	    Query q=man.createQuery("Select b from Batch b Where b.batch_code=?1");
	    q.setParameter(1, bc);
	    
	    try {
			Batch b = (Batch) q.getSingleResult();
			System.out.println(b);
		} catch (NoResultException e) {
			System.err.println("No Batch found with Batch Code");
		}
	    sc.close();
	    man.close();
	    fac.close();
}
}
