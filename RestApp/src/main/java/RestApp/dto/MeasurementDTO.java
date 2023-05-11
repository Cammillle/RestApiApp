package RestApp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class MeasurementDTO {

  @NotNull
  @Min(-100)
  @Max(100)
  private Double value;

  @NotNull
  private Boolean isRaining;

  @NotNull
  private SensorDTO sensor;

  public Double getValue() {
    return value;
  }

  public void setValue(final Double value) {
    this.value = value;
  }

  public Boolean getRaining() {
    return isRaining;
  }

  public void setRaining(final Boolean raining) {
    isRaining = raining;
  }

  public SensorDTO getSensor() {
    return sensor;
  }

  public void setSensor(final SensorDTO sensor) {
    this.sensor = sensor;
  }
}
