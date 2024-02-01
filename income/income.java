package income;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import expense.MyObjectOutputStream;

import expense.expense;


public class income implements Serializable {
    private ArrayList<salary> salaryList;
    private ArrayList<allowance> allowanceList;
    private ArrayList<bonus> bonusList;
    private ArrayList<others> othersList;
    public static int income_money;
    public static int total_money;
    
    public income() {
        salaryList = new ArrayList<>();
        allowanceList = new ArrayList<>();
        bonusList = new ArrayList<>();
        othersList = new ArrayList<>();
    }

    public void addSalary(salary s) {
        salaryList.add(s);
    }

    public void addAllowance(allowance a) {
        allowanceList.add(a);
    }

    public void addBonus(bonus b) {
        bonusList.add(b);
    }

    public void addOthers(others o) {
        othersList.add(o);
    }

    public ArrayList<salary> getSalaryList() {
        return salaryList;
    }

    public void setSalaryList(ArrayList<salary> salaryList) {
        this.salaryList = salaryList;
    }

    public ArrayList<allowance> getAllowanceList() {
        return allowanceList;
    }

    public void setAllowanceList(ArrayList<allowance> allowanceList) {
        this.allowanceList = allowanceList;
    }

    public ArrayList<bonus> getBonusList() {
        return bonusList;
    }

    public void setBonusList(ArrayList<bonus> bonusList) {
        this.bonusList = bonusList;
    }

    public ArrayList<others> getOthersList() {
        return othersList;
    }

    public void setOthersList(ArrayList<others> othersList) {
        this.othersList = othersList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Salary:\n");
        for (salary s : salaryList) {
            sb.append(s).append("\n");
        }

        sb.append("Allowance:\n");
        for (allowance a : allowanceList) {
            sb.append(a).append("\n");
        }

        sb.append("Bonus:\n");
        for (bonus b : bonusList) {
            sb.append(b).append("\n");
        }

        sb.append("Bonus:\n");
        for (others o : othersList) {
            sb.append(o).append("\n");
        }

        return sb.toString();
    }

    public static void writeToFile(income i) {
        try {
            File f = new File("income.ser");
            ObjectOutputStream oos;
            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(i);
            oos.close();
        } catch (IOException exception) {
            System.out.println("Error in File writing. ");
        }
    }

    public static ArrayList<income> readFromFile() {
        ArrayList<income> incomeList = new ArrayList<>();
        try (FileInputStream fin = new FileInputStream("income.ser");
                ObjectInputStream ois = new ObjectInputStream(fin)) {

            while (true) {
                income i = (income) ois.readObject();
                incomeList.add(i);
            }
        } catch (EOFException e) {
            // End of file reached, do nothing
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
        }
        return incomeList;
    }

    public static void updateTotalExpense(int amount) {
        income_money += amount;
        updateTotalMoney();
    }

    public static void updateTotalMoney() {
        total_money = income_money - expense.expense_money;
    }



    public static void update_Exp_money_from_file() {
        ArrayList<income> incomeList = income.readFromFile();

    for (income i : incomeList) {
           
        for (salary s : i.getSalaryList()) {
            income_money += s.getSalary_money();
        }
    }

    for (income i : incomeList) {
       
        for (allowance a : i.getAllowanceList()) {
            income_money += a.getAllowance_money();
        }
    }

    for (income i : incomeList) {
       
        for (bonus b : i.getBonusList()) {
            income_money += b.getBonus_money();
        }
    }

    for (income i : incomeList) {
       
        for (others o : i.getOthersList()) {
            income_money += o.getOthers_money();
        }
    }

    }



    public static boolean deleteFromFile(int deletion_Day,int deletion_month,int deletion_year, String deletion_Money, String deletion_Dec) {
        ArrayList<income> incomeList = readFromFile();
        boolean deleted = false;
        
        for (income f : incomeList) {
            
            for (int i = 0; i < f.getAllowanceList().size(); i++) {
                allowance a = f.getAllowanceList().get(i);
                if (a.getAllowance_date().getDay() == deletion_Day &&
                    a.getAllowance_date().getMonth() == deletion_month &&
                    a.getAllowance_date().getYear() == deletion_year &&
                    Integer.toString(a.getAllowance_money()).equals(deletion_Money) &&
                    a.getAllowance_des().equals(deletion_Dec)) {
                    f.getAllowanceList().remove(i);
                    deleted = true;
                    break; 
                }
            }
    
            for (int i = 0; i < f.getBonusList().size(); i++) {
                bonus d = f.getBonusList().get(i);
                if (d.getBonus_date().getDay() == deletion_Day &&
                    d.getBonus_date().getMonth() == deletion_month &&
                    d.getBonus_date().getYear() == deletion_year &&
                    Integer.toString(d.getBonus_money()).equals(deletion_Money) &&
                    d.getBonus_des().equals(deletion_Dec)) {
                    f.getBonusList().remove(i);
                    deleted = true;
                    break;
                }
            }
    
            
            for (int i = 0; i < f.getOthersList().size(); i++) {
                others fe = f.getOthersList().get(i);
                if (fe.getOthers_date().getDay() == deletion_Day &&
                    fe.getOthers_date().getMonth() == deletion_month &&
                    fe.getOthers_date().getYear() == deletion_year && 
                    Integer.toString(fe.getOthers_money()).equals(deletion_Money) &&
                    fe.getOthers_des().equals(deletion_Dec)) {
                    f.getOthersList().remove(i);
                    deleted = true;
                    break;
                }
            }

             for (int i = 0; i < f.getSalaryList().size(); i++) {
                salary fr = f.getSalaryList().get(i);
                if (fr.getSalary_date().getDay() == deletion_Day &&
                    fr.getSalary_date().getMonth() == deletion_month &&
                    fr.getSalary_date().getYear() == deletion_year &&
                    Integer.toString(fr.getSalary_money()).equals(deletion_Money) &&
                    fr.getSalary_des().equals(deletion_Dec)) {
                    f.getSalaryList().remove(i);
                    deleted = true;
                    break;
                }
            }
        }
    
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("income.ser"))) {
            for (income f : incomeList) {
                oos.writeObject(f);
            }
        } catch (IOException e) {
            System.out.println("Error in File writing.");
        }
        return deleted;
    }
}
