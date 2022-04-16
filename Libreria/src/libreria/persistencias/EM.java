package libreria.persistencias;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public abstract class EM {
  
  protected final EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();

}
