package com.product_repository.infraestructure;

import com.product_repository.application.ProductApplication;
import com.product_repository.domain.Product;
import com.product_repository.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Gustavo Padilla Ruiz GPR
 * Controlador REST para manejar las operaciones CRUD de productos.
 * Esta clase expone endpoints para crear, leer, actualizar y eliminar productos.
 * Utiliza la anotación {@link RestController} para definir que esta clase maneja solicitudes web y
 * la anotación {@link RequestMapping} para mapear las solicitudes a la ruta base "/products".
 * Los métodos de este controlador interactúan con la capa de servicio a través de la instancia inyectada
 * {@link ProductApplication} para realizar operaciones sobre los productos.
 */
@RestController("")

@RequestMapping("/products")
public class ProductController {

    /**  inyectar automáticamente las dependencias de una clase  */
    @Autowired
    public ProductApplication productApplication;

    @GetMapping("")
    public  List<Product> getAll(){
        List<Product> products = productApplication.findAll();
        if (products.isEmpty()){
            throw  new ProductNotFoundException();
        }
        return products;
    }

    @GetMapping("/name")
    public List<Product> gertProductByName(@RequestParam String name){
        List<Product> products = productApplication.findByNameContaining(name);
        if (products.isEmpty()) {
            throw new ProductNotFoundException(name);
        }
        return products;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productApplication.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PostMapping("/crear")
    public Product createProduct(@RequestBody Product product){
        return productApplication.save(product);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {

        Product productToUpdate = productApplication.findById(id).orElseThrow(() -> new ProductNotFoundException(id)); /* Busca Producto */
        productToUpdate.setName(product.getName());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setStock(product.getStock());

        return productApplication.save(productToUpdate);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteProduct(@PathVariable Long id) {
        productApplication.deleteById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Producto eliminado: " + id);
        return response;

    }


}
