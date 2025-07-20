package jsp.compositekey_proj;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchStudentInfo {
     public static void main(String[] args) {
		  
    	 EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
    	 EntityManager man=fac.createEntityManager();
    	 
    	 MasterId sid=new MasterId();
    	 sid.setSid(2);
    	 sid.setCid(101);
    	 
    	 Master s=man.find(Master.class, sid);
    			 
    		 if(s!=null)
    		 {
    			System.out.println(s); 
    		 }
    		 else
    		 {
    			 System.err.println("No Student Info Found");
    		 }
    	
	}
}
