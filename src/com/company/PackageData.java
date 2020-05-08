package com.company;

import java.io.*;
import java.util.ArrayList;

public class PackageData implements Serializable {
    String operationType;
    ArrayList<Books> books;
    ArrayList<Orders> orders;
    ArrayList<BuyerData> buyers;
    BuyerData buyer;
    Orders order;;
    Books book;
    Long id;


    public PackageData() {
    }

    public PackageData(String operationType, ArrayList<Books> books, ArrayList<Orders> orders, ArrayList<BuyerData> buyers, BuyerData buyer, Orders order, Books book, Long id) {
        this.operationType = operationType;
        this.books = books;
        this.orders = orders;
        this.buyers = buyers;
        this.buyer = buyer;
        this.order = order;
        this.book = book;
        this.id = id;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public ArrayList<Books> getBooks() {
        return books;
    }

    public Books getBook() {
        return book;
    }

    public void setBooks(ArrayList<Books> books) {
        this.books = books;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<Orders> getOrders() { return orders; }

    public ArrayList<BuyerData> getBuyers() { return buyers; }

    public BuyerData getBuyer() {
        return buyer;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrders(ArrayList<Orders> orders) {
        this.orders = orders;
    }

    public void setBuyers(ArrayList<BuyerData> buyers) {
        this.buyers = buyers;
    }

    public void setBuyer(BuyerData buyer) {
        this.buyer = buyer;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "PackageData{" +
                "operationType='" + operationType + '\'' +
                ", books=" + books +
                ", orders=" + orders +
                ", buyers=" + buyers +
                ", buyer=" + buyer +
                ", order=" + order +
                ", book=" + book +
                ", id=" + id +
                '}';
    }
}
