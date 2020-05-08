package com.company;

import java.io.Serializable;

public class Books implements Serializable {
    private Long id;
    private String kindofbook;
    private String name;
    private int price;

    public Books(){}

    public Books(Long id, String kindofbook, String name, int price) {
        this.id = id;
        this.kindofbook = kindofbook;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getKindofbook() {
        return kindofbook;
    }

    public void setKindofbook(String kindofbook) {
        this.kindofbook = kindofbook;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", kindofbook='" + kindofbook + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
