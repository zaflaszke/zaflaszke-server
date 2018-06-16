package pl.kk.zaflaszke.category;

import java.util.List;

/**
 * @author Mares
 */
public interface CategoryService {

  List<CategoryDto> findAll();

  void store(CategoryDto category);

}
