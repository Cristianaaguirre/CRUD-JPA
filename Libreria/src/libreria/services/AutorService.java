package libreria.services;

import java.util.List;
import libreria.entidades.Autor;
import libreria.persistencias.AutorDAO;

public class AutorService {

  private final AutorDAO aDao;

  public AutorService() {
    this.aDao = new AutorDAO();
  }

  public void crearAutor(Integer id, String name, Boolean alta) throws Exception {
    try {
      if (aDao.buscarPorID(id) != null) {
        throw new Exception("EL ID YA SE ENCUENTRA EN USO");
      }
      if (name.trim().isEmpty()) {
        throw new Exception("CADENA VACIA");
      }
      Autor aux = new Autor(id, name.toUpperCase(), alta);
      aDao.crearAutor(aux);
    } catch (Exception e) {
      throw e;
    }
  }

  public Autor buscarAutor(String aux) throws Exception {
    try {
      if (aux.trim().isEmpty()) {
        throw new Exception("CADENA VACIA");
      }
      Autor autor = aDao.buscarPorNombre(aux.toUpperCase());
      return autor;
    } catch (Exception e) {
      throw e;
    }
  }

  public Autor buscarID(Integer aux) throws Exception {
    try {
      if (aux < 0) {
        throw new Exception("NUMERO NEGATIVO");
      }
      Autor autor = aDao.buscarPorID(aux);
      return autor;
    } catch (Exception e) {
      throw e;
    }
  }
  
  public List<Autor> listarAutores() throws Exception {
    try {
      if(aDao.listarAutores() == null) throw new Exception("LA LISTA ESTA VACIA");
      List lista = aDao.listarAutores();
      return lista;
    } catch (Exception e) {
      throw e;
    }
  }
  
  public void listarNombresAutores() throws Exception{
    try {
      if(aDao.listarAutores() == null) throw new Exception("LISTA VACIA");
      aDao.listarAutores().forEach((aux) -> {
          System.out.println(aux.getName());
      });
    } catch (Exception e) {
      throw e;
    }
  }
  
  public void actualizarNombreAutor(Integer id, String name) throws Exception {
    try {
      if (aDao.buscarPorID(id) == null) {
        throw new Exception("OBJETO NO ENCONTRADO");
      }
      Autor aux2 = aDao.buscarPorID(id);
      aux2.setName(name.toUpperCase());
      aDao.actualizarAutor(aux2);
    } catch (Exception e) {
      throw e;
    }
  }

  public void actualizarAltaAutor(Integer id, Boolean alta) throws Exception {
    try {
      if (aDao.buscarPorID(id) == null) {
        throw new Exception("OBJETO NO ENCONTRADO");
      }
      Autor aux2 = aDao.buscarPorID(id);
      aux2.setAlta(alta);
      aDao.actualizarAutor(aux2);
    } catch (Exception e) {
      throw e;
    }
  }
  
  public void eliminarAutor(Integer aux) throws Exception {
    try {
      if(aux < 0) throw new Exception("NUMERO INVALIDO");
      if(aDao.buscarPorID(aux) == null) throw new Exception("NO SE HA ENCONTRADO EL AUTOR");
      Autor aux2 = aDao.buscarPorID(aux);
      aDao.eliminarAutor(aux2);
    } catch (Exception e) {
      throw e;
    }
  }
}
