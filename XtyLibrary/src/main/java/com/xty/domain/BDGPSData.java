package com.xty.domain;

import com.xty.common.BaseUtil;

import java.util.Date;

public class BDGPSData {
    private double latitude;
    private double longitude;
    private String ts;
    private Date date;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
        this.setDate(BaseUtil.ConvertStringToDate("yyMMddHHmmss", ts));
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
