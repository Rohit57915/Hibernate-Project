package manytomany_uni_dir_proj;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindBatchByTrainerName {
	public static void main(String[] args) {
		
		  Scanner sc=new Scanner(System.in);
		  System.out.println("Enter the Trainer Name: ");
		  String tr=sc.next();
		  
		  
		  EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		  EntityManager man=fac.createEntityManager();
		  
		  Query q=man.createQuery("Select b from Batch b Where b.trainer=?1");
		  q.setParameter(1, tr);
		  List<Batch> lb=q.getResultList();
		  
		  if (lb.size() > 0) {
	          for (Batch batch : lb) {
	              System.out.println(batch);
	          }
	      }
	      else 
	      {
	          System.err.println("Batch Info not found");
	      }

	      sc.close();
	      man.close();
	      fac.close();
	}
}
