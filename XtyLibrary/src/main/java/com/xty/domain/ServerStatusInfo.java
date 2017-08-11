package com.xty.domain;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import java.util.List;
import java.util.Date;

/**
 * Created by frank.wu on 2016/12/20.
 */
public class ServerStatusInfo {

    @JsonProperty(value = "ServerType")
    private String serverType;
    @JsonProperty(value = "ServerName")
    private String serverName;
    @JsonProperty(value = "HostName")
    private String hostName;
    @JsonProperty(value = "HostIP")
    private String hostIP;

    @JsonProperty(value = "Date")
    private Date date;
    @JsonProperty(value = "CPU")
    private Object cpu;
    @JsonProperty(value = "MEM")
    private Object mem;
    @JsonProperty(value = "Storage")
    private Object storage;

    @JsonProperty(value = "ServerInfo")
    private Object serverInfo;

    @JsonProperty(value = "Status")
    private String status;

    private List<ServerServiceInfo> listServerServiceInfo;

    @JsonIgnore
    public String getServerType() {
        return serverType;
    }
    @JsonProperty(value = "ServerType")
    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    @JsonIgnore
    public String getServerName() {
        return serverName;
    }
    @JsonProperty(value = "ServerName")
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    @JsonIgnore
    public String getHostName() {
        return hostName;
    }
    @JsonProperty(value = "HostName")
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    @JsonIgnore
    public String getHostIP() {
        return hostIP;
    }
    @JsonProperty(value = "HostIP")
    public void setHostIP(String hostIP) {
        this.hostIP = hostIP;
    }

    @JsonIgnore
    public Date getDate() {
        return date;
    }
    @JsonProperty(value = "Date")
    public void setDate(Date date) {
        this.date = date;
    }

    @JsonIgnore
    public Object getCpu() {
        return cpu;
    }
    @JsonProperty(value = "CPU")
    public void setCpu(Object cpu) {
        this.cpu = cpu;
    }

    @JsonIgnore
    public Object getMem() {
        return mem;
    }
    @JsonProperty(value = "MEM")
    public void setMem(Object mem) {
        this.mem = mem;
    }

    @JsonIgnore
    public Object getStorage() {
        return storage;
    }
    @JsonProperty(value = "Storage")
    public void setSoroage(Object storage) {
        this.storage = storage;
    }

    @JsonIgnore
    public Object getServerInfo() {
        return serverInfo;
    }
    @JsonProperty(value = "ServerInfo")
    public void setServerInfo(Object serverInfo) {
        this.serverInfo = serverInfo;
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

