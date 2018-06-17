package pl.kk.zaflaszke.advertisement;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kk.zaflaszke.category.CategoryPoValidator;
import pl.kk.zaflaszke.models.AdvertisementPO;
import pl.kk.zaflaszke.utils.AbstractValidator;
import pl.kk.zaflaszke.utils.error.ErrorDto;

/**
 * @author Mares
 */
@Component
public class AdvertisementPoValidator extends AbstractValidator<AdvertisementPO> {

  private static final int MAX_TITLE_LENGTH = 255;
  private static final int MAX_DESCRIPTION_LENGTH = 4000;

  private final CategoryPoValidator categoryValidator;

  @Autowired
  public AdvertisementPoValidator(CategoryPoValidator categoryValidator) {
    this.categoryValidator = categoryValidator;
  }

  @Override
  public List<ErrorDto> validate(AdvertisementPO object) {
    List<ErrorDto> errors = new ArrayList<>();
    if (validateFieldRequired(object.getCategories(), "categories", errors)) {
      errors.addAll(categoryValidator.validateAll(object.getCategories()));
    }
    if (validateFieldRequired(object.getTitle(), "title", errors)) {
      validateFieldLength(object.getTitle(), MAX_TITLE_LENGTH, "title", errors);
    }
    if (validateFieldRequired(object.getDescription(), "description", errors)) {
      validateFieldLength(object.getDescription(), MAX_DESCRIPTION_LENGTH, "description", errors);
    }
    validateFieldRequired(object.getCity(), "city", errors);
    return errors;
  }

  @Override
  protected Class<?> getValidatedObjectClass() {
    return AdvertisementPO.class;
  }
}
