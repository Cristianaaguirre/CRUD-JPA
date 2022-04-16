package libreria.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Libro implements Serializable {
  
  @Id
  private String id; 
  private String name;
  @ManyToOne
  private Editorial fabricante;

  public Libro() {
  }

}
