package pl.kk.zaflaszke.utils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import pl.kk.zaflaszke.utils.error.ErrorCodesAndDescriptions;
import pl.kk.zaflaszke.utils.error.ErrorDto;
import pl.kk.zaflaszke.utils.exceptions.BusinessValidationException;

/**
 * @author Mares
 */
public abstract class AbstractValidator<T> {

  public abstract List<ErrorDto> validate(T object);

  public List<ErrorDto> validateAll(Collection<T> objects) {
    return objects.stream()
        .map(this::validate)
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
  }

  public void validateThrowingException(T object) {
    List<ErrorDto> result = validate(object);
    if (!CollectionUtils.isEmpty(result)) {
      throw new BusinessValidationException(result);
    }
  }

  protected boolean validateFieldRequired(Object field, String fieldName, List<ErrorDto> errors) {
    if (field == null || StringUtils.isEmpty(field)) {
      errors.add(getRequiredFieldError(fieldName));
      return false;
    }
    return true;
  }

  private ErrorDto getRequiredFieldError(String fieldName) {
    String description = String.format(ErrorCodesAndDescriptions.FIELD_REQUIRED_DESCRIPTION,
        fieldName, getValidatedObjectClass().getSimpleName());
    return ErrorDto.builder()
        .code(ErrorCodesAndDescriptions.FIELD_REQUIRED_CODE)
        .description(description)
        .build();
  }

  protected void validateFieldLength(String field, int maxLength, String fieldName,
      List<ErrorDto> errors) {
    if (field.length() > maxLength) {
      errors.add(ErrorDto.builder()
          .code(ErrorCodesAndDescriptions.FIELD_TOO_LONG)
          .build());
    }
  }

  protected abstract Class<?> getValidatedObjectClass();
}
