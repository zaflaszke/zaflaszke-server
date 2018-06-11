package pl.kk.zaflaszke.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kk.zaflaszke.models.CityPO;
import pl.kk.zaflaszke.utils.AbstractConverter;
import pl.kk.zaflaszke.voivodeship.VoivodeshipPoToDtoConverter;

/**
 * @author Mares
 */
@Component
public class CityPoToDtoConverter extends AbstractConverter<CityPO, CityDto> {

  private final VoivodeshipPoToDtoConverter voivodeshipConverter;

  @Autowired
  public CityPoToDtoConverter(VoivodeshipPoToDtoConverter voivodeshipConverter) {
    this.voivodeshipConverter = voivodeshipConverter;
  }

  @Override
  public CityDto convert(CityPO from) {
    return CityDto.builder().id(from.getId()).name(from.getName())
        .voivodeshipDto(voivodeshipConverter.convert(from.getVoivodeship())).build();
  }
}
