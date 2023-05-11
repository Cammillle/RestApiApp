package RestApp.mapper;

import RestApp.dto.MeasurementDTO;
import RestApp.dto.SensorDTO;
import RestApp.models.Measurement;
import RestApp.models.Sensor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MeasurementMapper {

  MeasurementMapper INSTANCE = Mappers.getMapper(MeasurementMapper.class);

  MeasurementDTO mapToMeasurementDTO(Measurement measurement);

  Measurement mapToMeasurement(MeasurementDTO measurementDTO);

  SensorDTO mapToSensorDTO(Sensor sensor);

  Sensor mapToSensor(SensorDTO sensorDTO);

}
