package pl.kk.zaflaszke.utils.error;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Mares
 */
@Builder
@Getter
@Setter
public class ErrorDto {

  private String code;

  private String description;

}
