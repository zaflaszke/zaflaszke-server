package pl.kk.zaflaszke.entities;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Mares
 */
@Entity
@Table(name = "ADVERTISEMENT")
@Builder
@Getter
@Setter
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

  @JoinColumn(name = "CITY", nullable = false)
  @ManyToOne(fetch = FetchType.LAZY)
  private City city;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinTable(name = "ADV_CATEGORY", joinColumns = {@JoinColumn(name = "ADV_ID")},
      inverseJoinColumns = {@JoinColumn(name = "CATEGORY_ID")})
  private List<Category> categories;

}
