package expense.self;

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
import expense.food.beverages;
import expense.food.breakfast;
import expense.food.dinner;
import expense.food.food;
import expense.food.lunch;


public class self implements Serializable {
    private ArrayList<Apperal> apperalList;
    private ArrayList<Household> householdList;
    private ArrayList<Beauty> beautyList;
    private ArrayList<Health> healthList;

    public self() {
        apperalList = new ArrayList<>();
        householdList = new ArrayList<>();
        beautyList = new ArrayList<>();
        healthList = new ArrayList<>();
    }

    public void addApperal(Apperal a) {
        apperalList.add(a);
    }

    public void addHousehold(Household h) {
        householdList.add(h);
    }

    public void addBeauty(Beauty b) {
        beautyList.add(b);
    }

    public void addHealth(Health h1) {
        healthList.add(h1);
    }

    public ArrayList<Apperal> getApperalList() {
        return apperalList;
    }

    public void setApperalList(ArrayList<Apperal> apperalList) {
        this.apperalList = apperalList;
    }

    public ArrayList<Household> getHouseholdList() {
        return householdList;
    }

    public void setHouseholdList(ArrayList<Household> householdList) {
        this.householdList = householdList;
    }

    public ArrayList<Beauty> getBeautyList() {
        return beautyList;
    }

    public void setBeautyList(ArrayList<Beauty> beautyList) {
        this.beautyList = beautyList;
    }

    public ArrayList<Health> getHealthList() {
        return healthList;
    }

    public void setHealthList(ArrayList<Health> healthList) {
        this.healthList = healthList;
    }

    public static void writeToFile(self s) {
        try {
            File f = new File("self.ser");
            ObjectOutputStream oos;
            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(s);
            oos.close();
        } catch (IOException exception) {
            System.out.println("Error in File writing. ");
        }
    }

    public static ArrayList<self> readFromFile() {
        ArrayList<self> self_devList = new ArrayList<>();
        try (FileInputStream fin = new FileInputStream("self.ser");
                ObjectInputStream ois = new ObjectInputStream(fin)) {

            while (true) {
                self s = (self) ois.readObject();
                System.out.println(s.toString());
                self_devList.add(s);
            }
        } catch (EOFException e) {
            
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace(); 
        }
        return self_devList;
    }


    public static boolean deleteFromFile(int deletion_Day,int deletion_month,int deletion_year, String deletion_Money, String deletion_Dec) {
        ArrayList<self> selfList = readFromFile();
        boolean deleted = false;
        
        for (self f : selfList) {
            
            for (int i = 0; i < f.getApperalList().size(); i++) {
                Apperal a = f.getApperalList().get(i);
                if (a.getApperal_date().getDay() == deletion_Day &&
                    a.getApperal_date().getMonth() == deletion_month &&
                    a.getApperal_date().getYear() == deletion_year &&
                    Integer.toString(a.getApperal_money()).equals(deletion_Money) &&
                    a.getApperal_des().equals(deletion_Dec)) {
                    f.getApperalList().remove(i);
                    deleted = true;
                    break; 
                }
            }
    
            for (int i = 0; i < f.getBeautyList().size(); i++) {
                Beauty b = f.getBeautyList().get(i);
                if (b.getBeauty_date().getDay() == deletion_Day &&
                    b.getBeauty_date().getMonth() == deletion_month &&
                    b.getBeauty_date().getYear() == deletion_year &&
                    Integer.toString(b.getBeauty_money()).equals(deletion_Money) &&
                    b.getBeauty_des().equals(deletion_Dec)) {
                    f.getBeautyList().remove(i);
                    deleted = true;
                    break;
                }
            }
    
            
            for (int i = 0; i < f.getHealthList().size(); i++) {
                Health h = f.getHealthList().get(i);
                if (h.getHealth_date().getDay() == deletion_Day &&
                    h.getHealth_date().getMonth() == deletion_month &&
                    h.getHealth_date().getYear() == deletion_year && 
                    Integer.toString(h.getHealth_money()).equals(deletion_Money) &&
                    h.getHealth_des().equals(deletion_Dec)) {
                    f.getHealthList().remove(i);
                    deleted = true;
                    break;
                }
            }

             for (int i = 0; i < f.getHouseholdList().size(); i++) {
                Household h = f.getHouseholdList().get(i);
                if (h.getHousehold_date().getDay() == deletion_Day &&
                    h.getHousehold_date().getMonth() == deletion_month &&
                    h.getHousehold_date().getYear() == deletion_year &&
                    Integer.toString(h.getHousehold_money()).equals(deletion_Money) &&
                    h.getHousehold_des().equals(deletion_Dec)) {
                    f.getHouseholdList().remove(i);
                    deleted = true;
                    break;
                }
            }
        }
    
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("self.ser"))) {
            for (self f : selfList) {
                oos.writeObject(f);
            }
        } catch (IOException e) {
            System.out.println("Error in File writing.");
        }
        return deleted;
    }

}
