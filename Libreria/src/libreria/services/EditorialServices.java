package libreria.services;

import java.util.List;
import libreria.entidades.Editorial;
import libreria.persistencias.EditorialDAO;

public class EditorialServices {

  private final EditorialDAO eDAO;

  public EditorialServices() {
    this.eDAO = new EditorialDAO();
  }

  public void crearUnaEditorial(Integer id, String name, Boolean alta) throws Exception {
    try {
      if (eDAO.buscarID(id) != null) {
        throw new Exception("EL ID YA SE ENCUENTRA REGISTRADO");
      }
      if (name.trim().isEmpty()) {
        throw new Exception("CADENA VACIA");
      }

      Editorial aux = new Editorial(id, name, alta);
      eDAO.crearEditor(aux);
    } catch (Exception e) {
      throw e;
    }
  }

  public void actualizarNombreEditorial(Integer id, String name) throws Exception {
    try {
      if (eDAO.buscarID(id) == null) {
        throw new Exception("OBJETO NO ENCONTRADO");
      }
      Editorial aux2 = eDAO.buscarID(id);
      aux2.setName(name.toUpperCase());
      eDAO.actualizarEditor(aux2);
    } catch (Exception e) {
      throw e;
    }
  }

  public void actualizarAltaEditor(Integer id, Boolean alta) throws Exception {
    try {
      if (eDAO.buscarID(id) == null) {
        throw new Exception("OBJETO NO ENCONTRADO");
      }
      Editorial aux2 = eDAO.buscarID(id);
      aux2.setAlta(alta);
      eDAO.actualizarEditor(aux2);
    } catch (Exception e) {
      throw e;
    }
  }
  
  public Editorial buscarEditorPorNombre(String aux) throws Exception {
    try {
      if (aux.trim().isEmpty()) {
        throw new Exception("CADENA VACIA");
      }
      if(eDAO.buscarNombre(aux) == null) throw new Exception("OBJETO NO ENCONTRADO");
      Editorial autor = eDAO.buscarNombre(aux.toUpperCase());
      return autor;
    } catch (Exception e) {
      throw e;
    }
  }

  public Editorial buscarEditorPorID(Integer aux) throws Exception {
    try {
      if (aux < 0) {
        throw new Exception("NUMERO NEGATIVO");
      }
      if(eDAO.buscarID(aux) == null) throw new Exception("OBJETO NO ENCONTRADO");
      Editorial autor = eDAO.buscarID(aux);
      return autor;
    } catch (Exception e) {
      throw e;
    }
  }
  
  public List<Editorial> listarEditoriales() throws Exception {
    try {
      List lista = eDAO.listarEditoriales();
      if(lista.isEmpty()) throw new Exception("LISTA VACIA");
      return lista;
    } catch (Exception e) {
      throw e;
    }
  }
  
  public void listarNombreEditorials() throws Exception {
    try {
      if(eDAO.listarEditoriales()==null) throw new Exception("LISTA VACIA");
      eDAO.listarEditoriales().forEach((aux) -> {
        System.out.println(aux.getName());
      });
    } catch (Exception e) {
      throw e;
    }
  }
  
  public void eliminarEditorial(Integer aux) throws Exception{
    try {
      if(aux < 0) throw new Exception("NUMERO INVALIDO");
      if(eDAO.buscarID(aux) == null) throw new Exception("OBJETO NO ENCONTRADO");
      Editorial aux2 = eDAO.buscarID(aux);
      eDAO.eliminarEditor(aux2);
    } catch (Exception e) {
      throw e;
    }
  }
}
