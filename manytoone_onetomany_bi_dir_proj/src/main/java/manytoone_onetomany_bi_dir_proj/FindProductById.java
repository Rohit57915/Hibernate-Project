package manytoone_onetomany_bi_dir_proj;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindProductById {
   public static void main(String[] args) {
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter the Product Id??");
	   int pid=sc.nextInt();
	   
	   EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	   EntityManager man=fac.createEntityManager();
	   
	   Product p=man.find(Product.class,pid);
	   
	   if(p!=null)
	   {
		   System.out.println(p);
	   }
	   else
	   {
		   System.err.println("Product Id Do Not Exist");
	   }
	   
	}
}
