package pl.kk.zaflaszke.rest;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import pl.kk.zaflaszke.api.CategoryApi;
import pl.kk.zaflaszke.models.CategoryPO;

/**
 * @author Mares
 */
@RestController
@CrossOrigin
public class CategoryApiController implements CategoryApi {

  @Override
  public ResponseEntity<List<CategoryPO>> findAllCategories() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ResponseEntity<Void> storeCategory(@Valid CategoryPO body) {
    // TODO Auto-generated method stub
    return null;
  }
}
