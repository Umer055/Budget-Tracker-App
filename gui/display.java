package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import expense.food.food;
import expense.food.breakfast;
import expense.food.lunch;
import expense.food.dinner;
import expense.food.beverages;

import expense.self.self;
import expense.self.Apperal;
import expense.self.Beauty;
import expense.self.Health;
import expense.self.Household;

import expense.social.sociallife;
import expense.social.Friendship;
import expense.social.Fellowship;
import expense.social.Alumini;
import expense.social.Dues;

import expense.transport.transport;
import expense.transport.Car;
import expense.transport.Bus;
import expense.transport.Subway;
import expense.transport.Taxi;

import income.income;
import income.salary;
import income.allowance;
import income.bonus;
import income.others;


public class display extends JFrame {
    private JTextArea displayArea;
    private JScrollPane scrollPane;
    JButton backButton;

    public display() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 400);
        setTitle("Display Data");

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.setBackground(Color.decode("#FC9E4F"));

        Font arialBoldfont = new Font("Roboto", Font.BOLD,14);
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        scrollPane = new JScrollPane(displayArea);
        displayArea.setBackground(Color.decode("#FC9E4F"));
        displayArea.setForeground(Color.decode("#093A3E"));
        displayArea.setFont(arialBoldfont);
        c.add(scrollPane, BorderLayout.CENTER);

        // Add a back button
        backButton = new JButton("Back");
        backButton.setForeground(Color.decode("#093A3E"));
        backButton.setBackground(Color.decode("#EDD382")); 
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
        // backButton.setFont(arialBoldfont);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle back action, for example, by closing the current frame
                dispose(); // Close the current frame
                Main_frame s = new Main_frame();
            }
        });
        c.add(backButton, BorderLayout.SOUTH); // Add the back button to the bottom of the frame

        displayData();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void displayData() {
        ArrayList<food> foodList = food.readFromFile();
        ArrayList<self> self_devList = self.readFromFile();
        ArrayList<sociallife> social_lifeList = sociallife.readFromFile();
        ArrayList<transport> transportList = transport.readFromFile();
        ArrayList<income> incomeList = income.readFromFile();
        displayArea.setText(""); // Clear previous text
        for (food f : foodList) {
            for (breakfast b : f.getBreakfastList()) {
                displayArea.append(b.toString() + "\n");
            }
        }

        for (food f : foodList) {
            for (lunch b : f.getLunchList()) {
                displayArea.append(b.toString() + "\n");
            }
        }

        for (food f : foodList) {
            for (dinner d : f.getDinnerList()) {
                displayArea.append(d.toString() + "\n");
            }
        }

        for (food f : foodList) {
            for (beverages b : f.getBeveragesList()) {
                displayArea.append(b.toString() + "\n");
            }
        }

        for (self s : self_devList) {
            
            for (Health h : s.getHealthList()) {
                displayArea.append(h.toString() + "\n");
            }
        }

        for (self s : self_devList) {
            
            for (Apperal a : s.getApperalList()) {
                displayArea.append(a.toString() + "\n");
            }
        }

        for (self s : self_devList) {
            
            for (Household h : s.getHouseholdList()) {
                displayArea.append(h.toString() + "\n");
            }
        }

        for (self s : self_devList) {
            
            for (Beauty b : s.getBeautyList()) {
                displayArea.append(b.toString() + "\n");
            }
        }

        for (sociallife s : social_lifeList) {
            
            for (Friendship f : s.getFriendshipList()) {
                displayArea.append(f.toString() + "\n");
            }
        }

        for (sociallife s : social_lifeList) {
            
            for (Fellowship f : s.getFellowshipList()) {
                displayArea.append(f.toString() + "\n");
            }
        }

        for (sociallife s : social_lifeList) {
            
            for (Alumini a : s.getAluminiList()) {
                displayArea.append(a.toString() + "\n");
            }
        }

        for (sociallife s : social_lifeList) {
            
            for (Dues d : s.getDuesList()) {
                displayArea.append(d.toString() + "\n");
            }
        }

        for (transport t : transportList) {
            
            for (Car c : t.getCarList()) {
                displayArea.append(c.toString() + "\n");
            }
        }

        for (transport t : transportList) {
            
            for (Bus b : t.getBusList()) {
                displayArea.append(b.toString() + "\n");
            }
        }

        for (transport t : transportList) {
            
            for (Subway s : t.getSubwayList()) {
                displayArea.append(s.toString() + "\n");
            }
        }

        for (transport t : transportList) {
            
            for (Taxi tx : t.getTaxiList()) {
                displayArea.append(tx.toString() + "\n");
            }
        }

        for (income i : incomeList) {
           
            for (salary s : i.getSalaryList()) {
                displayArea.append(s.toString() + "\n");
            }
        }

        for (income i : incomeList) {
           
            for (allowance a : i.getAllowanceList()) {
                displayArea.append(a.toString() + "\n");
            }
        }

        for (income i : incomeList) {
           
            for (bonus b : i.getBonusList()) {
                displayArea.append(b.toString() + "\n");
            }
        }

        for (income i : incomeList) {
           
            for (others o : i.getOthersList()) {
                displayArea.append(o.toString() + "\n");
            }
        }
    }
}
