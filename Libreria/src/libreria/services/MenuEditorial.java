package libreria.services;

import java.util.List;
import java.util.Scanner;

public class MenuEditorial {

  private final EditorialServices eServices;
  private final Scanner sc = new Scanner(System.in).useDelimiter("\n");
  
  public MenuEditorial() {
    this.eServices = new EditorialServices();
  }
  
  public void abrirMenu() throws Exception {
    try {
      boolean close = false;
      do {
        String aux = "=======================" + "\n"
                + "==  Menu Editoriales ==" + "\n"
                + "=======================" + "\n"
                + "==  1-Crear Editor   ==" + "\n"
                + "==  2-Buscar Editor  ==" + "\n"
                + "==  3-Lista          ==" + "\n"
                + "==  4-Nombres        ==" + "\n"
                + "==  5-Cambiar Nombre ==" + "\n"
                + "==  6-Eliminar       ==" + "\n"
                + "==  7-Volver al Menu ==" + "\n"
                + "=======================";
        System.out.println(aux);
        System.out.print("Opcion: ");
        int opcion = sc.nextInt();
        switch (opcion) {
          case 1:
            crearEditor();
            break;
          case 2:
            buscarEditor();
            break;
          case 3:
            listarAutores();
            break;
          case 4:
            eServices.listarNombreEditorials();
            break;
          case 5:
            cambiarNombre();
            break;
          case 6:
            eliminarAutor();
            break;
          case 7:
            System.out.println("Adios");
            close = true;
            break;
        }

      } while (close != true);
    } catch (Exception e) {
      throw e;
    }
  }
  
  public void crearEditor() throws Exception{
    try {
      System.out.print("ID: ");
      int id = sc.nextInt();
      System.out.print("Nombre: ");
      String name = sc.next();
      System.out.print("Alta: ");
      boolean alta = sc.nextBoolean();
      if(id < 0) throw new Exception("NUMERO INVALIDO");
      if(name.trim().isEmpty()) throw new Exception("CADENA VACIA");
      eServices.crearUnaEditorial(id, name, alta);
    } catch (Exception e) {
      throw e;
    }
  }
  
  public void buscarEditor() throws Exception {
    try {
      System.out.print("Buscar por ID: ");
      int id = sc.nextInt();
      if(id < 0) throw new Exception("NUMERO INVALIDO");
      System.out.println(eServices.buscarEditorPorID(id));
    } catch (Exception e) {
      throw e;
    }
  }
  
  public void listarAutores() throws Exception {
    try {
      List aux = eServices.listarEditoriales();
      aux.forEach(aux2 -> {
        System.out.println(aux2);
      });
    } catch (Exception e) {
      throw e;
    }
  }
  
  public void cambiarNombre() throws Exception {
    try {
      System.out.print("Elegir el autor por ID: ");
      int id = sc.nextInt();
      System.out.print("Que nombre desea ponerle: ");
      String name = sc.next();
      if(id < 0) throw new Exception("NUMERO INVALIDO");
      if(name.trim().isEmpty()) throw new Exception("CADENA VACIA");
      eServices.actualizarNombreEditorial(id, name);
    } catch (Exception e) {
      throw e;
    }
  }
  
  public void eliminarAutor() throws Exception {
    try {
      System.out.print("Elegir el autor por su ID: ");
      int aux = sc.nextInt();
      if(aux < 0) throw new Exception("NUMERO INVALIDO");
      eServices.eliminarEditorial(aux);
    } catch (Exception e) {
      throw e;
    }
  }
}
