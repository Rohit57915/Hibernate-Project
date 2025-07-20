package org.jsp.jpa_proj;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveMerchant {
 public static void main(String[] args) {
	  EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	  EntityManager man=fac.createEntityManager();
	  EntityTransaction tran=man.getTransaction();
	  tran.begin();
	  
	  Merchant m=new Merchant();
	  m.setName("DJ");
	  m.setPhone(9482205407l);
	  m.setGst_num("abc123");
	  m.setEmail("dj@gmail.com");
	  m.setPassword("pooja1234");
	  
	  man.persist(m);
	  tran.commit();
}
}
