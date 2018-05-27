package pl.kk.zaflaszke.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kk.zaflaszke.entities.Advertisement;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

}
