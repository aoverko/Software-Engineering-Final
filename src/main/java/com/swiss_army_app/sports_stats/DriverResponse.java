package com.swiss_army_app.sports_stats;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DriverResponse {
    @JsonProperty("response")
    private List<Driver> drivers;

    public List<Driver> getDrivers() {
        return drivers;
    }
    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }
}
