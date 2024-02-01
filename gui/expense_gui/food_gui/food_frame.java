package gui.expense_gui.food_gui;

import javax.swing.*;
import gui.Main_frame;
import gui.expense_gui.expense_frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class food_frame extends JFrame {
    private Container c;
    private JLabel title;
    private JButton breakfast, lunch, dinner, beverages, back_Button, home_button;

    public food_frame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setResizable(false);
        setTitle("Expense !!!!");

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#FC9E4F"));


        title = new JLabel("SELECT FOOD TYPE");
        title.setSize(300, 30);
        title.setLocation(101, 10);
        title.setForeground(Color.decode("#093A3E")); 
        Font arialBold = new Font("Arial", Font.BOLD,19);
        title.setFont(arialBold);
        c.add(title);

        Font arialBoldfont = new Font("Roboto", Font.BOLD,14);
        breakfast = new JButton("breakfast");
        breakfast.setSize(320, 25);
        breakfast.setLocation(40, 120);
        breakfast.setForeground(Color.decode("#093A3E"));
        breakfast.setBackground(Color.decode("#EDD382")); 
        breakfast.setOpaque(true);
        breakfast.setBorderPainted(false);
        breakfast.setFont(arialBoldfont);
        c.add(breakfast);

        lunch = new JButton("lunch");
        lunch.setSize(320, 25);
        lunch.setLocation(40, 150);
        lunch.setForeground(Color.decode("#093A3E"));
        lunch.setBackground(Color.decode("#EDD382")); 
        lunch.setOpaque(true);
        lunch.setBorderPainted(false);
        lunch.setFont(arialBoldfont);
        c.add(lunch);

        dinner = new JButton("dinner");
        dinner.setSize(320, 25);
        dinner.setLocation(40, 180);
        dinner.setForeground(Color.decode("#093A3E"));
        dinner.setBackground(Color.decode("#EDD382")); 
        dinner.setOpaque(true);
        dinner.setBorderPainted(false);
        dinner.setFont(arialBoldfont);
        c.add(dinner);

        beverages = new JButton("beverages");
        beverages.setSize(320, 25);
        beverages.setLocation(40, 210);
        beverages.setForeground(Color.decode("#093A3E"));
        beverages.setBackground(Color.decode("#EDD382")); 
        beverages.setOpaque(true);
        beverages.setBorderPainted(false);
        beverages.setFont(arialBoldfont);
        c.add(beverages);

        home_button = new JButton("Home");
        home_button.setSize(150, 32);
        home_button.setLocation(40, 240);
        home_button.setForeground(Color.decode("#093A3E"));
        home_button.setBackground(Color.decode("#EDD382")); 
        home_button.setOpaque(true);
        home_button.setBorderPainted(false);
        home_button.setFont(arialBoldfont);
        c.add(home_button);

        back_Button = new JButton("Back");
        back_Button.setSize(150, 32);
        back_Button.setLocation(210, 240);
        back_Button.setForeground(Color.decode("#093A3E"));
        back_Button.setBackground(Color.decode("#EDD382")); 
        back_Button.setOpaque(true);
        back_Button.setBorderPainted(false);
        back_Button.setFont(arialBoldfont);
        c.add(back_Button);

        MyActionListener a = new MyActionListener();
        breakfast.addActionListener(a);
        lunch.addActionListener(a);
        dinner.addActionListener(a);
        beverages.addActionListener(a);
        home_button.addActionListener(a);
        back_Button.addActionListener(a);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public class MyActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("breakfast")) {
                dispose();
                title_breakfast title = new title_breakfast();
            } else if (e.getActionCommand().equals("lunch")) {
                dispose();
                title_lunch title = new title_lunch();
            } else if (e.getActionCommand().equals("dinner")) {
                dispose();
                title_dinner title = new title_dinner();
            } else if (e.getActionCommand().equals("beverages")) {
                dispose();
                title_beverages title = new title_beverages();
            } else if (e.getActionCommand().equals("Back")) {
                dispose();
                expense_frame ex = new expense_frame();
            } else if (e.getActionCommand().equals("Home")) {
                dispose();
                Main_frame main = new Main_frame();
            }
        }
    }
}
