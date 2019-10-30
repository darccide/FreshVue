
package com.darccide.FreshVue.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintViolationException;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handle(ConstraintViolationException e) {
        ErrorResponse errors = new ErrorResponse();
        e.getConstraintViolations().stream().map((violation) -> {
            ErrorItem error = new ErrorItem();
            error.setCode(violation.getMessageTemplate());
            error.setMessage(violation.getMessage());
            return error;
        }).forEachOrdered((error) -> {
            errors.addError(error);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorItem> handle(ResourceNotFoundException e) {
        ErrorItem error = new ErrorItem();
        error.setMessage(e.getMessage());
        
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    
    @Data
    @NoArgsConstructor
    public static class ErrorItem {
        
        @JsonInclude(JsonInclude.Include.NON_NULL) 
        private String code;
        private String Message;
    }
    
    @Data
    @NoArgsConstructor
    public static class ErrorResponse {
        private List<ErrorItem> errors = new ArrayList<>();
    
        public void addError(ErrorItem error) {
            this.errors.add(error);
        }
    }
}
