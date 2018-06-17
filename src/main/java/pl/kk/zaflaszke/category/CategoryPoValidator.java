package pl.kk.zaflaszke.category;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import pl.kk.zaflaszke.models.CategoryPO;
import pl.kk.zaflaszke.utils.AbstractValidator;
import pl.kk.zaflaszke.utils.error.ErrorDto;

/**
 * @author Mares
 */
@Component
public class CategoryPoValidator extends AbstractValidator<CategoryPO> {

  private static final int TITLE_MAX_LENGTH = 255;
  private static final int DESCRIPTION_MAX_LENGTH = 4000;

  @Override
  public List<ErrorDto> validate(CategoryPO object) {
    List<ErrorDto> errors = new ArrayList<>();
    if (validateFieldRequired(object.getName(), "name", errors)) {
      validateFieldLength(object.getName(), TITLE_MAX_LENGTH, "title", errors);
    }
    if (validateFieldRequired(object.getDescription(), "description", errors)) {
      validateFieldLength(object.getDescription(), DESCRIPTION_MAX_LENGTH, "description", errors);
    }
    return errors;
  }

  @Override
  protected Class<?> getValidatedObjectClass() {
    return CategoryPO.class;
  }
}
