package libreria.persistencias;

import java.util.ArrayList;
import java.util.List;
import libreria.entidades.Editorial;

public class EditorialDAO extends EM {

  public void crearEditor(Editorial aux) throws Exception {
    try {
      if (aux == null) {
        throw new Exception("OBJETO INVALIDO");
      }
      em.getTransaction().begin();
      em.persist(aux);
      em.getTransaction().commit();
    } catch (Exception e) {
      throw e;
    }
  }

  public void actualizarEditor(Editorial aux) throws Exception {
    try {
      if (aux == null) {
        throw new Exception("OBJETO INVALIDO");
      }
      em.getTransaction();
      em.merge(aux);
      em.getTransaction().commit();
    } catch (Exception e) {
      throw e;
    }
  }
  
  public void eliminarEditor(Editorial aux) throws Exception {
    try {
      if (aux == null) {
        throw new Exception("OBJETO INVALIDO");
      }
      em.getTransaction().begin();
      em.remove(aux);
      em.getTransaction().commit();
    } catch (Exception e) {
      throw e;
    }
  }
  
  public Editorial buscarID(Integer aux) throws Exception {
    try {
      if (aux == null) {
        throw new Exception("OBJETO INVALIDO");
      }
      Editorial aux2 = em.find(Editorial.class, aux);
      return aux2;
    } catch (Exception e) {
      throw e;
    }
  }
  
  public Editorial buscarNombre(String aux) throws Exception {
    try {
      if (aux.trim().isEmpty()) {
        throw new Exception("CADENA VACIA");
      }
      Editorial aux2 = (Editorial) em.createQuery("SELECT e FROM Editorial WHERE name LIKE :name").setParameter("name", aux).getSingleResult();
      return aux2;
    } catch (Exception e) {
      throw e;
    }
  }
  
  public List<Editorial> listarEditoriales() throws Exception {
    try {
      List<Editorial> lista = em.createQuery("SELECT e FROM Editorial e").getResultList();
      if(lista == null || lista.isEmpty()) throw new Exception("LISTA VACIA");
      return lista;
    } catch (Exception e) {
      throw e;
    }
  }
}
