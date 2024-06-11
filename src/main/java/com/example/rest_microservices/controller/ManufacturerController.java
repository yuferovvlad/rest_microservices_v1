package com.example.rest_microservices.controller;

import com.example.rest_microservices.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @PostMapping("/fetch-manufacturers")
    public void fetchManufacturers() {
        manufacturerService.fetchAndSaveManufacturers();
    }

    @GetMapping("/manufacturer-count")
    public List<Map<String, Object>> getManufacturerCountByCountry(
            @RequestParam(required = false) Integer min,
            @RequestParam(required = false) Integer max) {
        if (min == null) min = 0;
        if (max == null) max = Integer.MAX_VALUE;
        return manufacturerService.getManufacturerCountByCountry(min, max);
    }
}

