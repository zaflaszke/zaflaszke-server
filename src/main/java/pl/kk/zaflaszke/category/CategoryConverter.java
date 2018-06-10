package pl.kk.zaflaszke.category;

import org.springframework.stereotype.Component;
import pl.kk.zaflaszke.entities.Category;
import pl.kk.zaflaszke.utils.AbstractConverter;

/**
 * @author Mares
 *
 */
@Component
public class CategoryConverter extends AbstractConverter<Category, CategoryDto> {

  @Override
  public CategoryDto convert(Category from) {
    return CategoryDto.builder().id(from.getId()).name(from.getName()).build();
  }
}
