package com.xty.platModel.basic;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Eugene on 2015/8/21.
 */
@Table(name = "operationlog")
@Entity
public class OperationLog {
    public OperationLog() {
    }

    public OperationLog(String uid, Date begin, Date end) {
        this.setS_user(uid);
        this.setBegin(begin);
        this.setEnd(end);
    }

    public OperationLog(String s_module, String s_type){
        this.setS_module(s_module);
        this.setS_type(s_type);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "n_ID")
    private Integer n_ID;

    @Column(name = "s_type")
    private String s_type;

    @Column(name = "s_module")
    private String s_module;

    @Column(name = "s_user")
    private String s_user;

    @Column(name = "s_userName")
    private String s_userName;

    @Column(name = "s_memo")
    private String s_memo;

    @Column(name = "s_ip")
    private String s_ip;

    @Column(name = "d_date")
    private Date d_date;

    @Transient
    private Date begin;
    @Transient
    private Date end;

    @JsonIgnore
    @Transient
    private String moduleColName;
    @JsonIgnore
    @Transient
    private String typeColName;
    @JsonIgnore
    @Transient
    private String usernameColName;
    @JsonIgnore
    @Transient
    private String dateColName;
    @JsonIgnore
    @Transient
    private String ipColName;

    public Integer getN_ID() {
        return n_ID;
    }

    public void setN_ID(Integer n_ID) {
        this.n_ID = n_ID;
    }

    public String getS_type() {
        return s_type;
    }

    public void setS_type(String s_type) {
        this.s_type = s_type;
    }

    public String getS_module() {
        return s_module;
    }

    public void setS_module(String s_module) {
        this.s_module = s_module;
    }

    public String getS_user() {
        return s_user;
    }

    public void setS_user(String s_user) {
        this.s_user = s_user;
    }

    public String getS_userName() {
        return s_userName;
    }

    public void setS_userName(String s_userName) {
        this.s_userName = s_userName;
    }

    public String getS_memo() {
        return s_memo;
    }

    public void setS_memo(String s_memo) {
        this.s_memo = s_memo;
    }

    public String getS_ip() {
        return s_ip;
    }

    public void setS_ip(String s_ip) {
        this.s_ip = s_ip;
    }

    public Date getD_date() {
        return d_date;
    }

    public void setD_date(Date d_date) {
        this.d_date = d_date;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getModuleColName() {
        return moduleColName;
    }

    public void setModuleColName(String moduleColName) {
        this.moduleColName = moduleColName;
    }

    public String getTypeColName() {
        return typeColName;
    }

    public void setTypeColName(String typeColName) {
        this.typeColName = typeColName;
    }

    public String getUsernameColName() {
        return usernameColName;
    }

    public void setUsernameColName(String usernameColName) {
        this.usernameColName = usernameColName;
    }

    public String getDateColName() {
        return dateColName;
    }

    public void setDateColName(String dateColName) {
        this.dateColName = dateColName;
    }

    public String getIpColName() {
        return ipColName;
    }

    public void setIpColName(String ipColName) {
        this.ipColName = ipColName;
    }
}
