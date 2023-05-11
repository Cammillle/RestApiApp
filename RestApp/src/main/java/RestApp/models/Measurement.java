package RestApp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Measurement")
public class Measurement {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @NotNull
  @Min(-100)
  @Max(100)
  @Column(name = "value")
  private Double value;

  @NotNull
  @Column(name = "raining")
  private Boolean raining;

  @NotNull
  @Column(name = "measurement_date_time")
  private LocalDateTime measurementDateTime;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sensor_name")
  private Sensor sensor;

  public Integer getId() {
    return id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  public Double getValue() {
    return value;
  }

  public void setValue(final Double value) {
    this.value = value;
  }

  public Boolean getRaining() {
    return raining;
  }

  public void setRaining(final Boolean raining) {
    this.raining = raining;
  }

  public LocalDateTime getMeasurementDateTime() {
    return measurementDateTime;
  }

  public void setMeasurementDateTime(final LocalDateTime measurementDateTime) {
    this.measurementDateTime = measurementDateTime;
  }

  public Sensor getSensor() {
    return sensor;
  }

  public void setSensor(final Sensor sensor) {
    this.sensor = sensor;
  }
}
