package com.example.rest_microservices.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class ManufacturerResponse implements Serializable {

    @JsonProperty(value = "Results")
    private List<Manufacturer> results;

    public List<Manufacturer> getResults() {
        return results;
    }

    public void setResults(List<Manufacturer> results) {
        this.results = results;
    }
}
