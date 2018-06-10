package pl.kk.zaflaszke.advertisement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kk.zaflaszke.entities.Advertisement;
import pl.kk.zaflaszke.repositories.AdvertisementRepository;

/**
 * @author Mares
 */
@Service
public class AdvertisementServiceImpl implements AdvertisementService {

  private final AdvertisementRepository advertisementRepository;
  private final AdvertisementConverter advertisementConverter;

  @Autowired
  public AdvertisementServiceImpl(AdvertisementRepository advertisementRepository,
      AdvertisementConverter advertisementConverter) {
    this.advertisementRepository = advertisementRepository;
    this.advertisementConverter = advertisementConverter;
  }

  @Override
  public List<AdvertisementDto> findAll() {
    List<Advertisement> advertisements = advertisementRepository.findAll();
    return advertisementConverter.convertAll(advertisements);
  }
}
