package pl.kk.zaflaszke.advertisement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kk.zaflaszke.category.CategoryDtoToPoConverter;
import pl.kk.zaflaszke.city.CityDtoToPoConverter;
import pl.kk.zaflaszke.models.AdvertisementPO;
import pl.kk.zaflaszke.utils.AbstractConverter;

/**
 * @author Mares
 *
 */
@Component
public class AdvertisementDtoToPoConverter
    extends AbstractConverter<AdvertisementDto, AdvertisementPO> {

  private final CityDtoToPoConverter cityConverter;
  private final CategoryDtoToPoConverter categoryConverter;

  @Autowired
  public AdvertisementDtoToPoConverter(CityDtoToPoConverter cityConverter,
      CategoryDtoToPoConverter categoryConverter) {
    this.cityConverter = cityConverter;
    this.categoryConverter = categoryConverter;
  }

  @Override
  public AdvertisementPO convert(AdvertisementDto from) {
    return new AdvertisementPO().id(from.getId()).title(from.getTitle())
        .description(from.getDescription()).price(from.getPrice())
        .creationDate(from.getCreationDate().toString()).city(cityConverter.convert(from.getCity()))
        .categories(categoryConverter.convertAll(from.getCategories()));
  }
}
