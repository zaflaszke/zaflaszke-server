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
import pl.kk.zaflaszke.advertisement.AdvertisementDto;
import pl.kk.zaflaszke.advertisement.AdvertisementDtoToPoConverter;
import pl.kk.zaflaszke.advertisement.AdvertisementPoToDtoConverter;
import pl.kk.zaflaszke.advertisement.AdvertisementService;
import pl.kk.zaflaszke.api.AdvertApi;
import pl.kk.zaflaszke.models.AdvertisementPO;

/**
 * @author Mares
 */
@RestController
@CrossOrigin
public class AdvertisementApiController implements AdvertApi {

  private final AdvertisementService advertisementService;
  private final AdvertisementDtoToPoConverter advertisementDtoToPoConverter;
  private final AdvertisementPoToDtoConverter advertisementPoToDtoConverter;

  @Autowired
  public AdvertisementApiController(AdvertisementService advertisementService,
      AdvertisementDtoToPoConverter advertisementDtoToPoConverter,
      AdvertisementPoToDtoConverter advertisementPoToDtoConverter) {
    this.advertisementService = advertisementService;
    this.advertisementDtoToPoConverter = advertisementDtoToPoConverter;
    this.advertisementPoToDtoConverter = advertisementPoToDtoConverter;
  }

  @Override
  public ResponseEntity<List<AdvertisementPO>> findAll() {
    List<AdvertisementDto> advertismenets = advertisementService.findAll();
    List<AdvertisementPO> advertisementsPO =
        advertisementDtoToPoConverter.convertAll(advertismenets);
    return new ResponseEntity<List<AdvertisementPO>>(advertisementsPO, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> store(
      @ApiParam(value = "Advertisement object that needs to be stored",
          required = true) @Valid @RequestBody AdvertisementPO body) {
    AdvertisementDto advertDto = advertisementPoToDtoConverter.convert(body);
    advertisementService.store(advertDto);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
