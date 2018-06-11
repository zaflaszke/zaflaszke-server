package pl.kk.zaflaszke.voivodeship;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kk.zaflaszke.entities.Voivodeship;
import pl.kk.zaflaszke.repositories.VoivodeshipRespository;

/**
 * @author Mares
 */
@Service
public class VoivodeshipServiceImpl implements VoivodeshipService {

  private final VoivodeshipRespository voivodeshipRepository;
  private final VoivodeshipConverter voivodeshipConverter;

  @Autowired
  public VoivodeshipServiceImpl(VoivodeshipRespository voivodeshipRepository,
      VoivodeshipConverter voivodeshipConverter) {
    this.voivodeshipRepository = voivodeshipRepository;
    this.voivodeshipConverter = voivodeshipConverter;
  }

  @Override
  public List<VoivodeshipDto> findAll() {
    List<Voivodeship> allVoivodeships = voivodeshipRepository.findAll();
    return voivodeshipConverter.convertAll(allVoivodeships);
  }
}
