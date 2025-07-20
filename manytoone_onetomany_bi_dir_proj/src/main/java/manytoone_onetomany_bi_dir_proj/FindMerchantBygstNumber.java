package manytoone_onetomany_bi_dir_proj;

import java.util.Scanner;
import javax.persistence.*;

public class FindMerchantBygstNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the GST Number:");
        String mgst = sc.next();
        sc.close();

        EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
        EntityManager man = fac.createEntityManager();

        try {
            Query q = man.createQuery("SELECT m FROM Merchant m WHERE m.gst_num = :gst_num");
            q.setParameter("gst_num", mgst);

            Merchant m = (Merchant) q.getSingleResult();
            System.out.println(m);
        } catch (NoResultException e) {
            System.err.println("No merchant found with given GST Number.");
        } finally {
            man.close();
            fac.close();
        }
    }
}
