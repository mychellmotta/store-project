package com.mychellmotta.storebackend.controller;

import com.mychellmotta.storebackend.entity.Product;
import com.mychellmotta.storebackend.entity.ProductImage;
import com.mychellmotta.storebackend.services.ProductImageService;
import com.mychellmotta.storebackend.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/product-image")
public class ProductImageController {

    public static String IMG_DIRECTORY = System.getProperty("user.dir") + "/imgs";
    private final ProductImageService productImageService;
    private final ProductService productService;

    public ProductImageController(ProductImageService productImageService,
                                  ProductService productService) {
        this.productImageService = productImageService;
        this.productService = productService;
    }

    @GetMapping("/")
    public List<ProductImage> findAll() {
        return productImageService.findAll();
    }

    @GetMapping("/{id}")
    public List<ProductImage> findAllByProductId(@PathVariable("id") Long id) {
        return productImageService.findAllByProductId(id);
    }

    @PostMapping("/{id}")
    public ProductImage insert(@RequestParam("image") MultipartFile file,
                               @PathVariable("id") Long id) throws IOException {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(IMG_DIRECTORY, file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
        ProductImage productImage = new ProductImage();
        productImage.setName(fileNames.toString());
        Optional<Product> product = productService.findById(id);
        productImage.setProduct(product.orElse(null));
        return productImageService.insert(productImage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        productImageService.delete(id);
        return ResponseEntity.ok().build();
    }
}
