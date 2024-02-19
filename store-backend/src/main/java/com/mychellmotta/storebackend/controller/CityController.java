package com.mychellmotta.storebackend.controller;

import com.mychellmotta.storebackend.entity.City;
import com.mychellmotta.storebackend.services.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/")
    public List<City> getAll() {
        return cityService.getAll();
    }

    @PostMapping("/")
    public City insert(@RequestBody City city) {
        return cityService.insert(city);
    }

    @PutMapping("/")
    public City update(@RequestBody City city) {
        return cityService.update(city);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cityService.delete(id);
        return ResponseEntity.ok().build();
    }
}
