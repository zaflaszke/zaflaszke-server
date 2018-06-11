package pl.kk.zaflaszke.rest;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import pl.kk.zaflaszke.advertisement.AdvertisementDto;
import pl.kk.zaflaszke.advertisement.AdvertisementDtoToPoConverter;
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

  @Autowired
  public AdvertisementApiController(AdvertisementService advertisementService,
      AdvertisementDtoToPoConverter advertisementDtoToPoConverter) {
    this.advertisementService = advertisementService;
    this.advertisementDtoToPoConverter = advertisementDtoToPoConverter;
  }

  @Override
  public ResponseEntity<List<AdvertisementPO>> findAll() {
    List<AdvertisementDto> advertismenets = advertisementService.findAll();
    List<AdvertisementPO> advertisementsPO =
        advertisementDtoToPoConverter.convertAll(advertismenets);

    System.out.println("Ernest to pedał");
    return new ResponseEntity<List<AdvertisementPO>>(advertisementsPO, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> store(@Valid AdvertisementPO body) {
    // TODO Auto-generated method stub
    return null;
  }

}
