package libreria.persistencias;

import java.util.List;
import libreria.entidades.Libro;

public class LibroDAO extends EM {

  //Create, Update, Delete
  public void crearLibro(Libro aux) throws Exception {
    try {
      em.getTransaction().begin();
      em.persist(aux);
      em.getTransaction().commit();
    } catch (Exception e) {
      throw e;
    }
  }

  public void modificarLibro(Libro aux) throws Exception {
    try {
      if (aux == null) {
        throw new Exception("OBJETO NULO");
      }
      em.getTransaction().begin();
      em.merge(aux);
      em.getTransaction().commit();
    } catch (Exception e) {
      throw e;
    }
  }

  public void eliminarLibro(Libro aux) throws Exception {
    try {
      if (aux == null) {
        throw new Exception("OBJETO NULO");
      }
      em.getTransaction().begin();
      em.remove(aux);
      em.getTransaction().commit();
    } catch (Exception e) {
      throw e;
    }
  }

  //Read
  public Libro buscarISBN(Long aux) throws Exception {
    try {
      Libro aux2 = em.find(Libro.class, aux);
      if (aux2 == null) {
        throw new Exception("OBJETO NO ENCONTRADO");
      }
      return aux2;
    } catch (Exception e) {
      throw e;
    }
  }

  public Libro buscarNombre(String aux) throws Exception {
    try {
      Libro aux2 = (Libro) em.createQuery("SELECT a FROM Libro WHERE titulo LIKE :titulo").setParameter("titulo", aux).getSingleResult();
      if (aux2 == null) {
        throw new Exception("OBJETO NO ENCONTRADO");
      }
      return aux2;
    } catch (Exception e) {
      throw e;
    }
  }

  //List
  
  public List<Libro> listarLibros() throws Exception {
    try {
      List lista = em.createQuery("SELECT a FROM Autor a").getResultList();
      if (lista.isEmpty()) {
        throw new Exception("LISTA VACIA");
      }
      return lista;
    } catch (Exception e) {
      throw e;
    }
  }
}
