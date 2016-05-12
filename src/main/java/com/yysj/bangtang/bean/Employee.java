package com.yysj.bangtang.bean;

import java.util.Date;

public class Employee {
    private String account;

    private String password;

    private Integer state;

    private Integer gender;

    private Integer logincount;

    private Date reclogtime;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getLogincount() {
        return logincount;
    }

    public void setLogincount(Integer logincount) {
        this.logincount = logincount;
    }

    public Date getReclogtime() {
        return reclogtime;
    }

    public void setReclogtime(Date reclogtime) {
        this.reclogtime = reclogtime;
    }
}