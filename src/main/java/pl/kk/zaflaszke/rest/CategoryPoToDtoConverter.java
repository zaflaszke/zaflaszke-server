package pl.kk.zaflaszke.rest;

import org.springframework.stereotype.Component;
import pl.kk.zaflaszke.category.CategoryDto;
import pl.kk.zaflaszke.models.CategoryPO;
import pl.kk.zaflaszke.utils.AbstractConverter;

/**
 * @author Mares
 */
@Component
public class CategoryPoToDtoConverter extends AbstractConverter<CategoryPO, CategoryDto> {

  @Override
  public CategoryDto convert(CategoryPO from) {
    return CategoryDto.builder().id(from.getId()).name(from.getName())
        .description(from.getDescription()).build();
  }
}
