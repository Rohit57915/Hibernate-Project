package manytoone_onetomany_bi_dir_proj;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindProductByMerchantId {
  public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter the Merchant Id ");
	  int mid=sc.nextInt();
	  
	  EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	  EntityManager man=fac.createEntityManager();
	  
	  Query q=man.createQuery("Select  m.product from Merchant m Where m.id=?1");
	  q.setParameter(1, mid);
	  
	  List<Product> lp=q.getResultList();
	  if(lp.size()>0)
	  {
		for (Product product : lp) {
			System.out.println(product);
		}
	  }
	  else
	  {
		 System.err.println("NO Product Found since the Merchant id is Wrong "); 
	  }
	 
}
}
