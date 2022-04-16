package libreria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Libreria {

 public static void main(String[] args) {
    try {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
      EntityManager em = emf.createEntityManager();
   } catch (Exception e) {
     throw e;
   }
  }
  
}
