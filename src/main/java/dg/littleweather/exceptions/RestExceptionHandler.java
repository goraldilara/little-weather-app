package dg.littleweather.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    //add exception controllers for generic exception/the city doesn't exist
    //exception
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAllExceptions(Exception exc){

        //creating the ErrorResponse object
        ErrorResponse error = new ErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //returning ResponseEntity
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
