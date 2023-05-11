package RestApp.comrollers;

import static RestApp.exception.ErrorClientResponse.returnErrorsToClient;

import RestApp.dto.MeasurementDTO;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import RestApp.mapper.MeasurementMapper;
import RestApp.models.Measurement;
import RestApp.services.MeasurementService;
import RestApp.util.MeasurementValidator;

@RestController
@RequestMapping("/measurements")
public class MeasurementsController {

  private final MeasurementService measurementService;
  private final MeasurementValidator measurementValidator;

  @Autowired
  public MeasurementsController(final MeasurementService measurementService, final MeasurementValidator measurementValidator) {
    this.measurementService = measurementService;
    this.measurementValidator = measurementValidator;
  }

  @PostMapping("/add")
  public ResponseEntity<HttpStatus> add(@RequestBody @Valid MeasurementDTO measurementDTO, BindingResult bindingResult) {
    Measurement measurement = MeasurementMapper.INSTANCE.mapToMeasurement(measurementDTO);

    measurementValidator.validate(measurement, bindingResult);
    if (bindingResult.hasErrors()) {
      returnErrorsToClient(bindingResult);
    }

    measurementService.addMeasurement(measurement);
    return ResponseEntity.ok(HttpStatus.OK);
  }

  @GetMapping()
  public List<MeasurementDTO> getMeasurements() {
    return measurementService.findAll();
  }

  @GetMapping("/rainyDaysCount")
  public Long getRainyDaysCount() {
    return measurementService.findAll().stream().filter(MeasurementDTO::getRaining).count();
  }


}
