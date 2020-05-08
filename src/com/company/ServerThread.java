package com.company;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

public class ServerThread extends Thread {
    private Connection connection;
    private Socket socket;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;
    public static Long id = null;

    public ServerThread(Socket socket, Connection connection) {
        this.socket = socket;
        this.connection = connection;
        try {
            inputStream = new ObjectInputStream(this.socket.getInputStream());
            outputStream = new ObjectOutputStream(this.socket.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void run() {
        try {
            PackageData pd = null;
            while ((pd = (PackageData) inputStream.readObject()) != null) {

                if (pd.getOperationType().equals("Add_Book")) {
                    try {
                        Books books = pd.getBook();
                        addFoodsToDb(books);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }   else if(pd.getOperationType().equals("Add_Orders")){
                    try {
                        Orders orders= pd.getOrders().get(0);
                        addOrdersToDb(orders);

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }   else if (pd.getOperationType().equals("List_Buyers")) {
                    ArrayList<BuyerData> buyers = getAllBuyers();
                    PackageData resp = new PackageData();
                    resp.setBuyers(buyers);
                    outputStream.writeObject(resp);
                }
                else if (pd.getOperationType().equals("List_Books")) {
                    ArrayList<Books> books = getBooks();
                    PackageData resp = new PackageData();
                    resp.setBooks(books);
                    outputStream.writeObject(resp);
                }   else if (pd.getOperationType().equals("Add_Buyer")) {
                    try {
                        BuyerData buyer = pd.getBuyer();
                        addBuyer(buyer);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }   else if(pd.getOperationType().equals("List_Orders")){
                    ArrayList<Orders>orders=getOrders();
                    PackageData pd2=new PackageData();
                    pd2.setOrders(orders);
                    outputStream.writeObject(pd2);
                }
                else if (pd.getOperationType().equals("Delete_Books")) {
                    Long id = pd.getId();
                    deleteBookToDB(id);
                } else {
                    break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Orders> getOrders() {
        ArrayList<Orders> orders = new ArrayList<Orders>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM orders";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                orders.add(new Orders(res.getLong("id"), res.getInt("bookId"), res.getString("name"), res.getString("surname"),res.getString("passwordNumber")));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }


    public void addBuyer(BuyerData buyer) {
        try {

            PreparedStatement pse = connection.prepareStatement("INSERT INTO buyerdata (login, password,address,telephoneNumber,id) VALUES(?,?,?,?,NULL)");
            pse.setString(1, buyer.getLogin());
            pse.setString(2, buyer.getPassword());
            pse.setString(3, buyer.getAddress());
            pse.setString(4, buyer.getTelephoneNumber());
            pse.executeUpdate();
            pse.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addFoodsToDb(Books books) {
        try {
            PreparedStatement ps=connection.prepareStatement("insert into books(id,kindofbook,name,price) values(null,?,?,?)");

            ps.setString(1,books.getKindofbook());
            ps.setString(2,books.getName());
            ps.setInt(3,books.getPrice());
            ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public ArrayList<BuyerData> getAllBuyers() {
        ArrayList<BuyerData> list = new ArrayList<BuyerData>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from buyerdata");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new BuyerData(rs.getString("login"), rs.getString("password"), rs.getString("address"), rs.getString("telephoneNumber"), rs.getLong("id")));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public  void addOrdersToDb(Orders orders) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into orders(id,bookId,name,surname,passwordNumber) values(null,?,?,?,?)");

            ps.setInt(1,orders.getBookId());
            ps.setString(2,orders.getName());
            ps.setString(3,orders.getSurname());
            ps.setString(4,orders.getPasswordNumber());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Books> getBooks() {
        ArrayList<Books> books = new ArrayList<Books>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM books";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                books.add(new Books(res.getLong("id"), res.getString("kindofbook"),res.getString("name"),res.getInt("price")));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    public void deleteBookToDB(Long id){
        try{
            PreparedStatement ps=connection.prepareStatement("DELETE FROM books WHERE id=?");
            ps.setLong(1,id);
            int rows= ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
