package pl.kk.zaflaszke.advertisement;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kk.zaflaszke.category.CategoryDto;
import pl.kk.zaflaszke.city.CityDto;
import pl.kk.zaflaszke.entities.Advertisement;
import pl.kk.zaflaszke.entities.Category;
import pl.kk.zaflaszke.entities.City;
import pl.kk.zaflaszke.entities.User;
import pl.kk.zaflaszke.repositories.AdvertisementRepository;
import pl.kk.zaflaszke.repositories.CategoryRepository;
import pl.kk.zaflaszke.repositories.CityRepository;
import pl.kk.zaflaszke.repositories.UserRepository;
import pl.kk.zaflaszke.user.UserContext;

/**
 * @author Mares
 */
@Service
public class AdvertisementServiceImpl implements AdvertisementService {

  private final AdvertisementRepository advertisementRepository;
  private final AdvertisementConverter advertisementConverter;
  private final CategoryRepository categoryRepository;
  private final CityRepository cityRepository;
  private final UserContext userContext;
  private final UserRepository userRepository;

  @Autowired
  public AdvertisementServiceImpl(AdvertisementRepository advertisementRepository,
      AdvertisementConverter advertisementConverter, CategoryRepository categoryRepository,
      CityRepository cityRepository, UserContext userContext, UserRepository userRepository) {
    this.advertisementRepository = advertisementRepository;
    this.advertisementConverter = advertisementConverter;
    this.categoryRepository = categoryRepository;
    this.cityRepository = cityRepository;
    this.userContext = userContext;
    this.userRepository = userRepository;
  }

  @Override
  public List<AdvertisementDto> findAll() {
    List<Advertisement> advertisements = advertisementRepository.findAll();
    return advertisementConverter.convertAll(advertisements);
  }

  @Transactional
  @Override
  public void store(AdvertisementDto advertDto) {
    Advertisement entity;
    if (advertDto.getId() == null) {
      entity = Advertisement.builder().build();
    } else {
      entity = advertisementRepository.findById(advertDto.getId())
          .orElseThrow(() -> new EntityNotFoundException());
    }

    mergeEntityWithDto(entity, advertDto);
    advertisementRepository.save(entity);
  }

  private void mergeEntityWithDto(Advertisement entity, AdvertisementDto advertDto) {
    entity.setDescription(advertDto.getDescription());
    entity.setTitle(advertDto.getTitle());
    entity.setPrice(advertDto.getPrice());
    entity.setCategories(fetchCategories(advertDto.getCategories()));
    entity.setCity(fetchCityEntity(advertDto.getCity()));
    entity.setOwner(fetchUser());
  }

  private User fetchUser() {
    return userRepository.findById(userContext.getUserId())
        .orElseThrow(() -> new EntityNotFoundException());
  }

  private City fetchCityEntity(CityDto city) {
    return cityRepository.findById(city.getId()).orElseThrow(() -> new EntityNotFoundException());
  }

  private List<Category> fetchCategories(List<CategoryDto> categories) {
    return categoryRepository
        .findAllById(categories.stream().map(CategoryDto::getId).collect(Collectors.toList()));
  }
}
