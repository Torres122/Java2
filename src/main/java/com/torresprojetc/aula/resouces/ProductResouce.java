package com.torresprojetc.aula.resouces;

import com.torresprojetc.aula.entities.Order;
import com.torresprojetc.aula.entities.Product;
import com.torresprojetc.aula.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping (value = "/products")
public class ProductResouce {


    @Autowired
        private ProductService productService;


    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> productList = productService.findAll();
        return ResponseEntity.ok().body(productList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Product não encontrado com id: " + id)
                );
    }

}
