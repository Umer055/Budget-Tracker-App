package gui.expense_gui.social_gui;

import javax.swing.*;

import gui.Main_frame;
import gui.expense_gui.expense_frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class social_frame extends JFrame {
    private Container c;
    private JLabel title;
    private JButton friend,fellowship,alumini,dues,back_Button,home_button;
    public social_frame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,300);
        setResizable(false);
        setTitle("Expense !!!!");

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#FC9E4F"));


        title = new JLabel("SELECT SOCIAL TYPE");
        title.setSize(300, 30);
        title.setLocation(99, 10);
        title.setForeground(Color.decode("#093A3E")); 
        Font arialBold = new Font("Arial", Font.BOLD,19);
        title.setFont(arialBold);
        c.add(title);

        Font arialBoldfont = new Font("Roboto", Font.BOLD,14);
        friend = new JButton("Friend");
        friend.setSize(320, 25);
        friend.setLocation(40, 120);
        friend.setForeground(Color.decode("#093A3E"));
        friend.setBackground(Color.decode("#EDD382")); 
        friend.setOpaque(true);
        friend.setBorderPainted(false);
        friend.setFont(arialBoldfont);
        c.add(friend);

        fellowship = new JButton("Fellowship");
        fellowship.setSize(320, 25);
        fellowship.setLocation(40, 150);
        fellowship.setForeground(Color.decode("#093A3E"));
        fellowship.setBackground(Color.decode("#EDD382")); 
        fellowship.setOpaque(true);
        fellowship.setBorderPainted(false);
        fellowship.setFont(arialBoldfont);
        c.add(fellowship);

        alumini = new JButton("Alumini");
        alumini.setSize(320, 25);
        alumini.setLocation(40, 180);
        alumini.setForeground(Color.decode("#093A3E"));
        alumini.setBackground(Color.decode("#EDD382")); 
        alumini.setOpaque(true);
        alumini.setBorderPainted(false);
        alumini.setFont(arialBoldfont);       
        c.add(alumini);
    
        dues = new JButton("Dues");
        dues.setSize(320, 25);
        dues.setLocation(40, 210);
        dues.setForeground(Color.decode("#093A3E"));
        dues.setBackground(Color.decode("#EDD382")); 
        dues.setOpaque(true);
        dues.setBorderPainted(false);
        dues.setFont(arialBoldfont);
        c.add(dues);

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
        friend.addActionListener(a);
        fellowship.addActionListener(a);
        alumini.addActionListener(a);
        dues.addActionListener(a);
        home_button.addActionListener(a);
        back_Button.addActionListener(a);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public class MyActionListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Friend")) {
                dispose();
                title_friends title = new title_friends();
            }else if (e.getActionCommand().equals("Fellowship")) {
                dispose();
                title_friends title = new title_friends();
            }else if (e.getActionCommand().equals("Alumini")) {
                dispose();
                title_friends title = new title_friends();
            }else if (e.getActionCommand().equals("Dues")) {
                dispose();
                title_friends title = new title_friends();
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
