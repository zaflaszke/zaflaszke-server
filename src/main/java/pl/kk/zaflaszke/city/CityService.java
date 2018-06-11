package pl.kk.zaflaszke.city;

import java.util.List;

/**
 * @author Mares
 */
public interface CityService {

  List<CityDto> findAll();

  void store(CityDto city);
}
