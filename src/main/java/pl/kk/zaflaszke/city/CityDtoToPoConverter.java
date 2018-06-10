package pl.kk.zaflaszke.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kk.zaflaszke.models.CityPO;
import pl.kk.zaflaszke.utils.AbstractConverter;
import pl.kk.zaflaszke.voivodeship.VoivodeshipDtoToPoConverter;

/**
 * @author Mares
 */
@Component
public class CityDtoToPoConverter extends AbstractConverter<CityDto, CityPO> {

  private final VoivodeshipDtoToPoConverter voivodeshipConverter;

  @Autowired
  public CityDtoToPoConverter(VoivodeshipDtoToPoConverter voivodeshipConverter) {
    this.voivodeshipConverter = voivodeshipConverter;
  }

  @Override
  public CityPO convert(CityDto from) {
    return new CityPO().id(from.getId()).name(from.getName())
        .voivodeship(voivodeshipConverter.convert(from.getVoivodeshipDto()));
  }
}
