package pl.kk.zaflaszke.rest;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiParam;
import pl.kk.zaflaszke.api.CategoryApi;
import pl.kk.zaflaszke.category.CategoryDto;
import pl.kk.zaflaszke.category.CategoryDtoToPoConverter;
import pl.kk.zaflaszke.category.CategoryPoValidator;
import pl.kk.zaflaszke.category.CategoryService;
import pl.kk.zaflaszke.models.CategoryPO;

/**
 * @author Mares
 */
@RestController
@CrossOrigin
public class CategoryApiController implements CategoryApi {

  private final CategoryService categoryService;
  private final CategoryDtoToPoConverter categoryDtoToPoConverter;
  private final CategoryPoToDtoConverter categoryPoToDtoConverter;
  private final CategoryPoValidator categoryPoValidator;

  @Autowired
  public CategoryApiController(CategoryService categoryService,
      CategoryDtoToPoConverter categoryDtoToPoConverter,
      CategoryPoToDtoConverter categoryPoToDtoConverter, CategoryPoValidator categoryPoValidator) {
    this.categoryService = categoryService;
    this.categoryDtoToPoConverter = categoryDtoToPoConverter;
    this.categoryPoToDtoConverter = categoryPoToDtoConverter;
    this.categoryPoValidator = categoryPoValidator;
  }

  @Override
  public ResponseEntity<List<CategoryPO>> findAllCategories() {
    List<CategoryDto> categoriesDto = categoryService.findAll();
    List<CategoryPO> categoriesPo = categoryDtoToPoConverter.convertAll(categoriesDto);
    return new ResponseEntity<List<CategoryPO>>(categoriesPo, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> storeCategory(
      @ApiParam(value = "Advertisement object that needs to be stored",
          required = true) @Valid @RequestBody CategoryPO body) {
    categoryPoValidator.validateThrowingException(body);
    CategoryDto categoryDto = categoryPoToDtoConverter.convert(body);
    categoryService.store(categoryDto);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
