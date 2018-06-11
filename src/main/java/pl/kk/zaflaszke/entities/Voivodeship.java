package pl.kk.zaflaszke.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Mares
 */
@Entity
@Table(name = "VOIVODESHIP")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Voivodeship {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "NAME", length = 255, nullable = false)
  private String name;

  @Column(name = "CODE", length = 1, nullable = false)
  private String code;
}
