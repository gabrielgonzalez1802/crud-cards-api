package com.example.duelocartas.excepcion;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidTipoCartaException.class)
    public ResponseEntity<?> handleInvalidTipoCartaException(InvalidTipoCartaException ex, WebRequest request) {
    	Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());    
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(InvalidTipoMonstruoException.class)
    public ResponseEntity<?> handleInvalidTipoMonstruoException(InvalidTipoMonstruoException ex, WebRequest request) {
    	Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());    
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}