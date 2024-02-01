package gui.expense_gui.transport_gui;

import javax.swing.*;

import gui.Main_frame;
import gui.expense_gui.expense_frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class transport_frame extends JFrame {
    private Container c;
    private JLabel title;
    private JButton bus,subway,taxi,car,back_Button,home_button;
    public transport_frame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,300);
        setResizable(false);
        setTitle("Expense !!!!");

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#FC9E4F"));


        title = new JLabel("SELECT TRANSPORT TYPE");
        title.setSize(300, 30);
        title.setLocation(75, 10);
        title.setForeground(Color.decode("#093A3E")); 
        Font arialBold = new Font("Arial", Font.BOLD,19);
        title.setFont(arialBold);
        c.add(title);

        Font arialBoldfont = new Font("Roboto", Font.BOLD,14);
        bus = new JButton("Bus");
        bus.setSize(320, 25);
        bus.setLocation(40, 120);
        bus.setForeground(Color.decode("#093A3E"));
        bus.setBackground(Color.decode("#EDD382")); 
        bus.setOpaque(true);
        bus.setBorderPainted(false);
        bus.setFont(arialBoldfont);
        c.add(bus);

        subway = new JButton("Subway");
        subway.setSize(320, 25);
        subway.setLocation(40, 150);
        subway.setForeground(Color.decode("#093A3E"));
        subway.setBackground(Color.decode("#EDD382")); 
        subway.setOpaque(true);
        subway.setBorderPainted(false);
        subway.setFont(arialBoldfont);
        c.add(subway);

        taxi = new JButton("Taxi");
        taxi.setSize(320, 25);
        taxi.setLocation(40, 180);
        taxi.setForeground(Color.decode("#093A3E"));
        taxi.setBackground(Color.decode("#EDD382")); 
        taxi.setOpaque(true);
        taxi.setBorderPainted(false);
        taxi.setFont(arialBoldfont);
        c.add(taxi);
    
        car = new JButton("Car");
        car.setSize(320, 25);
        car.setLocation(40, 210);
        car.setForeground(Color.decode("#093A3E"));
        car.setBackground(Color.decode("#EDD382")); 
        car.setOpaque(true);
        car.setBorderPainted(false);
        car.setFont(arialBoldfont);
        c.add(car);

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
        bus.addActionListener(a);
        subway.addActionListener(a);
        taxi.addActionListener(a);
        car.addActionListener(a);
        home_button.addActionListener(a);
        back_Button.addActionListener(a);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public class MyActionListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Bus")) {
                dispose();
                title_bus title = new title_bus();
            }else if (e.getActionCommand().equals("Subway")) {
                dispose();
                title_subway title = new title_subway();
            }else if (e.getActionCommand().equals("Taxi")) {
                dispose();
                title_taxi title = new title_taxi();
            }else if (e.getActionCommand().equals("Car")) {
                dispose();
                title_car title = new title_car();
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
