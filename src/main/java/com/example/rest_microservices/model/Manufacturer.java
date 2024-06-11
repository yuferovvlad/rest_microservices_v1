package com.example.rest_microservices.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Manufacturer  implements Serializable {
    @JsonProperty(value = "Mfr_ID")
    private String mfrId;
    @JsonProperty(value = "Mfr_Name")
    private String mfrName;
    @JsonProperty(value = "Country")
    private String country;

    public String getMfrId() {
        return mfrId;
    }

    public void setMfrId(String mfrId) {
        this.mfrId = mfrId;
    }

    public String getMfrName() {
        return mfrName;
    }

    public void setMfrName(String mfrName) {
        this.mfrName = mfrName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
