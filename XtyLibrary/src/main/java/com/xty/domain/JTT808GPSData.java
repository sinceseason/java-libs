package com.xty.domain;

import java.util.List;

public class JTT808GPSData {
    private String device_id;
    private List<BDGPSData> location;

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public List<BDGPSData> getLocation() {
        return location;
    }

    public void setLocation(List<BDGPSData> location) {
        this.location = location;
    }
}
