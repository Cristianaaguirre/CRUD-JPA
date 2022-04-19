package libreria.services;

import java.util.ArrayList;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencias.AutorDAO;
import libreria.persistencias.EditorialDAO;
import libreria.persistencias.LibroDAO;

public class LibroServices {

  private final LibroDAO lDAO;
  private final AutorDAO aDAO;
  private final EditorialDAO eDAO;

  public LibroServices() {
    this.lDAO = new LibroDAO();
    this.eDAO = new EditorialDAO();
    this.aDAO = new AutorDAO();
  }

  public void crearLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejPrestados, Integer ejRestantes, Boolean alta, Autor autor, Editorial editorial) throws Exception {
    try {
      if (isbn < 0 || anio < 0 || ejemplares < 0 || ejPrestados < 0 || ejRestantes < 0) {
        throw new Exception("DATOS NUMERICOS INVALIDOS");
      }
      if (titulo.trim().isEmpty()) {
        throw new Exception("CADENA VACIA");
      }
      if (editorial == null || autor == null) {
        throw new Exception("AUTOR O EDITORIAL INVALIDOS");
      }
      Libro aux = new Libro(isbn, titulo, anio, ejemplares, ejPrestados, ejRestantes, alta, autor, editorial);
      if (aux == null) {
        throw new Exception("OBJETO NULO");
      }
      lDAO.crearLibro(aux);
    } catch (Exception e) {
      throw e;
    }
  }
  
  public void modificarAlta(Long isbn, Boolean aux) throws Exception{
    try {
      if(!"Boolean".equals(aux.getClass().getSimpleName())) throw new Exception("DATO INCORRECTO");
      Libro aux2 = lDAO.buscarISBN(isbn);
      aux2.setAlta(aux);
      lDAO.modificarLibro(aux2);
    } catch (Exception e) {
      throw e;
    }
  }
  
  public void eliminarLibro(Long isbn) throws Exception {
    try {
      Libro aux = lDAO.buscarISBN(isbn);
      lDAO.eliminarLibro(aux);
    } catch (Exception e) {
      throw e;
    }
  }
  
  public Libro buscarISBN(Long aux) throws Exception {
    try {
      if (aux < 0) {
        throw new Exception("NUMERO INVALIDO");
      }
      Libro aux2 = lDAO.buscarISBN(aux);
      return aux2;

    } catch (Exception e) {
      throw e;
    }
  }

  public Libro buscarNombre(String aux) throws Exception {
    try {
      if (aux.trim().isEmpty()) {
        throw new Exception("CADENA VACIA");
      }
      Libro aux2 = lDAO.buscarNombre(aux);
      return aux2;
    } catch (Exception e) {
      throw e;
    }
  }

  public ArrayList<Libro> buscarPorAutor(String aux) throws Exception {
    try {
      if (aux.trim().isEmpty()) {
        throw new Exception("CADENA VACIA");
      }
      if (aDAO.buscarPorNombre(aux) == null) {
        throw new Exception("AUTOR NO ENCONTRADO");
      }
      ArrayList<Libro> lista = new ArrayList();
      for (Libro libro : lDAO.listarLibros()) {
        if (aux.equals(libro.getAutor().getName())) {
          lista.add(libro);
        }
      }
      if (lista.isEmpty()) {
        throw new Exception("NO HAY LIBROS DE ESTE AUTOR");
      }
      return lista;
    } catch (Exception e) {
      throw e;
    }
  }

  public ArrayList<Libro> buscarPorEditorial(String aux) throws Exception {
    try {
      if (aux.trim().isEmpty()) {
        throw new Exception("CADENA INVALIDA");
      }
      if (eDAO.buscarNombre(aux) == null) {
        throw new Exception("EDITORIAL NO ENCONTRADA");
      }
      ArrayList<Libro> lista = new ArrayList();
      for (Libro libro : lDAO.listarLibros()) {
        if (aux.equals(libro.getEditorial().getName())) {
          lista.add(libro);
        }
      }
      if (lista.isEmpty()) {
        throw new Exception("NO HAY LIBROS DE ESTA EDITORIAL");
      }
      return lista;
    } catch (Exception e) {
      throw e;
    }
  }
  
  public ArrayList<Libro> listarEjemplares () throws Exception {
    try {
      ArrayList lista =  (ArrayList) lDAO.listarLibros();
      return lista;
    } catch (Exception e) {
      throw e;
    }
  }
  
}
