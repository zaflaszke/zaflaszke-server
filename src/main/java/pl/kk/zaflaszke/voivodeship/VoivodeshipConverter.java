package pl.kk.zaflaszke.voivodeship;

import org.springframework.stereotype.Component;
import pl.kk.zaflaszke.entities.Voivodeship;
import pl.kk.zaflaszke.utils.AbstractConverter;

/**
 * @author Mares
 *
 */
@Component
public class VoivodeshipConverter extends AbstractConverter<Voivodeship, VoivodeshipDto> {

  @Override
  public VoivodeshipDto convert(Voivodeship from) {
    return VoivodeshipDto.builder().id(from.getId()).name(from.getName()).build();
  }
}
