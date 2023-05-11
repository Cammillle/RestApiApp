package RestApp.exception;

import java.util.List;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class ErrorClientResponse {

  public static void returnErrorsToClient(BindingResult bindingResult) {
    StringBuilder errorMsg = new StringBuilder();

    List<FieldError> errors = bindingResult.getFieldErrors();
    for (FieldError error : errors) {
      errorMsg.append("Field: ")
          .append(error.getField())
          .append(" - ").append(error.getDefaultMessage() == null ? error.getCode() : error.getDefaultMessage())
          .append(";");
    }
    throw new MeasurementException(errorMsg.toString());
  }

}
