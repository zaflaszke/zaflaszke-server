package pl.kk.zaflaszke.advertisement;

import java.util.List;

/**
 * Service responsible for retrieving and storing Advertisement.
 * 
 * @author Mares
 */
public interface AdvertisementService {

  List<AdvertisementDto> findAll();

}
