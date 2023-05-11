package RestApp.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SensorErrorResponse {

  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  @ExceptionHandler(SensorNotFountException.class)
  public Map<String, String> handleException(SensorNotFountException e) {
    Map<String, String> errors = new HashMap<>();
    errors.put("message", e.getMessage());
    return errors;
  }

}
