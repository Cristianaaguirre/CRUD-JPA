package libreria.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Autor implements Serializable {
  
  @Id
  private Integer id;
  private String name;
  private Boolean alta;

  public Autor() {
  }

  public Autor(Integer id, String name, Boolean alta) {
    this.id = id;
    this.name = name;
    this.alta = alta;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getAlta() {
    return alta;
  }

  public void setAlta(Boolean alta) {
    this.alta = alta;
  }

  @Override
  public String toString() {
    return "Autor{" + "id=" + id + ", name=" + name + ", alta=" + alta + '}';
  }
  
}
