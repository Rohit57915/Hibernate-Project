package jsp.swiggy_proj;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PlaceOrder {
   public static void main(String[] args) {
	  EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	  EntityManager man=fac.createEntityManager();
	  EntityTransaction tran=man.getTransaction();
	  tran.begin();
	  
	  FoodOrder fo=new FoodOrder();
	  fo.setFood_item("Biryani");
	  fo.setCost(120);
	  LocalDateTime currTime=LocalDateTime.now();
	  LocalDateTime delTime=currTime.plusMinutes(30);
	  fo.setDeliveryTime(delTime);
	  
	  man.persist(fo);
	  tran.commit();
}
}
