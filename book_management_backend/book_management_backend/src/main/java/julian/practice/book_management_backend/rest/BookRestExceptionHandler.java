package julian.practice.book_management_backend.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;

// Global exception handling
@ControllerAdvice
public class BookRestExceptionHandler {

    // Generic Exception Handler is triggered if not defined endpoints are called
    @ExceptionHandler
    public ResponseEntity<BookErrorResponse> handleException(Exception ex) {

        // create a BookErrorResponse
        BookErrorResponse error = new BookErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
