package pl.kk.zaflaszke.category;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kk.zaflaszke.entities.Category;
import pl.kk.zaflaszke.repositories.CategoryRepository;

/**
 * @author Mares
 */
@Service
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;
  private final CategoryConverter categoryConverter;

  @Autowired
  public CategoryServiceImpl(CategoryRepository categoryRepository,
      CategoryConverter categoryConverter) {
    this.categoryRepository = categoryRepository;
    this.categoryConverter = categoryConverter;
  }

  @Override
  public List<CategoryDto> findAll() {
    return categoryConverter.convertAll(categoryRepository.findAll());
  }

  @Transactional
  @Override
  public void store(CategoryDto categoryDto) {
    Category entity;
    if (categoryDto.getId() == null) {
      entity = Category.builder().build();
    } else {
      entity = categoryRepository.findById(categoryDto.getId())
          .orElseThrow(() -> new EntityNotFoundException());
    }
    mergeEntityWityDto(entity, categoryDto);
    categoryRepository.save(entity);
  }

  private void mergeEntityWityDto(Category entity, CategoryDto categoryDto) {
    entity.setDescription(categoryDto.getDescription());
    entity.setName(categoryDto.getName());
  }
}
