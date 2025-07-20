package manytoone_onetomany_bi_dir_proj;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveMerchantAndProduct {
    public static void main(String[] args) {
	
    	EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
    	EntityManager man=fac.createEntityManager();
    	EntityTransaction tran=man.getTransaction();
    	tran.begin();
    	
    	Merchant m=new Merchant();
    	m.setName("Adarsh");
    	m.setPhone(9988776655l);
    	m.setGst_num("ABCD123");
    	m.setEmail("adhi@gmail.com");
    	m.setPassword("adhi1234");
    	
    	Product p1=new Product();
    	p1.setName("Tv");
    	p1.setBrand("sony");
    	p1.setCategory("Electronics");
    	p1.setCost(25000);
    	p1.setMerchant(m);
    	
    	Product p2=new Product();
    	p2.setName("Mobile");
    	p2.setBrand("vivo");
    	p2.setCategory("Electronics");
    	p2.setCost(22000);
    	p2.setMerchant(m);
    	
    	Product p3=new Product();
    	p3.setName("Fan");
    	p3.setBrand("Usha");
    	p3.setCategory("Electrical");
    	p3.setCost(2000);
    	p3.setMerchant(m);
    	
    	m.setProduct(Arrays.asList(p1,p2,p3));
    	man.persist(m);
    	tran.commit();
	}
}
