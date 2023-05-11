package RestApp.util;

import RestApp.models.Measurement;
import RestApp.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MeasurementValidator implements Validator {

  private final SensorService sensorService;

  @Autowired
  public MeasurementValidator(final SensorService sensorService) {
    this.sensorService = sensorService;
  }

  @Override
  public boolean supports(final Class<?> clazz) {
    return Measurement.class.equals(clazz);
  }

  @Override
  public void validate(final Object target, final Errors errors) {
    Measurement measurement = (Measurement) target;

    if (measurement.getSensor() == null) {
      return;
    }
    if (sensorService.findByName(measurement.getSensor().getName()).isEmpty()) {
      errors.rejectValue("sensor", "Sensor with that name does not exist");
    }
  }

}
