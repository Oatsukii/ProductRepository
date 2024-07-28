package com.product_repository.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gustavo Padilla Ruiz GPR
 * Esta clase está anotada con {@link RestControllerAdvice} para manejar las excepciones
 * lanzadas por los controladores en la aplicación. Utiliza la anotación {@link ExceptionHandler}
 * para capturar excepciones específicas, en este caso {@link ProductNotFoundException}, y devolver
 * una respuesta HTTP adecuada.
 * Cuando se lanza una {@link ProductNotFoundException}, el método {@link #handleProductNotFoundException(ProductNotFoundException)}
 * construye una respuesta con un mensaje de error y un código de estado HTTP 404 (No Encontrado).
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)

    public ResponseEntity<Map<String, String>> handleProductNotFoundException(ProductNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
