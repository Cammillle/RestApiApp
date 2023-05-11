package RestApp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class SensorDTO {

  @NotEmpty(message = "Name cannot be empty")
  @Size(min = 2, max = 30, message = "The sensor name must be between 3 and 30 characters")
  private String name;

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }
}
