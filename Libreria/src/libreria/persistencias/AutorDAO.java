package libreria.persistencias;

import libreria.entidades.Autor;

public class AutorDAO extends EM {

  public void crearAutor(Autor aux) throws Exception {
    try {
      if (aux == null) {
        throw new Exception("AUTOR NULO");
      }
      em.getTransaction().begin();
      em.persist(aux);
      em.getTransaction().commit();
    } catch (Exception e) {
      throw e;
    }
  }

  public void actualizarAutor(Autor aux) throws Exception {
    try {
      if (aux == null) {
        throw new Exception("AUTOR NULO");
      }
      em.getTransaction().begin();
      em.merge(aux);
      em.getTransaction().commit();
    } catch (Exception e) {
      throw e;
    }
  }

  public void eliminarAutor(Autor aux) throws Exception {
    try {
      if (aux == null) {
        throw new Exception("AUTOR NULO");
      }
      em.getTransaction().begin();
      em.remove(aux);
      em.getTransaction().commit();
    } catch (Exception e) {
      throw e;
    }
  }
  
  public Autor buscarPorID(Integer aux) throws Exception {
    try {
      if(aux < 0) throw new Exception("NUMERO INVALIDO");
      Autor aux2 = em.find(Autor.class, aux);
      return aux2;
    } catch (Exception e) {
      throw e;
    }
  }
  
  public Autor buscarPorNombre(String aux) throws Exception {
    try {
      if(aux.trim().isEmpty()) throw new Exception("CADENA VACIA");
      Autor aux2 = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.name LIKE :name").setParameter("name", aux).getSingleResult();
      return aux2;
    } catch (Exception e) {
      throw e;
    }
  }
}
