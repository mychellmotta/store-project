package com.mychellmotta.storebackend.controller;

import com.mychellmotta.storebackend.entity.Brand;
import com.mychellmotta.storebackend.services.BrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/brand")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/")
    public List<Brand> getAll() {
        return brandService.getAll();
    }

    @PostMapping("/")
    public Brand insert(@RequestBody Brand brand) {
        return brandService.insert(brand);
    }

    @PutMapping("/")
    public Brand update(@RequestBody Brand brand) {
        return brandService.update(brand);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        brandService.delete(id);
        return ResponseEntity.ok().build();
    }
}
