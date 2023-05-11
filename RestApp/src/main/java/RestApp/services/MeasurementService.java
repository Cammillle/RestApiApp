package RestApp.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import RestApp.dto.MeasurementDTO;
import RestApp.exception.SensorNotFountException;
import RestApp.repositories.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import RestApp.mapper.MeasurementMapper;
import RestApp.models.Measurement;

@Service
@Transactional(readOnly = true)
public class MeasurementService {


  private final MeasurementRepository measurementRepository;
  private final SensorService sensorService;

  @Autowired
  public MeasurementService(final MeasurementRepository measurementRepository, final SensorService sensorService) {
    this.measurementRepository = measurementRepository;
    this.sensorService = sensorService;
  }

  public List<MeasurementDTO> findAll() {
    return StreamSupport.stream(measurementRepository.findAll().spliterator(), false)
        .map(MeasurementMapper.INSTANCE::mapToMeasurementDTO)
        .collect(Collectors.toList());
  }

  @Transactional
  public void addMeasurement(final Measurement measurement) {
    enrichMeasurement(measurement);
    measurementRepository.save(measurement);
  }

  private void enrichMeasurement(final Measurement measurement) {
    var sensor = sensorService.findByName(measurement.getSensor().getName())
        .orElseThrow((() -> new SensorNotFountException("Sensor wasn't found")));

    measurement.setSensor(sensor);
    measurement.setMeasurementDateTime(LocalDateTime.now());
  }

}
