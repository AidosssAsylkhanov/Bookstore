package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class BuyerAddPage extends Container {
    private JLabel labelFoodsId;
    private JLabel labelName;
    private JTextField textName;
    private JLabel labelSurname;
    private JTextField textSurname;
    private JLabel labelPasswordNumber;
    private JTextField textPasswordNumber;
    private JButton addOrders;
    private JButton back;

    public BuyerAddPage(){
        setLayout(null);
        setSize(700,700);

        labelFoodsId=new JLabel("Book_Id:");
        labelFoodsId.setBounds(100,150,120,40);
        add(labelFoodsId);

        Books[]books=null;
        ArrayList<Books> list = Buyer.listbooks();
        books = list.toArray(new Books[list.size()]);

        final JComboBox comboBox=new JComboBox(books);
        comboBox.setBounds(230,150,250,40);
        add(comboBox);
        labelName=new JLabel("Name:");
        labelName.setBounds(100,200,120,40);
        add(labelName);

        textName=new JTextField();
        textName.setBounds(230,200,250,40);
        add(textName);

        labelSurname=new JLabel("Surname:");
        labelSurname.setBounds(100,250,120,40);
        add(labelSurname);

        textSurname=new JTextField();
        textSurname.setBounds(230,250,250,40);
        add(textSurname);

        labelPasswordNumber=new JLabel("PasswordNumber");
        labelPasswordNumber.setBounds(100,300,120,40);
        add(labelPasswordNumber);

        textPasswordNumber=new JTextField();
        textPasswordNumber.setBounds(230,300,250,40);
        add(textPasswordNumber);

        addOrders=new JButton("ADD");
        addOrders.setBounds(100,400,120,50);
        addOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Books mybooks = (Books) comboBox.getSelectedItem();
                    Orders orders=new Orders(null,mybooks.getId().intValue(),textName.getText(),textSurname.getText(),textPasswordNumber.getText());
                    Buyer.addOrders(orders);

                    textName.setText("");
                    textSurname.setText("");
                    textPasswordNumber.setText("");

                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        add(addOrders);

        back=new JButton("BACK");
        back.setBounds(360,400,120,50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Buyer.frame.addOrders.setVisible(false);
                Buyer.frame.listOrders.setVisible(false);
                Buyer.frame.menu.setVisible(true);
                Buyer.frame.repaint();
            }
        });
        add(back);
    }
}

