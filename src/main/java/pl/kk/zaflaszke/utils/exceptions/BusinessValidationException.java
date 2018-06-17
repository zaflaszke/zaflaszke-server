package pl.kk.zaflaszke.utils.exceptions;

import java.util.List;
import lombok.Getter;
import pl.kk.zaflaszke.utils.error.ErrorDto;

/**
 * @author Mares
 */
@Getter
public class BusinessValidationException extends RuntimeException {

  /**
   */
  private static final long serialVersionUID = 1L;

  private List<ErrorDto> errors;

  public BusinessValidationException(List<ErrorDto> errors) {
    super();
    this.errors = errors;
  }
}
