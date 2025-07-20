package manytomany_bi_dir_proj;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindBatchbyBatchId {
	public static void main(String[] args) {
	  	  Scanner sc=new Scanner(System.in);
	  	  System.out.println("Enter the Batch Id :");
	  	  int bid=sc.nextInt();
	  	  sc.close();
	  	  
	  	  EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	  	  EntityManager man=fac.createEntityManager();
	  	  
	  	  Batch b=man.find(Batch.class, bid);
	  	  
	  	  if(b!=null)
	  	  {
	  		  System.out.println(b);
	  	  }
	  	  else {
	  		  System.err.println("No Batch Info Found");
	  	  }
		}
}
