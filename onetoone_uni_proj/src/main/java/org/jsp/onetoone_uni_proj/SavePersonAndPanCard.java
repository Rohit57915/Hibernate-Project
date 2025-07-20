package org.jsp.onetoone_uni_proj;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePersonAndPanCard {
public static void main(String[] args) {
	  EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	  EntityManager man=fac.createEntityManager();
	  
	  EntityTransaction tran=man.getTransaction();
	  tran.begin();
	  
	  Person p=new Person();
	  p.setName("siddhu");
	  p.setPhone(1234567890l);

	  Pancard card=new Pancard();
	  card.setNumber("abc123");
	  card.setPincode(456212);
	  
	  p.setCard(card);
	  
	  man.persist(p);
	  man.persist(card);
	  tran.commit();
	  
}
}
