package gui.income_gui;

import javax.swing.*;

import expense.Date;
import income.allowance;
import income.income;
import gui.Main_frame;
import gui.income_gui.income_frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class title_allowance extends JFrame {
    private Container c;
    private JLabel title, date_label, money_Label, description_Label;
    private JTextField money;
    private JTextArea description;
    private JButton submit, cancel;
    private JComboBox<Integer> dayComboBox, monthComboBox, yearComboBox;

    public title_allowance() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setResizable(false);
        setTitle("Income !!!!");

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#FC9E4F"));


        title = new JLabel("<<<  Enter the details >>>");
        title.setSize(300, 30);
        title.setLocation(116, 10);
        Font arialBold = new Font("Arial", Font.BOLD,14);
        title.setFont(arialBold);
        c.add(title);
        
        Font arialBoldfont = new Font("Roboto", Font.BOLD,13);
        date_label = new JLabel("Select Date : ");
        date_label.setSize(300, 30);
        date_label.setLocation(30, 40);
        c.add(date_label);

        Integer[] days = new Integer[31];
        for (int i = 1; i <= 31; i++) {
            days[i - 1] = i;
        }
        dayComboBox = new JComboBox<>(days);
        dayComboBox.setBounds(135, 40, 70, 30);
        dayComboBox.setBackground(Color.decode("#EDD382")); 
        dayComboBox.setFont(arialBoldfont);
        c.add(dayComboBox);

        Integer[] months = new Integer[12];
        for (int i = 1; i <= 12; i++) {
            months[i - 1] = i;
        }
        monthComboBox = new JComboBox<>(months);
        monthComboBox.setBounds(205, 40, 70, 30);
        monthComboBox.setBackground(Color.decode("#EDD382")); 
        monthComboBox.setFont(arialBoldfont);
        c.add(monthComboBox);

        Integer[] years = new Integer[30];
        for (int i = 2022; i <= 2051; i++) {
            years[i - 2022] = i;
        }
        yearComboBox = new JComboBox<>(years);
        yearComboBox.setBounds(275, 40, 100, 30);
        yearComboBox.setBackground(Color.decode("#EDD382")); 
        yearComboBox.setFont(arialBoldfont);
        c.add(yearComboBox);

        money_Label = new JLabel("Enter Amount : ");
        money_Label.setSize(300, 30);
        money_Label.setLocation(30, 86);
        c.add(money_Label);

        money = new JTextField();
        money.setSize(238, 30);
        money.setLocation(135, 86);
        money.setBackground(Color.decode("#EDD382")); 
        money.setFont(arialBoldfont);
        c.add(money);

        description_Label = new JLabel("Enter Description : ");
        description_Label.setSize(300, 30);
        description_Label.setLocation(30, 130);
        c.add(description_Label);

        description = new JTextArea();
        description.setSize(218, 90);
        description.setLocation(150, 130);
        description.setLineWrap(true);
        description.setBackground(Color.decode("#EDD382")); 
        description.setFont(arialBoldfont);
        c.add(description);

        submit = new JButton("Submit");
        submit.setSize(160, 32);
        submit.setLocation(30, 240);
        submit.setForeground(Color.decode("#093A3E"));
        submit.setBackground(Color.decode("#EDD382")); 
        submit.setOpaque(true);
        submit.setBorderPainted(false);
        submit.setFont(arialBoldfont);
        c.add(submit);

        cancel = new JButton("Cancel");
        cancel.setSize(160, 32);
        cancel.setLocation(200, 240);
        cancel.setForeground(Color.decode("#093A3E"));
        cancel.setBackground(Color.decode("#EDD382")); 
        cancel.setOpaque(true);
        cancel.setBorderPainted(false);
        cancel.setFont(arialBoldfont);
        c.add(cancel);

        MyActionListener a = new MyActionListener();
        submit.addActionListener(a);
        cancel.addActionListener(a);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public class MyActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Submit")) {
                int selected_day = Integer.parseInt(dayComboBox.getSelectedItem().toString());
                int selected_month = Integer.parseInt(monthComboBox.getSelectedItem().toString());
                int selected_year = Integer.parseInt(yearComboBox.getSelectedItem().toString());

                allowance a1 = new allowance(new Date(selected_day, selected_month, selected_year),
                        Integer.parseInt(money.getText()), description.getText());
                income i = new income();
                i.addAllowance(a1);

                income.writeToFile(i);

                JOptionPane.showMessageDialog(new JFrame(), "Submitted");
                dispose();

                income_frame fr = new income_frame();
                fr.setVisible(true);

            } else if (e.getActionCommand().equals("Cancel")) {
                dispose();
                income_frame fr = new income_frame();
                
            }
        }
    }

}
