package libreria.services;

import java.util.List;
import java.util.Scanner;

public class MenuAutor {

  private final AutorService aService;
  private final Scanner sc = new Scanner(System.in).useDelimiter("\n");

  public MenuAutor() {
    this.aService = new AutorService();
  }

  public void abrirMenu() throws Exception {
    try {
      boolean close = false;
      do {
        String aux = "=======================" + "\n"
                + "==     Menu Autor    ==" + "\n"
                + "=======================" + "\n"
                + "==  1-Crear Autor    ==" + "\n"
                + "==  2-Buscar Autor   ==" + "\n"
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
            crearAutor();
            break;
          case 2:
            buscarAutorID();
            break;
          case 3:
            listarAutores();
            break;
          case 4:
            aService.listarNombresAutores();
            break;
          case 5:
            cambiarNombre();
            break;
          case 6:
            eleminiarAutor();
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

  public void crearAutor() throws Exception{
    try {
      System.out.print("ID: ");
      int aux1 = sc.nextInt();
      System.out.print("Nombre: ");
      String aux2 = sc.next();
      System.out.print("Alta: ");
      boolean aux3 = sc.nextBoolean();
      if (aux1 < 0) throw new Exception("NUMERO INVALIDO");
      if(aux2.trim().isEmpty()) throw new Exception("CADENA VACIA");
      aService.crearAutor(aux1, aux2, aux3);
    } catch (Exception e) {
      throw e;
    }
  }
  
  public void buscarAutorID() throws Exception{
    try {
      System.out.print("Buscar por ID: ");
      int aux = sc.nextInt();
      if(aux < 0) throw new Exception("NUMERO INVALIDO");
      System.out.println(aService.buscarID(aux));
    } catch (Exception e) {
      throw e;
    }
  }
  
  public void buscarAutorPorNombre() throws Exception {
    try {
      System.out.print("Buscar por nombre: ");
      String aux = sc.next();
      if(aux.trim().isEmpty()) throw new Exception("CADENA VACIA");
      aService.buscarAutor(aux);
    } catch (Exception e) {
      throw e;
    }
  }
  
  public void listarAutores() throws Exception {
    try {
      List aux = aService.listarAutores();
      aux.forEach(aux2 -> {
        System.out.println(aux2);
      });
    } catch (Exception e) {
      throw e;
    }
  }
  
  public void cambiarNombre() throws Exception {
    try {
      System.out.print("Elige el ID: ");
      int aux1 = sc.nextInt();
      System.out.print("Que nombre desea ponerle: ");
      String aux2 = sc.next();
      if(aux1 < 0) throw new Exception("NUMERO INVALIDO");
      if(aux2.trim().isEmpty()) throw new Exception("CADENA VACIA");
      aService.actualizarNombreAutor(aux1, aux2);
    } catch (Exception e) {
      throw e;
    }
  }
  
  public void eleminiarAutor() throws Exception {
    try {
      System.out.print("Escoja el ID: ");
      int aux = sc.nextInt();
      if(aux < 0) throw new Exception("NUMERO INVALIDO");
      aService.eliminarAutor(aux);
    } catch (Exception e) {
      throw e;
    }
  }
}
