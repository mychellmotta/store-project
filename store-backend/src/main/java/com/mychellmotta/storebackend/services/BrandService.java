package com.mychellmotta.storebackend.services;

import com.mychellmotta.storebackend.entity.Brand;
import com.mychellmotta.storebackend.repository.BrandRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Transactional
    public Brand insert(Brand brand) {
        brand.setInsertDate(new Date());
        return brandRepository.save(brand);
    }

    @Transactional
    public Brand update(Brand brand) {
        brand.setUpdateDate(new Date());
        return brandRepository.save(brand);
    }

    public void delete(Long id) {
        brandRepository.deleteById(id);
    }
}
