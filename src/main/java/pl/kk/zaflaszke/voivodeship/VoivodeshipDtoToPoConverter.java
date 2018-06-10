package pl.kk.zaflaszke.voivodeship;

import org.springframework.stereotype.Component;
import pl.kk.zaflaszke.models.VoivodeshipPO;
import pl.kk.zaflaszke.utils.AbstractConverter;

/**
 * @author Mares
 */
@Component
public class VoivodeshipDtoToPoConverter extends AbstractConverter<VoivodeshipDto, VoivodeshipPO> {

  @Override
  public VoivodeshipPO convert(VoivodeshipDto from) {
    return new VoivodeshipPO().id(from.getId()).name(from.getName());
  }
}
