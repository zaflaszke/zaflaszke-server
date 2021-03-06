package pl.kk.zaflaszke.advertisement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kk.zaflaszke.category.CategoryDtoToPoConverter;
import pl.kk.zaflaszke.city.CityDtoToPoConverter;
import pl.kk.zaflaszke.models.AdvertisementPO;
import pl.kk.zaflaszke.utils.AbstractConverter;
import pl.kk.zaflaszke.utils.LocalDateTimeConverter;

/**
 * @author Mares
 *
 */
@Component
public class AdvertisementDtoToPoConverter
    extends AbstractConverter<AdvertisementDto, AdvertisementPO> {

  private final CityDtoToPoConverter cityConverter;
  private final CategoryDtoToPoConverter categoryConverter;
  private final LocalDateTimeConverter localDateTimeConverter;

  @Autowired
  public AdvertisementDtoToPoConverter(CityDtoToPoConverter cityConverter,
      CategoryDtoToPoConverter categoryConverter, LocalDateTimeConverter localDateTimeConverter) {
    this.cityConverter = cityConverter;
    this.categoryConverter = categoryConverter;
    this.localDateTimeConverter = localDateTimeConverter;
  }

  @Override
  public AdvertisementPO convert(AdvertisementDto from) {
    return new AdvertisementPO().id(from.getId()).title(from.getTitle())
        .description(from.getDescription()).price(from.getPrice())
        .creationDate(localDateTimeConverter.format(from.getCreationDate()))
        .city(cityConverter.convert(from.getCity()))
        .categories(categoryConverter.convertAll(from.getCategories()));
  }
}
