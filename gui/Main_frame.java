package gui;

import javax.swing.*;

import expense.expense;
import gui.delete_gui.delete_title_frame;
import gui.expense_gui.expense_frame;
import gui.income_gui.income_frame;
import income.income;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main_frame extends JFrame {
    private Container c;
    private JLabel title, incomeLabel,expenseLabel,total, income_money,expense_money,total_money;
    private JButton income_Button, expense_Button,display_Button,exit_Button,delete_Button;
    private static boolean flag = false;
    public Main_frame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,450);
        setResizable(false);
        setTitle("Budget Manager App !!!");


        if (!flag) {
            expense.update_Exp_money_from_file();
            income.update_Exp_money_from_file();
            income.total_money = income.income_money - expense.expense_money;
            flag = true;
        }
       
        

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#FC9E4F"));


        title = new JLabel("EXPENSE TRACKER");
        title.setSize(300, 30);
        title.setLocation(108, 10);
        title.setForeground(Color.decode("#093A3E")); 
        Font arialBold = new Font("Arial", Font.BOLD,19);
        title.setFont(arialBold);
        c.add(title);


        incomeLabel = new JLabel("Income");
        incomeLabel.setSize(60, 20);
        incomeLabel.setLocation(46, 70);
        incomeLabel.setForeground(Color.decode("#093A3E")); 
        Font arialBoldfont = new Font("Roboto", Font.BOLD,14);
        incomeLabel.setFont(arialBoldfont);
        c.add(incomeLabel);
        

        expenseLabel = new JLabel("Expense");
        expenseLabel.setSize(60, 20);
        expenseLabel.setLocation(180, 70);
        expenseLabel.setForeground(Color.decode("#093A3E")); 
        expenseLabel.setFont(arialBoldfont);
        c.add(expenseLabel);

        total = new JLabel("Total");
        total.setSize(50, 20);
        total.setLocation(320, 70);
        total.setForeground(Color.decode("#093A3E")); 
        total.setFont(arialBoldfont);
        c.add(total);

        String income_money_data = Integer.toString(income.income_money);
        income_money = new JLabel(income_money_data);
        income_money.setSize(50, 20);
        income_money.setLocation(49, 100);
        income_money.setForeground(Color.decode("#093A3E")); 
        income_money.setFont(arialBoldfont);
        c.add(income_money);

        String expense_money_data = Integer.toString(expense.expense_money);
        expense_money = new JLabel(expense_money_data);
        expense_money.setSize(50, 20);
        expense_money.setLocation(186, 100);
        expense_money.setForeground(Color.decode("#093A3E")); 
        expense_money.setFont(arialBoldfont);
        c.add(expense_money);
        
        String total_money_data = Integer.toString(income.total_money);
        total_money = new JLabel(total_money_data);
        total_money.setSize(50, 20);
        total_money.setLocation(319, 100);
        total_money.setForeground(Color.decode("#093A3E")); 
        total_money.setFont(arialBoldfont);
        c.add(total_money);

        
        income_Button = new JButton("Add Income");
        income_Button.setSize(320, 32);
        income_Button.setLocation(40,205);
        income_Button.setForeground(Color.decode("#093A3E"));
        income_Button.setBackground(Color.decode("#EDD382")); 
        income_Button.setOpaque(true);
        income_Button.setBorderPainted(false);
        income_Button.setFont(arialBoldfont);

        c.add(income_Button);

        expense_Button = new JButton("Add Expense");
        expense_Button.setSize(320, 32);
        expense_Button.setLocation(40,250);
        expense_Button.setForeground(Color.decode("#093A3E"));
        expense_Button.setBackground(Color.decode("#EDD382")); 
        expense_Button.setOpaque(true);
        expense_Button.setBorderPainted(false);
        expense_Button.setFont(arialBoldfont);

        c.add(expense_Button);

        delete_Button = new JButton("Delete Income/Expense");
        delete_Button.setSize(320, 32);
        delete_Button.setLocation(40,295);
        delete_Button.setForeground(Color.decode("#093A3E"));
        delete_Button.setBackground(Color.decode("#EDD382")); 
        delete_Button.setOpaque(true);
        delete_Button.setBorderPainted(false);
        delete_Button.setFont(arialBoldfont);

        c.add(delete_Button);
        
        display_Button = new JButton("Display");
        display_Button.setSize(150, 32);
        display_Button.setLocation(40,340);
        display_Button.setForeground(Color.decode("#093A3E"));
        display_Button.setBackground(Color.decode("#EDD382")); 
        display_Button.setOpaque(true);
        display_Button.setBorderPainted(false);
        display_Button.setFont(arialBoldfont);

        c.add(display_Button);

        exit_Button = new JButton("Exit");
        exit_Button.setSize(150, 32);
        exit_Button.setLocation(210,340);
        exit_Button.setForeground(Color.decode("#093A3E"));
        exit_Button.setBackground(Color.decode("#EDD382")); 
        exit_Button.setOpaque(true);
        exit_Button.setBorderPainted(false);
        exit_Button.setFont(arialBoldfont);

        c.add(exit_Button);


        MyActionListener a = new MyActionListener();
        income_Button.addActionListener(a);
        expense_Button.addActionListener(a);
        delete_Button.addActionListener(a);
        exit_Button.addActionListener(a);
        display_Button.addActionListener(a);

        setLocationRelativeTo(null);
        setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Add Income")) {
                dispose();
                income_frame income = new income_frame();
            }else if (e.getActionCommand().equals("Add Expense")) {
                dispose();
                expense_frame expense = new expense_frame();
                
            }else if (e.getActionCommand().equals("Display")) {
                dispose();
                display d1 = new display();
                
            }else if (e.getActionCommand().equals("Delete Income/Expense")){
                dispose();
                delete_title_frame d = new delete_title_frame();
            }else if (e.getActionCommand().equals("Exit")) {
                System.exit(0);
            }
        }
    }
}
