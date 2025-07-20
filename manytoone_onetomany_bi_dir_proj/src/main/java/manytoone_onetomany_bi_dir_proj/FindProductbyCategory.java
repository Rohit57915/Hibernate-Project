package manytoone_onetomany_bi_dir_proj;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindProductbyCategory {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the Product Category:");
	        String pcat = sc.next(); 
	        sc.close();

	        EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
	        EntityManager man = fac.createEntityManager();

	        Query q = man.createQuery("SELECT p FROM Product p WHERE p.category =?1");
	        q.setParameter(1, pcat);

	        List<Product> pl = q.getResultList();

	        if (pl.size() > 0) {
	            for (Product product : pl) {
					 System.out.println(product);
				}
	        }
	        else 
	        {
	            System.err.println("Product category is not Found");
	        }

	       
	        man.close();
	        fac.close();
	    }
}
