package libreria.persistencias;

import java.util.List;
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
      Autor aux2 = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.name LIKE :name").setParameter("name", aux).getSingleResult();
      if(aux2 == null) throw new Exception("NO SE HA ENCONTRADO EL AUTOR");
      return aux2;
    } catch (Exception e) {
      throw e;
    }
  }
  
  public List<Autor> listarAutores() {
    try {
      List lista = em.createQuery("SELECT a FROM Autor a").getResultList();
      return lista;
    } catch (Exception e) {
      throw e;
    }
  }
}
