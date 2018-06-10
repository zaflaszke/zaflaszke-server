package pl.kk.zaflaszke.city;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.kk.zaflaszke.voivodeship.VoivodeshipDto;

/**
 * @author Mares
 */
@Getter
@Setter
@Builder
public class CityDto {

  private Long id;
  private String name;
  private VoivodeshipDto voivodeshipDto;

}
