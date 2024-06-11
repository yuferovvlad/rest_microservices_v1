package com.example.rest_microservices.service;

import com.example.rest_microservices.mapper.ManufacturerMapper;
import com.example.rest_microservices.model.Manufacturer;
import com.example.rest_microservices.model.ManufacturerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerMapper manufacturerMapper;

    public void fetchAndSaveManufacturers() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://vpic.nhtsa.dot.gov/api/vehicles/getallmanufacturers?format=json";
        ManufacturerResponse response = restTemplate.getForObject(url, ManufacturerResponse.class);

        if (response != null && response.getResults() != null) {
            for (Manufacturer manufacturer : response.getResults()) {
                manufacturerMapper.insertManufacturer(manufacturer);
            }
        }
    }

    public List<Map<String, Object>> getManufacturerCountByCountry(Integer min, Integer max) {
        return manufacturerMapper.countManufacturersByCountry(min, max);
    }
}


