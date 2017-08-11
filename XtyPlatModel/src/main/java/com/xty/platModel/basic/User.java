package com.xty.platModel.basic;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Shadow on 2015/8/18.
 */
@Table(name = "user")
@Entity
public class User {
    public User() {
    }

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "roleid")
    private Integer roleid;

    @Column(name = "regist_time")
    private Date regist_time;

    @Column(name = "type")
    private Integer type;

    @Transient
    private String auth;
    @Transient
    private List<String> authNameList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Date getRegist_time() {
        return regist_time;
    }

    public void setRegist_time(Date regist_time) {
        this.regist_time = regist_time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public List<String> getAuthNameList() {
        return authNameList;
    }

    public void setAuthNameList(List<String> authNameList) {
        this.authNameList = authNameList;
    }
}
