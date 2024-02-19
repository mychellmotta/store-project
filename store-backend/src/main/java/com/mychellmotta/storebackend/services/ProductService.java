package com.mychellmotta.storebackend.services;

import com.mychellmotta.storebackend.entity.Product;
import com.mychellmotta.storebackend.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public Product insert(Product product) {
        product.setInsertDate(new Date());
        return productRepository.save(product);
    }

    @Transactional
    public Product update(Product product) {
        product.setUpdateDate(new Date());
        return productRepository.save(product);
    }

    @Transactional
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
