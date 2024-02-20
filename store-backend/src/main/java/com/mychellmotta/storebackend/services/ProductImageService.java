package com.mychellmotta.storebackend.services;

import com.mychellmotta.storebackend.entity.ProductImage;
import com.mychellmotta.storebackend.repository.ProductImageRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageService {

    private final ProductImageRepository productImageRepository;

    public ProductImageService(ProductImageRepository productImageRepository) {
        this.productImageRepository = productImageRepository;
    }

    public List<ProductImage> findAll() {
        return productImageRepository.findAll();
    }

    public List<ProductImage> findAllByProductId(Long id) {
        return productImageRepository.findAllByProductId(id);
    }

    @Transactional
    public ProductImage insert(ProductImage productImage) {
        return productImageRepository.save(productImage);
    }

    @Transactional
    public void delete(Long id) {
        productImageRepository.deleteById(id);
    }
}
