package RestApp.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.Set;

@Entity
@Table
public class Sensor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  @NotEmpty(message = "Name cannot be empty")
  @Size(min = 2, max = 30, message = "The sensor name must be between 3 and 30 characters")
  private String name;

  @OneToMany(mappedBy = "sensor", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Measurement> measurements;

  public Integer getId() {
    return id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public Set<Measurement> getMeasurements() {
    return measurements;
  }

  public void setMeasurements(final Set<Measurement> measurements) {
    this.measurements = measurements;
  }

}
