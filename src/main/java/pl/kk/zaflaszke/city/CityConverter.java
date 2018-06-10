package pl.kk.zaflaszke.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kk.zaflaszke.entities.City;
import pl.kk.zaflaszke.utils.AbstractConverter;
import pl.kk.zaflaszke.voivodeship.VoivodeshipConverter;

/**
 * @author Mares
 */
@Component
public class CityConverter extends AbstractConverter<City, CityDto> {

  private final VoivodeshipConverter voivodeshipConverter;

  @Autowired
  public CityConverter(VoivodeshipConverter voivodeshipConverter) {
    this.voivodeshipConverter = voivodeshipConverter;
  }

  @Override
  public CityDto convert(City from) {
    return CityDto.builder().id(from.getId()).name(from.getName())
        .voivodeshipDto(voivodeshipConverter.convert(from.getVoivodeship())).build();
  }
}
