package pl.kk.zaflaszke.rest;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiParam;
import pl.kk.zaflaszke.api.CityApi;
import pl.kk.zaflaszke.city.CityDto;
import pl.kk.zaflaszke.city.CityDtoToPoConverter;
import pl.kk.zaflaszke.city.CityPoToDtoConverter;
import pl.kk.zaflaszke.city.CityService;
import pl.kk.zaflaszke.models.CityPO;

/**
 * @author Mares
 */
@RestController
@CrossOrigin
public class CityApiController implements CityApi {

  private final CityService cityService;
  private final CityDtoToPoConverter cityDtoToPoConverter;
  private final CityPoToDtoConverter cityPoToDtoConverter;

  @Autowired
  public CityApiController(CityService cityService, CityDtoToPoConverter cityDtoToPoConverter,
      CityPoToDtoConverter cityPoToDtoConverter) {
    this.cityService = cityService;
    this.cityDtoToPoConverter = cityDtoToPoConverter;
    this.cityPoToDtoConverter = cityPoToDtoConverter;
  }


  @Override
  public ResponseEntity<List<CityPO>> findAllCities() {
    List<CityDto> cities = cityService.findAll();
    return new ResponseEntity<List<CityPO>>(cityDtoToPoConverter.convertAll(cities), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> storeCity(@ApiParam(value = "City object to stored",
      required = true) @Valid @RequestBody CityPO cittPO) {
    CityDto cityDto = cityPoToDtoConverter.convert(cittPO);
    cityService.store(cityDto);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
