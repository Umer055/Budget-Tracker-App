package gui.expense_gui.self_gui;

import javax.swing.*;

import gui.Main_frame;
import gui.display;
import gui.expense_gui.expense_frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class self_frame extends JFrame {
    private Container c;
    private JLabel title;
    private JButton apperal,household,beauty,health,back_Button,home_button;
    public self_frame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,300);
        setResizable(false);
        setTitle("Expense !!!!");

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#FC9E4F"));


        title = new JLabel("SELECT SELF TYPE");
        title.setSize(300, 30);
        title.setLocation(108, 10);
        title.setForeground(Color.decode("#093A3E")); 
        Font arialBold = new Font("Arial", Font.BOLD,19);
        title.setFont(arialBold);
        c.add(title);
        
        Font arialBoldfont = new Font("Roboto", Font.BOLD,14);
        apperal = new JButton("Apperal");
        apperal.setSize(320, 25);
        apperal.setLocation(40, 120);
        apperal.setForeground(Color.decode("#093A3E"));
        apperal.setBackground(Color.decode("#EDD382")); 
        apperal.setOpaque(true);
        apperal.setBorderPainted(false);
        apperal.setFont(arialBoldfont);
        c.add(apperal);

        household = new JButton("HouseHold");
        household.setSize(320, 25);
        household.setLocation(40, 150);
        household.setForeground(Color.decode("#093A3E"));
        household.setBackground(Color.decode("#EDD382")); 
        household.setOpaque(true);
        household.setBorderPainted(false);
        household.setFont(arialBoldfont);
        c.add(household);

        beauty = new JButton("Beauty");
        beauty.setSize(320, 25);
        beauty.setLocation(40, 180);
        beauty.setForeground(Color.decode("#093A3E"));
        beauty.setBackground(Color.decode("#EDD382")); 
        beauty.setOpaque(true);
        beauty.setBorderPainted(false);
        beauty.setFont(arialBoldfont);
        c.add(beauty);
    
        health = new JButton("Health");
        health.setSize(320, 25);
        health.setLocation(40, 210);
        health.setForeground(Color.decode("#093A3E"));
        health.setBackground(Color.decode("#EDD382")); 
        health.setOpaque(true);
        health.setBorderPainted(false);
        health.setFont(arialBoldfont);
        c.add(health);

        home_button = new JButton("Home");
        home_button.setSize(150, 32);
        home_button.setLocation(40,240);
        home_button.setForeground(Color.decode("#093A3E"));
        home_button.setBackground(Color.decode("#EDD382")); 
        home_button.setOpaque(true);
        home_button.setBorderPainted(false);
        home_button.setFont(arialBoldfont);
        c.add(home_button);

        back_Button = new JButton("Back");
        back_Button.setSize(150, 32);
        back_Button.setLocation(210,240);
        back_Button.setForeground(Color.decode("#093A3E"));
        back_Button.setBackground(Color.decode("#EDD382")); 
        back_Button.setOpaque(true);
        back_Button.setBorderPainted(false);
        back_Button.setFont(arialBoldfont);
        c.add(back_Button);

        MyActionListener a = new MyActionListener();
        apperal.addActionListener(a);
        household.addActionListener(a);
        beauty.addActionListener(a);
        health.addActionListener(a);
        home_button.addActionListener(a);
        back_Button.addActionListener(a);
        setLocationRelativeTo(null);
        setVisible(true);

        
    }

    public class MyActionListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Apperal")) {
                dispose();
                title_apperal title = new title_apperal();
            }else if (e.getActionCommand().equals("HouseHold")) {
                dispose();
                title_household title = new title_household();
            }else if (e.getActionCommand().equals("Beauty")) {
                dispose();
                title_beauty title = new title_beauty();
            }else if (e.getActionCommand().equals("Health")) {
                dispose();
                title_Health title = new title_Health();
            }else if (e.getActionCommand().equals("Back")) {
                dispose();
                expense_frame ex = new expense_frame();
            }else if (e.getActionCommand().equals("Home")) {
                dispose();
                Main_frame main = new Main_frame();
            }
        }
    }
}
