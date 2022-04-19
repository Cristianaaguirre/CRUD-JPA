package libreria;

import static org.eclipse.persistence.config.CacheUsageIndirectionPolicy.Exception;

public class Libreria {

  public static void main(String[] args) throws Exception {
    try {
      Menu m = new Menu();
      m.abrirMenu();
    } catch (Exception e) {
      throw e;
    }
  }

}
