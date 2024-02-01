package gui.expense_gui;

import javax.swing.*;

import gui.Main_frame;
import gui.expense_gui.food_gui.food_frame;
import gui.expense_gui.self_gui.self_frame;
import gui.expense_gui.social_gui.social_frame;
import gui.expense_gui.transport_gui.transport_frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class expense_frame extends JFrame{
    private Container c;
    private JLabel title;
    private JButton social,food,transport,self,back_Button;
    public expense_frame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,300);
        setResizable(false);
        setTitle("Expense !!!!");

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#FC9E4F"));


        title = new JLabel("SELECT EXPENSE TYPE");
        title.setSize(300, 30);
        title.setLocation(88, 10);
        title.setForeground(Color.decode("#093A3E")); 
        Font arialBold = new Font("Arial", Font.BOLD,19);
        title.setFont(arialBold);
        c.add(title);

        Font arialBoldfont = new Font("Roboto", Font.BOLD,14);
        food = new JButton("Food");
        food.setSize(320, 25);
        food.setLocation(40, 120);
        food.setForeground(Color.decode("#093A3E"));
        food.setBackground(Color.decode("#EDD382")); 
        food.setOpaque(true);
        food.setBorderPainted(false);
        food.setFont(arialBoldfont);
        c.add(food);

        transport = new JButton("Transport");
        transport.setSize(320, 25);
        transport.setLocation(40, 150);
        transport.setForeground(Color.decode("#093A3E"));
        transport.setBackground(Color.decode("#EDD382")); 
        transport.setOpaque(true);
        transport.setBorderPainted(false);
        transport.setFont(arialBoldfont);
        c.add(transport);

        social = new JButton("Social life");
        social.setSize(320, 25);
        social.setLocation(40, 180);
        social.setForeground(Color.decode("#093A3E"));
        social.setBackground(Color.decode("#EDD382")); 
        social.setOpaque(true);
        social.setBorderPainted(false);
        social.setFont(arialBoldfont);
        c.add(social);
    
        self = new JButton("Self Development");
        self.setSize(320, 25);
        self.setLocation(40, 210);
        self.setForeground(Color.decode("#093A3E"));
        self.setBackground(Color.decode("#EDD382")); 
        self.setOpaque(true);
        self.setBorderPainted(false);
        self.setFont(arialBoldfont);
        c.add(self);

        back_Button = new JButton("Back");
        back_Button.setSize(160, 32);
        back_Button.setLocation(200,240);
        back_Button.setForeground(Color.decode("#093A3E"));
        back_Button.setBackground(Color.decode("#EDD382")); 
        back_Button.setOpaque(true);
        back_Button.setBorderPainted(false);
        back_Button.setFont(arialBoldfont);
        c.add(back_Button);

        MyActionListener a = new MyActionListener();
        food.addActionListener(a);
        transport.addActionListener(a);
        social.addActionListener(a);
        self.addActionListener(a);
        back_Button.addActionListener(a);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public class MyActionListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Food")) {
                dispose();
                food_frame food = new food_frame();
            }else if (e.getActionCommand().equals("Transport")) {
                dispose();
                transport_frame transport = new transport_frame();
            }else if (e.getActionCommand().equals("Social life")) {
                dispose();
                social_frame social = new social_frame();
            }else if (e.getActionCommand().equals("Self Development")) {
                dispose();
                self_frame self = new self_frame();
            }else if (e.getActionCommand().equals("Back")) {
                dispose();
                Main_frame main = new Main_frame();
            }else if (e.getActionCommand().equals("Exit")) {
                System.exit(0);
            }
        }
    }
}
