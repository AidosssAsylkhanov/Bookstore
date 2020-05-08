package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BuyerListPage extends Container {
    private JLabel label;
    private JButton btn;
    private JTextArea area;

    public BuyerListPage(){
        setLayout(null);
        setSize(700,700);

        label=new JLabel("LIST");
        label.setBounds(10,10,50,20);

        area = new JTextArea();
        area.setSize(600,400);
        area.setLocation(50,50);
        add(area);

        btn = new JButton("BACK");
        btn.setLocation(210,550);
        btn.setSize(300,30);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Buyer.frame.addOrders.setVisible(false);
                Buyer.frame.listOrders.setVisible(false);
                Buyer.frame.menu.setVisible(true);
                Buyer.frame.repaint();
            }
        });
        add(btn);
    }

    public void updateArea(ArrayList<Orders> orders){
        area.setText("");
        for(Orders ts: orders){
            area.append(ts+"\n");
        }
        repaint();
    }

}
