package pl.kk.zaflaszke.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kk.zaflaszke.entities.City;

/**
 * @author Mares
 */
public interface CityRepository extends JpaRepository<City, Long> {

}
