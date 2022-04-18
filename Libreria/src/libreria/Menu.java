package libreria;

import java.util.Scanner;
import libreria.services.MenuAutor;
import libreria.services.MenuEditorial;
import libreria.services.MenuLibro;

public class Menu {

  private final MenuLibro menuLibro;
  private final MenuAutor menuAutor;
  private final MenuEditorial menuEditorial;

  public Menu() {
    this.menuAutor = new MenuAutor();
    this.menuEditorial = new MenuEditorial();
    this.menuLibro = new MenuLibro();
  }

  public void abrirMenu() throws Exception {
    try {
      Scanner sc = new Scanner(System.in).useDelimiter("\n");
      Boolean close = false;
      do {
        String aux = "=====================" + "\n"
                + "==      Menu       ==" + "\n"
                + "=====================" + "\n"
                + "==  1-Libros       ==" + "\n"
                + "==  2-Autores      ==" + "\n"
                + "==  3-Editoriales  ==" + "\n"
                + "==  4-Cerrar       ==" + "\n"
                + "=====================";
        System.out.println(aux);
        System.out.print("Opcion: ");
        Integer option = sc.nextInt();
        switch (option) {
          case 1:
            menuLibro.abrirMenu();
            break;
          case 2:
            menuAutor.abrirMenu();
            break;
          case 3:
            menuEditorial.abrirMenu();
            break;
          case 4:
            System.out.println("Adios");
            close = true;
        }
      } while (close != true);
    } catch (Exception e) {
      throw e;
    }
  }

}
