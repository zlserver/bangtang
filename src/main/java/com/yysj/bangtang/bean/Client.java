package com.yysj.bangtang.bean;

import java.util.Date;

public class Client {
    private String email;

    private String password;

    private String token;

    private String nickname;

    private Integer gender;

    private String nation;

    private String picpath;

    private Date activelasttime;

    private String resetcode;

    private String activecode;

    private Integer emailstatus;

    private Date regtime;

    private Date relotime;

    private String machine;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath == null ? null : picpath.trim();
    }

    public Date getActivelasttime() {
        return activelasttime;
    }

    public void setActivelasttime(Date activelasttime) {
        this.activelasttime = activelasttime;
    }

    public String getResetcode() {
        return resetcode;
    }

    public void setResetcode(String resetcode) {
        this.resetcode = resetcode == null ? null : resetcode.trim();
    }

    public String getActivecode() {
        return activecode;
    }

    public void setActivecode(String activecode) {
        this.activecode = activecode == null ? null : activecode.trim();
    }

    public Integer getEmailstatus() {
        return emailstatus;
    }

    public void setEmailstatus(Integer emailstatus) {
        this.emailstatus = emailstatus;
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    public Date getRelotime() {
        return relotime;
    }

    public void setRelotime(Date relotime) {
        this.relotime = relotime;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine == null ? null : machine.trim();
    }
}