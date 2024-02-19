package com.mychellmotta.storebackend.services;

import com.mychellmotta.storebackend.entity.City;
import com.mychellmotta.storebackend.repository.CityRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Transactional
    public City insert(City city) {
        city.setInsertDate(new Date());
        return cityRepository.save(city);
    }

    @Transactional
    public City update(City city) {
        city.setUpdateDate(new Date());
        return cityRepository.save(city);
    }

    @Transactional
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }
}
