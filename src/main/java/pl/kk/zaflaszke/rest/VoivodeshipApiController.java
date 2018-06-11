package pl.kk.zaflaszke.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import pl.kk.zaflaszke.api.VoivodeshipApi;
import pl.kk.zaflaszke.models.VoivodeshipPO;
import pl.kk.zaflaszke.voivodeship.VoivodeshipDto;
import pl.kk.zaflaszke.voivodeship.VoivodeshipDtoToPoConverter;
import pl.kk.zaflaszke.voivodeship.VoivodeshipService;

/**
 * @author Mares
 *
 */
@RestController
@CrossOrigin
public class VoivodeshipApiController implements VoivodeshipApi {

  private final VoivodeshipService voivodeshipService;
  private final VoivodeshipDtoToPoConverter voivodeshipConverter;

  @Autowired
  public VoivodeshipApiController(VoivodeshipService voivodeshipService,
      VoivodeshipDtoToPoConverter voivodeshipConverter) {
    this.voivodeshipService = voivodeshipService;
    this.voivodeshipConverter = voivodeshipConverter;
  }


  @Override
  public ResponseEntity<List<VoivodeshipPO>> findAllVoivodeships() {
    List<VoivodeshipDto> voinvodeshipsDto = voivodeshipService.findAll();
    List<VoivodeshipPO> voivodeshipsPO = voivodeshipConverter.convertAll(voinvodeshipsDto);
    return new ResponseEntity<List<VoivodeshipPO>>(voivodeshipsPO, HttpStatus.OK);
  }
}
