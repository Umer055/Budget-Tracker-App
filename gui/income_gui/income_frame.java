package gui.income_gui;

import javax.swing.*;

import gui.Main_frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class income_frame extends JFrame {
    private Container c;
    private JLabel title;
    private JButton Bonus, Salary, allowance, other, back_Button;

    public income_frame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setResizable(false);
        setTitle("Income !!!!");

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#FC9E4F"));


        title = new JLabel("SELECT INCOME TYPE");
        title.setSize(300, 30);
        title.setLocation(96, 10);
        title.setForeground(Color.decode("#093A3E")); 
        Font arialBold = new Font("Arial", Font.BOLD,19);
        title.setFont(arialBold);
        c.add(title);

        Font arialBoldfont = new Font("Roboto", Font.BOLD,14);
        Salary = new JButton("Salary");
        Salary.setSize(320, 25);
        Salary.setLocation(40, 120);
        Salary.setForeground(Color.decode("#093A3E"));
        Salary.setBackground(Color.decode("#EDD382")); 
        Salary.setOpaque(true);
        Salary.setBorderPainted(false);
        Salary.setFont(arialBoldfont);
        c.add(Salary);

        allowance = new JButton("Allownace");
        allowance.setSize(320, 25);
        allowance.setLocation(40, 150);
        allowance.setFont(arialBoldfont);
        allowance.setForeground(Color.decode("#093A3E"));
        allowance.setBackground(Color.decode("#EDD382")); 
        allowance.setOpaque(true);
        allowance.setBorderPainted(false);
        c.add(allowance);

        Bonus = new JButton("Bonus");
        Bonus.setSize(320, 25);
        Bonus.setLocation(40, 180);
        Bonus.setFont(arialBoldfont);
        Bonus.setForeground(Color.decode("#093A3E"));
        Bonus.setBackground(Color.decode("#EDD382")); 
        Bonus.setOpaque(true);
        Bonus.setBorderPainted(false);
        c.add(Bonus);

        other = new JButton("Other");
        other.setSize(320, 25);
        other.setLocation(40, 210);
        other.setFont(arialBoldfont);
        other.setForeground(Color.decode("#093A3E"));
        other.setBackground(Color.decode("#EDD382")); 
        other.setOpaque(true);
        other.setBorderPainted(false);
        c.add(other);

        back_Button = new JButton("Back");
        back_Button.setSize(160, 32);
        back_Button.setLocation(200, 240);
        back_Button.setFont(arialBoldfont);
        back_Button.setForeground(Color.decode("#093A3E"));
        back_Button.setBackground(Color.decode("#EDD382")); 
        back_Button.setOpaque(true);
        back_Button.setBorderPainted(false);
        c.add(back_Button);

        MyActionListener a = new MyActionListener();
        Salary.addActionListener(a);
        allowance.addActionListener(a);
        Bonus.addActionListener(a);
        other.addActionListener(a);
        back_Button.addActionListener(a);

        setLocationRelativeTo(null);
        setVisible(true);

    }

    public class MyActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Salary")) {
                dispose();
                title_salary title = new title_salary();
            } else if (e.getActionCommand().equals("Allownace")) {
                dispose();
                title_allowance title = new title_allowance();
            } else if (e.getActionCommand().equals("Bonus")) {
                dispose();
                title_bonus title = new title_bonus();
            } else if (e.getActionCommand().equals("Other")) {
                dispose();
                title_others title = new title_others();
            } else if (e.getActionCommand().equals("Back")) {
                dispose();
                Main_frame main = new Main_frame();
            }
        }
    }
}
