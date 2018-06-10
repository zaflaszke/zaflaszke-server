package pl.kk.zaflaszke.advertisement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kk.zaflaszke.category.CategoryConverter;
import pl.kk.zaflaszke.city.CityConverter;
import pl.kk.zaflaszke.entities.Advertisement;
import pl.kk.zaflaszke.utils.AbstractConverter;

/**
 * @author Mares
 */
@Component
public class AdvertisementConverter extends AbstractConverter<Advertisement, AdvertisementDto> {

  private final CityConverter cityConverter;
  private final CategoryConverter categoryConverter;

  @Autowired
  public AdvertisementConverter(CityConverter cityConverter, CategoryConverter categoryConverter) {
    this.cityConverter = cityConverter;
    this.categoryConverter = categoryConverter;
  }

  @Override
  public AdvertisementDto convert(Advertisement from) {
    return AdvertisementDto.builder().id(from.getId()).title(from.getTitle())
        .description(from.getDescription()).price(from.getPrice())
        .creationDate(from.getCreationDate()).city(cityConverter.convert(from.getCity()))
        .categories(categoryConverter.convertAll(from.getCategories())).build();
  }
}
