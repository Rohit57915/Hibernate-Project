package jsp.compositekey_proj;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentInfo {
    public static void main(String[] args) {
        EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
        EntityManager man = fac.createEntityManager();
        EntityTransaction tran = man.getTransaction();
        tran.begin();

        MasterId mid = new MasterId();
        mid.setSid(2);
        mid.setCid(101);

        Master m = new Master();
        m.setMid(mid); 
        m.setSname("Raj");
        m.setCname("Java");

        man.persist(m);
        tran.commit();

        man.close();
        fac.close();
    }
}
