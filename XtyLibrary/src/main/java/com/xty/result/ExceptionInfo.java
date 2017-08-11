package com.xty.result;

import java.util.Date;

/**
 * Created by eugene on 16/3/21.
 */
public class ExceptionInfo {
    private Date time;

    private String error;

    private String service;

    private String method;

    public ExceptionInfo(Date time, String error, String service, String method) {
        this.time = time;
        this.error = error;
        this.service = service;
        this.method = method;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
