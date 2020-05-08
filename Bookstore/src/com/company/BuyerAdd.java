package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BuyerAdd extends Container {
    private JLabel login;
    private JTextField textLogin;
    private JPasswordField textpassword;
    private JLabel password;
    private JButton signIn;
    private JButton registr;
    private JLabel welcome;


    public BuyerAdd () {
        setLayout(null);
        setSize(700, 700);

        login = new JLabel("Login:");
        login.setBounds(250, 150, 80, 40);
        add(login);
        textLogin = new JTextField();
        textLogin.setBounds(340, 150, 100, 40);
        add(textLogin);

        password = new JLabel("Password:");
        password.setBounds(250, 200, 80, 40);
        add(password);

        textpassword = new JPasswordField();
        textpassword.setBounds(340, 200, 100, 40);
        add(textpassword);
        welcome = new JLabel("");
        welcome.setBounds(250, 400, 80, 40);
        add(welcome);



        registr=new JButton("Registr");
        registr.setBounds(340,310,100,50);
        registr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Buyer.showRegistrPage();
            }
        });
        add(registr);

        signIn=new JButton("Sign_in");
        signIn.setBounds(340,250,100,50);
        signIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<BuyerData> buyers= Buyer.listBuyers();

                for( int i=0;i<buyers.size();i++){
                    if(buyers.get(i).getLogin().equals(textLogin.getText()) && buyers.get(i).getPassword().equals(textpassword.getText())){
                        Buyer.myLogin(buyers.get(i).getLogin());
                        Buyer.showMainMenu();
                        break;
                    }
                    else{
                        welcome.setText("Wrong password or login");
                    }


                }
            }
        });
        add(signIn);
        repaint();

    }

    int x=0, y=100;
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        Font font = new Font("Tahoma",Font.BOLD+Font.PLAIN,50);
        g2.setFont(font);
        g2.setColor(Color.PINK);
        g2.drawString("Register part",x,y);
        try{
            Thread.sleep(100);
        }catch (Exception ex){}
        x+=10;
        if(x>this.getWidth()){
            x=0;
        }
        repaint();
    }
}

