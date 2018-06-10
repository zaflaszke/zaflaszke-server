package pl.kk.zaflaszke.category;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Mares
 */
@Builder
@Getter
@Setter
public class CategoryDto {

  private Long id;
  private String name;

}
