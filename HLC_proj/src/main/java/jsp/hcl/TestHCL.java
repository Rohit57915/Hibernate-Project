package jsp.hcl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestHCL {
      public static void main(String[] args) {
		User u=new User();
		u.setName("Java");
		u.setEmailId("java@gmail.com");
		
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		EntityTransaction tran=man.getTransaction();
		tran.begin();
		
		man.persist(u); // Persistence State
		tran.commit();
		
		tran.begin();
		u.setName("Parkash");
		u.setEmailId("parkash@gmail.com");
		tran.commit();
		
		tran.begin();
		man.detach(u); //Detached State
		tran.commit();
		
		tran.begin();
		u.setName("Ashish");
		u.setEmailId("ashish@gmail.com");
		tran.commit();
		
		tran.begin();
		man.remove(u);
		tran.commit();
		
	}
}
