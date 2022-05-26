package co.edu.umanizales.battleships.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

public class ErrorHandlerConfig<GenericResponse> {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<?> handle(MethodArgumentNotValidException ex){
        //Extrae de la excepecion los errores
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        GenericResponse response = new GenericResponse( 409, null, errors.toString());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

