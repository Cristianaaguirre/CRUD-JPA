package libreria.services;

import java.util.List;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;

public class MenuLibro {

  private final LibroServices lServices;
  private final AutorService aService;
  private final EditorialServices eService;
  
  private final Scanner sc = new Scanner(System.in).useDelimiter("\n");

  public MenuLibro() {
    this.lServices = new LibroServices();
    this.eService = new EditorialServices();
    this.aService = new AutorService();
  }

  public void abrirMenu() throws Exception {
    try {
      boolean close = false;
      do {
        String aux = "=======================" + "\n"
                + "==  Menu Editoriales ==" + "\n"
                + "=======================" + "\n"
                + "==  1-Crear Libro   ==" + "\n"
                + "==  2-Buscar Libro  ==" + "\n"
                + "==  3-Lista          ==" + "\n"
                + "==  4-Nombres        ==" + "\n"
                + "==  5-Autores        ==" + "\n"
                + "==  6-Editores       ==" + "\n"
                + "==  7-Prestados      ==" + "\n"
                + "==  8-Restantes      ==" + "\n"
                + "==  9-Volver al Menu ==" + "\n"
                + "=======================";
        System.out.println(aux);
        System.out.print("Opcion: ");
        int opcion = sc.nextInt();
        switch (opcion) {
          case 1:
            crearLibro();
            break;
          case 2:
            buscarLibro();
            break;
          case 3:
            listarEjemplares();
            break;
          case 4:
            listarPorNombre();
            break;
          case 5:
            listarPorAutores();
            break;
          case 6:
            listarPorEditores();
            break;
          case 7:
            listarLibrosPrestados();
            break;
          case 8:
            listarLibrosRestantes();
            break;
          case 9:
            System.out.println("Adios");
            close = true;
            break;
        }
      } while (close != true);
    } catch (Exception e) {
      throw e;
    }
  }

  public void crearLibro() throws Exception {
    try {
      //datos
      System.out.print("Isbn: ");
      long id = sc.nextInt();
      System.out.print("Titulo: ");
      String titulo = sc.next();
      System.out.print("Anio: ");
      int anio = sc.nextInt();
      System.out.print("Ejemplares: ");
      int ejemplares = sc.nextInt();
      System.out.print("Ejemplares prestados: ");
      int ejemplaresPrestados = sc.nextInt();
      System.out.print("Ejemplares restantes: ");
      int ejemplaresRestantes = sc.nextInt();
      System.out.print("Alta: ");
      boolean alta = sc.nextBoolean();
      //datos autores y editor
      System.out.print("Autor, buscar por ID: ");
      Autor autor = aService.buscarID(sc.nextInt());
      System.out.print("Editor, buscar por ID: ");
      Editorial editor = eService.buscarEditorPorID(sc.nextInt());
      //Validaciones
      if(titulo.trim().isEmpty()) throw new Exception("CADENA VACIA");
      if(id < 0 || anio < 0 || ejemplares < 0 || ejemplaresPrestados < 0 || ejemplaresRestantes < 0) throw new Exception("DATOS NUMERICOS INVALIDOS");
      lServices.crearLibro(id, titulo, anio, ejemplares, ejemplares, ejemplares, alta, autor, editor);
    } catch (Exception e) {
      throw e;
    }
  }

  public void buscarLibro() throws Exception {
    try {
      System.out.print("Buscar por ID: ");
      long aux = sc.nextLong();
      if (aux < 0) throw new Exception("NUMERO INVALIDO");
      lServices.buscarISBN(aux);
    } catch (Exception e) {
      throw e;
    }
  }

  public void listarEjemplares() throws Exception {
    try {
      List aux = lServices.listarEjemplares();
      aux.forEach(aux2 -> {
        System.out.println(aux2);
      });
    } catch (Exception e) {
      throw e;
    }
  }
  
  public void listarPorNombre() throws Exception {
    try {
      List<Libro> lista = lServices.listarEjemplares();
      lista.forEach(aux -> {
        System.out.println(aux.getTitulo());
      });
    } catch (Exception e) {
      throw e;
    }
  }
  
  public void listarPorEditores() throws Exception {
    try {
      List<Libro> list = lServices.listarEjemplares();
      System.out.print("Nombre de la editorial: ");
      String aux2 = sc.next();
      if(eService.buscarEditorPorNombre(aux2) == null) throw new Exception("NO SE PUDO ENCONTRAR LA EDITORIAL");
      list.stream().filter(aux -> aux2.equals(aux.getEditorial().getName()));
    } catch (Exception e) {
      throw e;
    }
  }
  
  public void listarPorAutores() throws Exception {
    try {
      List<Libro> list = lServices.listarEjemplares();
      System.out.print("Nombre del autor: ");
      String aux2 = sc.next();
      if(aService.buscarAutor(aux2) == null) throw new Exception("NO SE PUDO ENCONTRAR EL AUTOR");
      list.stream().filter(aux -> aux2.equals(aux.getAutor().getName()));
    } catch (Exception e) {
      throw e;
    }
  }
  
  public void listarLibrosPrestados() throws Exception {
    try {
      List<Libro> lista = lServices.listarEjemplares();
      lista.stream().filter(libro -> libro.getAlta() == true);
      lista.forEach(aux -> {
        System.out.println(aux);
      });
    } catch (Exception e) {
      throw e;
    }
  }
  
  public void listarLibrosRestantes() throws Exception {
    try {
      List<Libro> lista = lServices.listarEjemplares();
      lista.stream().filter(libro -> libro.getAlta() == false);
      lista.forEach(aux -> {
        System.out.println(aux);
      });
    } catch (Exception e) {
      throw e;
    }
  }

  public void eliminarAutor() throws Exception {
    try {
      System.out.print("Elegir el autor por su ID: ");
      long aux = sc.nextLong();
      if (aux < 0)throw new Exception("NUMERO INVALIDO");
      lServices.eliminarLibro(aux);
    } catch (Exception e) {
      throw e;
    }
  }
}
