package com.company;

import java.io.Serializable;

public class BuyerData implements Serializable {
    private String login;
    private String password;
    private String address;
    private String telephoneNumber;
    private long id;

    public BuyerData() {
    }

    public BuyerData(String login, String password, String address, String telephoneNumber,long id) {
        this.login = login;
        this.password = password;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.id=id;
    }

    public BuyerData(String login, String password, String address, String telephoneNumber) {
        this.login = login;
        this.password = password;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toString() {
        return "GuestData{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", id=" + id +
                '}';
    }
}

