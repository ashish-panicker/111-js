package in.stackroute.gettingstartedspringdatajpah2.exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptinoHandler extends ResponseEntityExceptionHandler{

    private Map<Object, Object> response;

    @ExceptionHandler(NoSuchMentorException.class)
    public ResponseEntity<Map<Object, Object>> handleNoSuchMentorException(
            NoSuchMentorException e) {
        response = new HashMap<>();
        response.put("message", e.getMessage());
        response.put("status", HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,
            WebRequest request) {
        response = new HashMap<>();
        List<String> errors = new ArrayList();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            errors.add(error.getDefaultMessage());
        });
        response.put("message", "Validation failed");
        response.put("status", HttpStatus.BAD_REQUEST);
        response.put("errors", errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    
}
