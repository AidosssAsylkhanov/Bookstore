package com.company;

import java.io.Serializable;

public class Orders implements Serializable {
    private Long id;
    private int bookId;
    private String name;
    private String surname;
    private String passwordNumber;

    public Orders(){}

    public Orders(Long id, int bookId, String name, String surname, String passwordNumber) {
        this.id = id;
        this.bookId = bookId;
        this.name = name;
        this.surname = surname;
        this.passwordNumber = passwordNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPasswordNumber() {
        return passwordNumber;
    }

    public void setPasswordNumber(String passwordNumber) {
        this.passwordNumber = passwordNumber;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", foodsId=" + bookId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passwordNumber=" + passwordNumber +
                '}';
    }
}

