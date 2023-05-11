package RestApp.mapper;

import RestApp.dto.SensorDTO;
import RestApp.models.Sensor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SensorMapper {

  SensorMapper INSTANCE = Mappers.getMapper(SensorMapper.class);

  SensorDTO mapToSensorDTO(Sensor sensor);

  Sensor mapToSensor(SensorDTO sensorDTO);
}
