package pl.kk.zaflaszke.category;

import org.springframework.stereotype.Component;
import pl.kk.zaflaszke.models.CategoryPO;
import pl.kk.zaflaszke.utils.AbstractConverter;

/**
 * @author Mares
 */
@Component
public class CategoryDtoToPoConverter extends AbstractConverter<CategoryDto, CategoryPO> {

  @Override
  public CategoryPO convert(CategoryDto from) {
    return new CategoryPO().id(from.getId()).name(from.getName())
        .description(from.getDescription());
  }
}
