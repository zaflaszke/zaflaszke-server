package pl.kk.zaflaszke.voivodeship;

import java.util.List;

/**
 * Service responsible for retrieving data about Voivodeship.
 * 
 * @author Mares
 */
public interface VoivodeshipService {

  List<VoivodeshipDto> findAll();

}
