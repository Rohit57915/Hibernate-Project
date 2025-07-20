package manytoone_onetomany_bi_dir_proj;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindProductByMerchantGstNumber {
	public static void main(String[] args) {
		   
		  Scanner sc=new Scanner(System.in);
		  System.out.println("Enter the GST Number??");
		  String mgst=sc.next();
		  sc.close();
		  
		  EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		  EntityManager man=fac.createEntityManager();
		  
		  Query q=man.createQuery("Select m.product from Merchant m Where m.gst_num=?1");
		  q.setParameter(1,mgst);
		  
		  
		  List<Product> lp=q.getResultList();
		  if(lp.size()>0)
		  {
			for (Product product : lp) {
				System.out.println(product);
			}
		  }
		  else
		  {
			 System.err.println("NO Product Found since the Merchant GST_Number is Wrong "); 
		  }
	}
}
