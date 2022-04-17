package libreria;

import libreria.services.AutorService;
import libreria.services.EditorialServices;

public class Libreria {

  public static void main(String[] args) throws Exception {
    try {
      EditorialServices eds = new EditorialServices();
      AutorService asrv = new AutorService();

      System.out.println(eds.listarEditoriales());
      eds.listarNombreEditorials();
              
    } catch (Exception e) {
      throw e;
    }
  }

}
