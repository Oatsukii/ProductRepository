package com.product_repository.exception;

/**
 * @author Gustavo Padilla Ruiz GPR
 * Excepción personalizada que se utiliza para indicar que un producto no se encontró.
 * Esta clase hereda de {@link RuntimeException} y proporciona diferentes constructores
 * para especificar el mensaje de error de manera más detallada.
 */
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super( "No hay registros");
    }

    public ProductNotFoundException(String message) {
        super(message + " no fue encontrado. ");
    }

    public ProductNotFoundException(Long id) {
        super("El id " + id + " del producto no fue encontrado");
    }
}
