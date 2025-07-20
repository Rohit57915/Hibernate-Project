package jsp.swiggy_proj;

import java.time.LocalDateTime;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateOrder {
   public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter order id to update the order :");
	  int ord=sc.nextInt();
	  sc.close();
	  
	  EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	  EntityManager man=fac.createEntityManager();
	  EntityTransaction tran=man.getTransaction();
	  tran.begin();
	  
	  FoodOrder fo=man.find(FoodOrder.class, ord);
	  if(fo!=null)
	  {
		  fo.setFood_item("GobiBiryani");
		  fo.setCost(140);
		  fo.setDeliveryTime(LocalDateTime.now().plusMinutes(30));
		  tran.commit();
	  }
	  else
	  {
		  System.err.println("Food Order is Not Update");
	  }
}
}
