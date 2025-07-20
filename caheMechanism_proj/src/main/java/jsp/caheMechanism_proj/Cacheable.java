package jsp.caheMechanism_proj;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Cacheable {
   public static void main(String[] args) {
	
	   EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	   EntityManager man1=fac.createEntityManager();
	   EntityManager man2=fac.createEntityManager();
	   
	   man1.find(User.class, 1); //Hitting
	   man1.find(User.class, 1);
	   man2.find(User.class, 1); //Hitting
	   man2.find(User.class, 1);
}
}
