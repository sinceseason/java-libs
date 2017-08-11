package com.xty.domain;


import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by frank.wu on 2016/12/20.
 */
public class ServerServiceInfo {

    @JsonProperty(value = "Name")
    private String name;
    @JsonProperty(value = "Status")
    private String status;
    @JsonProperty(value = "Ver")
    private String ver;
    @JsonProperty(value = "ELog")
    private String elog;

    @JsonIgnore
    public String getName() {
        return name;
    }
    @JsonProperty(value = "Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public String getStatus() {
        return status;
    }
    @JsonProperty(value = "Status")
    public void setStatus(String status) {
        this.status = status;
    }

}
