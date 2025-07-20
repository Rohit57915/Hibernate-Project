package manytoone_onetomany_bi_dir_proj;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindProductByMerchantPhoneAndPassword {
  public static void main(String[] args) {
	   
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter the Phone Number??");
	  Long mph=sc.nextLong();
	  System.out.println("Enter the password??");
	  String mpasw=sc.next();
	  sc.close();
	  
	  EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	  EntityManager man=fac.createEntityManager();
	  
	  Query q=man.createQuery("Select m.product from Merchant m Where m.phone=?1 and m.password=?2");
	  q.setParameter(1,mph);
	  q.setParameter(2, mpasw);
	  
	  List<Product> lp=q.getResultList();
	  if(lp.size()>0)
	  {
		for (Product product : lp) {
			System.out.println(product);
		}
	  }
	  else
	  {
		 System.err.println("NO Product Found since the Merchant phone and Password is Wrong "); 
	  }
}
}
