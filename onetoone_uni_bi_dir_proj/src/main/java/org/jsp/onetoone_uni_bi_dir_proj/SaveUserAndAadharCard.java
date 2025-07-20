package org.jsp.onetoone_uni_bi_dir_proj;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveUserAndAadharCard {
  public static void main(String[] args) {
     EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
     EntityManager man = fac.createEntityManager();
     EntityTransaction tran = man.getTransaction();
     tran.begin();
     
     User u = new User();
     u.setName("JayaParkash");
     u.setPhone(1234567890L);
     
     AadharCard card = new AadharCard();
     card.setAadharNo(452624524525l);
     card.setAddress("Bengaluru");
     
     // Set bidirectional references
     card.setUser(u);
     u.setCard(card);
     
     
     man.persist(u);
     man.persist(card);
     
     tran.commit();
     
     System.out.println("User and AadharCard saved successfully");
  }
}
