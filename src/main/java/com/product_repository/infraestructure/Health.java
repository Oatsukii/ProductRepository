package com.product_repository.infraestructure;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Health {
    @GetMapping("")
    public Map<String, String> get(){
        Map<String, String> response = new HashMap<>();
        response.put("message", "Ruta no Accesible" );
        return response;
    }
}
