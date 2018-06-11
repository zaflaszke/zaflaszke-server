package pl.kk.zaflaszke.voivodeship;

import org.springframework.stereotype.Component;
import pl.kk.zaflaszke.models.VoivodeshipPO;
import pl.kk.zaflaszke.utils.AbstractConverter;

/**
 * @author Mares
 */
@Component
public class VoivodeshipPoToDtoConverter extends AbstractConverter<VoivodeshipPO, VoivodeshipDto> {

  @Override
  public VoivodeshipDto convert(VoivodeshipPO from) {
    return VoivodeshipDto.builder().id(from.getId()).code(from.getCode()).name(from.getName())
        .build();
  }
}
