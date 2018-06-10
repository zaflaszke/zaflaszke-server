package pl.kk.zaflaszke.advertisement;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.kk.zaflaszke.category.CategoryDto;
import pl.kk.zaflaszke.city.CityDto;

/**
 * @author Mares
 */
@Builder
@Getter
@Setter
public class AdvertisementDto {

  private Long id;
  private String title;
  private String description;
  private Integer price;
  private LocalDateTime creationDate;
  private CityDto city;
  private List<CategoryDto> categories;
}
