package RestApp.services;

import java.util.Optional;

import RestApp.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import RestApp.models.Sensor;

@Service
@Transactional(readOnly = true)
public class SensorService {

  private final SensorRepository sensorRepository;

  @Autowired
  public SensorService(final SensorRepository sensorRepository) {
    this.sensorRepository = sensorRepository;
  }

  @Transactional
  public void addRegister(Sensor sensor) {
    sensorRepository.save(sensor);
  }

  public Optional<Sensor> findByName(String name) {
    return sensorRepository.findByName(name);
  }

}
