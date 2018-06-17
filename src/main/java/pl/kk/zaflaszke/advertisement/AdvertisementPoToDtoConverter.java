package pl.kk.zaflaszke.advertisement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kk.zaflaszke.city.CityPoToDtoConverter;
import pl.kk.zaflaszke.models.AdvertisementPO;
import pl.kk.zaflaszke.rest.CategoryPoToDtoConverter;
import pl.kk.zaflaszke.utils.AbstractConverter;
import pl.kk.zaflaszke.utils.LocalDateTimeConverter;

/**
 * @author Mares
 */
@Component
public class AdvertisementPoToDtoConverter
    extends AbstractConverter<AdvertisementPO, AdvertisementDto> {

  private final CityPoToDtoConverter cityConverter;
  private final CategoryPoToDtoConverter categoryConverter;
  private final LocalDateTimeConverter localDateTimeConverter;

  @Autowired
  public AdvertisementPoToDtoConverter(CityPoToDtoConverter cityConverter,
      CategoryPoToDtoConverter categoryConverter, LocalDateTimeConverter localDateTimeConverter) {
    this.cityConverter = cityConverter;
    this.categoryConverter = categoryConverter;
    this.localDateTimeConverter = localDateTimeConverter;
  }

  @Override
  public AdvertisementDto convert(AdvertisementPO from) {
    return AdvertisementDto.builder().id(from.getId()).title(from.getTitle())
        .description(from.getDescription()).price(from.getPrice())
        .creationDate(localDateTimeConverter.format(from.getCreationDate()))
        .city(cityConverter.convert(from.getCity()))
        .categories(categoryConverter.convertAll(from.getCategories())).build();
  }
}
