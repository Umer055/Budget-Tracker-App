package expense.food;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import expense.Date;
import expense.MyObjectOutputStream;

public class food implements Serializable {
    private ArrayList<breakfast> breakfastList;
    private ArrayList<lunch> lunchList;
    private ArrayList<dinner> dinnerList;
    private ArrayList<beverages> beveragesList;



    public food() {
        breakfastList = new ArrayList<>();
        lunchList = new ArrayList<>();
        dinnerList = new ArrayList<>();
        beveragesList = new ArrayList<>();
    }

    public void addBreakfast(breakfast b) {
        breakfastList.add(b);
    }

    public void addLunch(lunch l) {
        lunchList.add(l);
    }

    public void addDinner(dinner d) {
        dinnerList.add(d);
    }

    public void addBeverages(beverages b) {
        beveragesList.add(b);
    }

    public ArrayList<breakfast> getBreakfastList() {
        return breakfastList;
    }

    public void setBreakfastList(ArrayList<breakfast> breakfastList) {
        this.breakfastList = breakfastList;
    }

    public ArrayList<lunch> getLunchList() {
        return lunchList;
    }

    public void setLunchList(ArrayList<lunch> lunchList) {
        this.lunchList = lunchList;
    }

    public ArrayList<dinner> getDinnerList() {
        return dinnerList;
    }

    public void setDinnerList(ArrayList<dinner> dinnerList) {
        this.dinnerList = dinnerList;
    }

    public ArrayList<beverages> getBeveragesList() {
        return beveragesList;
    }

    public void setBeveragesList(ArrayList<beverages> beveragesList) {
        this.beveragesList = beveragesList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Breakfasts:\n");
        for (breakfast b : breakfastList) {
            sb.append(b).append("\n");
        }

        sb.append("Lunches:\n");
        for (lunch l : lunchList) {
            sb.append(l).append("\n");
        }

        sb.append("Dinners:\n");
        for (dinner d : dinnerList) {
            sb.append(d).append("\n");
        }

        sb.append("Beverages:\n");
        for (beverages b : beveragesList) {
            sb.append(b).append("\n");
        }

        return sb.toString();
    }

    public static void writeToFile(food p) {
        try {
            File f = new File("food.ser");
            ObjectOutputStream oos;
            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(p);
            oos.close();
        } catch (IOException exception) {
            System.out.println("Error in File writing. ");
        }
    }

    public static ArrayList<food> readFromFile() {
        ArrayList<food> foodsList = new ArrayList<>();
        try (FileInputStream fin = new FileInputStream("food.ser");
                ObjectInputStream ois = new ObjectInputStream(fin)) {

            while (true) {
                food f = (food) ois.readObject();
                System.out.println(f.toString());
                foodsList.add(f);
            }
        } catch (EOFException e) {
            // End of file reached, do nothing
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
        }
        return foodsList;
    }


    public static boolean deleteFromFile(int deletion_Day,int deletion_month,int deletion_year, String deletion_Money, String deletion_Dec) {
        ArrayList<food> foodList = readFromFile();
        boolean deleted = false;
        
        for (food f : foodList) {
            
            for (int i = 0; i < f.getBreakfastList().size(); i++) {
                breakfast b = f.getBreakfastList().get(i);
                if (b.getBreakfast_date().getDay() == deletion_Day &&
                    b.getBreakfast_date().getMonth() == deletion_month &&
                    b.getBreakfast_date().getYear() == deletion_year &&
                    Integer.toString(b.getBreakfast_money()).equals(deletion_Money) &&
                    b.getBreakfast_des().equals(deletion_Dec)) {
                    f.getBreakfastList().remove(i);
                    deleted = true;
                    break; 
                }
            }
    
            for (int i = 0; i < f.getLunchList().size(); i++) {
                lunch l = f.getLunchList().get(i);
                if (l.getLunch_date().getDay() == deletion_Day &&
                    l.getLunch_date().getMonth() == deletion_month &&
                    l.getLunch_date().getYear() == deletion_year &&
                    Integer.toString(l.getLunch_money()).equals(deletion_Money) &&
                    l.getLunch_des().equals(deletion_Dec)) {
                    f.getLunchList().remove(i);
                    deleted = true;
                    break;
                }
            }
    
            
            for (int i = 0; i < f.getDinnerList().size(); i++) {
                dinner d = f.getDinnerList().get(i);
                if (d.getDinner_date().getDay() == deletion_Day &&
                    d.getDinner_date().getMonth() == deletion_month &&
                    d.getDinner_date().getYear() == deletion_year && 
                    Integer.toString(d.getDinner_money()).equals(deletion_Money) &&
                    d.getDinner_des().equals(deletion_Dec)) {
                    f.getDinnerList().remove(i);
                    deleted = true;
                    break;
                }
            }

             for (int i = 0; i < f.getBeveragesList().size(); i++) {
                beverages b = f.getBeveragesList().get(i);
                if (b.getBeverages_date().getDay() == deletion_Day &&
                    b.getBeverages_date().getMonth() == deletion_month &&
                    b.getBeverages_date().getYear() == deletion_year &&
                    Integer.toString(b.getBeverages_money()).equals(deletion_Money) &&
                    b.getBeverages_des().equals(deletion_Dec)) {
                    f.getBeveragesList().remove(i);
                    deleted = true;
                    break;
                }
            }
        }
    
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("food.ser"))) {
            for (food f : foodList) {
                oos.writeObject(f);
            }
        } catch (IOException e) {
            System.out.println("Error in File writing.");
        }
        return deleted;
    }

}
