package pl.kk.zaflaszke.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "ADVERTISEMENT")
public class Advertisement {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "TITLE", length = 255, nullable = false)
  private String title;

  @Column(name = "DESCRIPTION", length = 4000, nullable = false)
  private String description;

  @Column(name = "PRICE", nullable = false)
  private Integer price;

  @Column(name = "CREATION_DATE", nullable = false)
  private LocalDateTime creationDate;

  @JoinColumn(name = "OWNER", nullable = false)
  @ManyToOne(fetch = FetchType.LAZY)
  private User owner;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public LocalDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
  }

  public User getOwner() {
    return owner;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }


}
