package gui.delete_gui;


import javax.swing.*;

import expense.Date;
import expense.expense;
import expense.food.breakfast;
import expense.food.food;
import expense.self.self;
import expense.social.sociallife;
import expense.transport.transport;
import income.allowance;
import income.income;
import gui.Main_frame;
import gui.expense_gui.food_gui.food_frame;
import gui.income_gui.income_frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class delete_title_frame extends JFrame {
    private Container c;
    private JLabel title,select_category_label, date_label, money_Label, description_Label;
    private JTextField money;
    private JTextArea description;
    private JButton submit, cancel;
    private JComboBox<Integer> dayComboBox, monthComboBox, yearComboBox;
    private JComboBox<String>  select_category;

    public delete_title_frame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 350);
        setResizable(false);
        setTitle("Delete !!!!");

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
        select_category_label = new JLabel("Select category : ");
        select_category_label.setSize(300, 30);
        select_category_label.setLocation(30, 40);
        c.add(select_category_label);

        select_category = new JComboBox<String>(new String[]{"Income", "Food", "Social-life", "Self", "Transport"});
        select_category.setBounds(135, 40, 240, 30);
        select_category.setBackground(Color.decode("#EDD382")); 
        select_category.setFont(arialBoldfont);
        c.add(select_category);


        date_label = new JLabel("Select Date : ");
        date_label.setSize(300, 30);
        date_label.setLocation(30, 86);
        c.add(date_label);

        Integer[] days = new Integer[31];
        for (int i = 1; i <= 31; i++) {
            days[i - 1] = i;
        }
        dayComboBox = new JComboBox<>(days);
        dayComboBox.setBounds(135, 86, 70, 30);
        dayComboBox.setBackground(Color.decode("#EDD382")); 
        dayComboBox.setFont(arialBoldfont);
        c.add(dayComboBox);

        Integer[] months = new Integer[12];
        for (int i = 1; i <= 12; i++) {
            months[i - 1] = i;
        }
        monthComboBox = new JComboBox<>(months);
        monthComboBox.setBounds(205, 86, 70, 30);
        monthComboBox.setBackground(Color.decode("#EDD382")); 
        monthComboBox.setFont(arialBoldfont);
        c.add(monthComboBox);

        Integer[] years = new Integer[30];
        for (int i = 2022; i <= 2051; i++) {
            years[i - 2022] = i;
        }
        yearComboBox = new JComboBox<>(years);
        yearComboBox.setBounds(275, 86, 100, 30);
        yearComboBox.setBackground(Color.decode("#EDD382")); 
        yearComboBox.setFont(arialBoldfont);
        c.add(yearComboBox);

        money_Label = new JLabel("Enter Amount : ");
        money_Label.setSize(300, 30);
        money_Label.setLocation(30, 130);
        c.add(money_Label);

        money = new JTextField();
        money.setSize(238, 30);
        money.setLocation(135, 130);
        money.setBackground(Color.decode("#EDD382")); 
        money.setFont(arialBoldfont);
        c.add(money);

        description_Label = new JLabel("Enter Description : ");
        description_Label.setSize(300, 30);
        description_Label.setLocation(30, 177);
        c.add(description_Label);

        description = new JTextArea();
        description.setSize(218, 90);
        description.setLocation(150, 177);
        description.setLineWrap(true);
        description.setBackground(Color.decode("#EDD382")); 
        description.setFont(arialBoldfont);
        c.add(description);

        submit = new JButton("Submit");
        submit.setSize(160, 32);
        submit.setLocation(30, 275);
        submit.setForeground(Color.decode("#093A3E"));
        submit.setBackground(Color.decode("#EDD382")); 
        submit.setOpaque(true);
        submit.setBorderPainted(false);
        submit.setFont(arialBoldfont);
        c.add(submit);

        cancel = new JButton("Cancel");
        cancel.setSize(160, 32);
        cancel.setLocation(200, 275);
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

                
                

                String selectedCategory = (String) select_category.getSelectedItem();
                if (selectedCategory.equals("Food")) {
                    if (food.deleteFromFile(selected_day, selected_month, selected_year, money.getText(), description.getText())) {
                        expense.expense_money -= Integer.parseInt(money.getText());
                        income.total_money +=  Integer.parseInt(money.getText());
                        JOptionPane.showMessageDialog(new JFrame(), "Sucessfully Deleted");
                        dispose();

                        Main_frame fr = new Main_frame();
                        fr.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(new JFrame(), "Wrong Input");
                    }
                    
                } else if (selectedCategory.equals("Income")) {
                    if (income.deleteFromFile(selected_day, selected_month, selected_year, money.getText(), description.getText())) {
                        income.income_money -= Integer.parseInt(money.getText());
                        income.total_money -=  Integer.parseInt(money.getText());
                        JOptionPane.showMessageDialog(new JFrame(), "Sucessfully Deleted");
                        dispose();

                        Main_frame fr = new Main_frame();
                        fr.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(new JFrame(), "Wrong Input");
                    }
                    

                }else if (selectedCategory.equals("Social-life")) {
                    if (sociallife.deleteFromFile(selected_day, selected_month, selected_year, money.getText(), description.getText())) {
                        expense.expense_money -= Integer.parseInt(money.getText());
                        income.total_money +=  Integer.parseInt(money.getText());
                        JOptionPane.showMessageDialog(new JFrame(), "Sucessfully Deleted");
                        dispose();

                        Main_frame fr = new Main_frame();
                        fr.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(new JFrame(), "Wrong Input");
                    }
                    

                }else if (selectedCategory.equals("Self")) {
                    if (self.deleteFromFile(selected_day, selected_month, selected_year, money.getText(), description.getText())) {
                        expense.expense_money -= Integer.parseInt(money.getText());
                        income.total_money +=  Integer.parseInt(money.getText());
                        JOptionPane.showMessageDialog(new JFrame(), "Sucessfully Deleted");
                        dispose();

                        Main_frame fr = new Main_frame();
                        fr.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(new JFrame(), "Wrong Input");
                    }
                    

                }else if (selectedCategory.equals("Transport")) {
                    if (transport.deleteFromFile(selected_day, selected_month, selected_year, money.getText(), description.getText())) {
                        expense.expense_money -= Integer.parseInt(money.getText());
                        income.total_money +=  Integer.parseInt(money.getText());
                        JOptionPane.showMessageDialog(new JFrame(), "Sucessfully Deleted");
                        dispose();

                        Main_frame fr = new Main_frame();
                        fr.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(new JFrame(), "Wrong Input");
                    }
                    

                }               
               
            } else if (e.getActionCommand().equals("Cancel")) {
                dispose();
                Main_frame fr = new Main_frame();
                
            }
        }
    }

}
