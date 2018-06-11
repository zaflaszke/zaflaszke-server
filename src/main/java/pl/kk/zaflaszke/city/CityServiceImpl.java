package pl.kk.zaflaszke.city;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kk.zaflaszke.entities.City;
import pl.kk.zaflaszke.repositories.CityRepository;
import pl.kk.zaflaszke.repositories.VoivodeshipRespository;

/**
 * @author Mares
 */
@Service
public class CityServiceImpl implements CityService {

  private final CityRepository cityRepository;
  private final VoivodeshipRespository voivodeshipRepository;
  private final CityConverter cityConverter;

  @Autowired
  public CityServiceImpl(CityRepository cityRepository,
      VoivodeshipRespository voivodeshipRepository, CityConverter cityConverter) {
    this.cityRepository = cityRepository;
    this.voivodeshipRepository = voivodeshipRepository;
    this.cityConverter = cityConverter;
  }

  @Override
  public List<CityDto> findAll() {
    return cityConverter.convertAll(cityRepository.findAll());
  }

  @Override
  @Transactional
  public void store(CityDto cityDto) {
    City entity = null;
    if (cityDto.getId() == null) {
      entity = City.builder().build();
    } else {
      entity = cityRepository.findById(cityDto.getId()).orElse(null);
    }
    mergeEntityWithDto(entity, cityDto);
    cityRepository.save(entity);
  }

  private void mergeEntityWithDto(City entity, CityDto cityDto) {
    entity.setName(cityDto.getName());
    entity.setVoivodeship(
        voivodeshipRepository.findById(cityDto.getVoivodeshipDto().getId()).orElse(null));
  }
}
