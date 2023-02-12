package com.example.LibraryProject.Config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(value = BookNotAvailableException.class)
  public ResponseEntity handleBookNotAvailableException(BookNotAvailableException ex){

    List<String> errors = new ArrayList<>();
    errors.add("Book with given ID is already issued so not available");

    ErrorResponse errorResponse=
        ErrorResponse.builder()
                      .message(errors)
                      .ApplErrorCode("HBR_401")
                      .devMessage(ex.getMessage())
                      .status(HttpStatus.CONFLICT)
                      .build();
    return new ResponseEntity<>(errorResponse,HttpStatus.NOT_ACCEPTABLE);
  }

}
