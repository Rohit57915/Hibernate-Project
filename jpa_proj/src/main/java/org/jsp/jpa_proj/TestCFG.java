package org.jsp.jpa_proj;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestCFG {
   public static void main(String[] args) {
	 EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	 System.out.println(fac);
}
}
