package pl.kk.zaflaszke.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Mares
 */
@Entity
@Table(name = "CITY")
public class City {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "NAME", length = 255, nullable = false)
  private String name;

  @JoinColumn(name = "VOIVODESHIP", nullable = false)
  @ManyToOne
  private Voivodeship voivodeship;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Voivodeship getVoivodeship() {
    return voivodeship;
  }

  public void setVoivodeship(Voivodeship voivodeship) {
    this.voivodeship = voivodeship;
  }
}
