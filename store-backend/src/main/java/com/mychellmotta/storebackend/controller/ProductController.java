package com.mychellmotta.storebackend.controller;

import com.mychellmotta.storebackend.entity.Product;
import com.mychellmotta.storebackend.services.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @PostMapping("/")
    public Product insert(@RequestBody Product product) {
        return productService.insert(product);
    }

    @PutMapping("/")
    public Product update(@RequestBody Product product) {
        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        productService.delete(id);
        return ResponseEntity.ok().build();
    }
}
