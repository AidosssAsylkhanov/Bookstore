package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyerMainMenu extends Container {
    public JButton addOrders;
    public JButton list;
    public JButton exit;

    public BuyerMainMenu() {
        setSize(700, 700);
        setLayout(null);

        addOrders = new JButton("Add_Orders");
        addOrders.setLocation(200, 150);
        addOrders.setSize(300, 30);
        addOrders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Buyer.frame.menu.setVisible(false);
                Buyer.frame.listOrders.setVisible(false);
                Buyer.frame.addOrders.setVisible(true);
                Buyer.frame.repaint();
            }
        });
        add(addOrders);

        list = new JButton("List_Orders");
        list.setLocation(200, 190);
        list.setSize(300, 30);
        list.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Buyer.showListPage();
            }
        });
        add(list);


        exit = new JButton("EXIT");
        exit.setBounds(200, 350, 300, 30);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exit);

    }
}

