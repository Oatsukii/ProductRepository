package com.product_repository.application;

import com.product_repository.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Extiende  {@link JpaRepository}
 *  interfaz JPA que proporciona métodos para realizar operaciones CRUD y consultas en la base de datos.
 * @author Gustavo Padilla Ruiz GPR
 */

public interface ProductApplication extends JpaRepository<Product, Long>{
    List<Product> findByName(String name);
    List<Product> findByPrice(float price);
    List<Product> findByNameContaining(String name);
}
