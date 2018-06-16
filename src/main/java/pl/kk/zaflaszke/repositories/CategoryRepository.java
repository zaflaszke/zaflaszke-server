package pl.kk.zaflaszke.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kk.zaflaszke.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
