package expense.social;

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
import expense.self.Apperal;
import expense.self.Beauty;
import expense.self.Health;
import expense.self.Household;
import expense.self.self;

public class sociallife implements Serializable {
    private ArrayList<Friendship> friendshipList;
    private ArrayList<Fellowship> fellowshipList;
    private ArrayList<Alumini> aluminiList;
    private ArrayList<Dues> duesList;

    public sociallife() {
        friendshipList = new ArrayList<>();
        fellowshipList = new ArrayList<>();
        aluminiList = new ArrayList<>();
        duesList = new ArrayList<>();
    }

    public void addFriendship(Friendship f) {
        friendshipList.add(f);
    }

    public void addFellowship(Fellowship fs) {
        fellowshipList.add(fs);
    }

    public void addAlumini(Alumini a) {
        aluminiList.add(a);
    }

    public void addDues(Dues d) {
        duesList.add(d);
    }

    public ArrayList<Friendship> getFriendshipList() {
        return friendshipList;
    }

    public void setFriendshipList(ArrayList<Friendship> friendshipList) {
        this.friendshipList = friendshipList;
    }

    public ArrayList<Fellowship> getFellowshipList() {
        return fellowshipList;
    }

    public void setFellowshipList(ArrayList<Fellowship> fellowshipList) {
        this.fellowshipList = fellowshipList;
    }

    public ArrayList<Alumini> getAluminiList() {
        return aluminiList;
    }

    public void setAluminiList(ArrayList<Alumini> aluminiList) {
        this.aluminiList = aluminiList;
    }

    public ArrayList<Dues> getDuesList() {
        return duesList;
    }

    public void setDuesList(ArrayList<Dues> duesList) {
        this.duesList = duesList;
    }

    public static void writeToFile(sociallife s){
        try{
            File f = new File("social_life.ser");
            ObjectOutputStream oos;
            if(f.exists()){
                oos = new MyObjectOutputStream(new FileOutputStream(f,true));
            }
            else{
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(s);
            oos.close();
        }
        catch(IOException exception){
            System.out.println("Error in File writing. ");
        }
    }

    
    public static ArrayList<sociallife> readFromFile() {
        ArrayList<sociallife> sociallifeList = new ArrayList<>();
        try (FileInputStream fin = new FileInputStream("social_life.ser");
             ObjectInputStream ois = new ObjectInputStream(fin)) {

            while (true) {
                sociallife s = (sociallife) ois.readObject();
                System.out.println(s.toString());
                sociallifeList.add(s);
            }
        } catch (EOFException e) {
            // End of file reached, do nothing
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
        }
        return sociallifeList;
    }


    public static boolean deleteFromFile(int deletion_Day,int deletion_month,int deletion_year, String deletion_Money, String deletion_Dec) {
        ArrayList<sociallife> socialList = readFromFile();
        boolean deleted = false;
        
        for (sociallife f : socialList) {
            
            for (int i = 0; i < f.getAluminiList().size(); i++) {
                Alumini a = f.getAluminiList().get(i);
                if (a.getAlumini_date().getDay() == deletion_Day &&
                    a.getAlumini_date().getMonth() == deletion_month &&
                    a.getAlumini_date().getYear() == deletion_year &&
                    Integer.toString(a.getAlumini_money()).equals(deletion_Money) &&
                    a.getAlumini_des().equals(deletion_Dec)) {
                    f.getAluminiList().remove(i);
                    deleted = true;
                    break; 
                }
            }
    
            for (int i = 0; i < f.getDuesList().size(); i++) {
                Dues d = f.getDuesList().get(i);
                if (d.getDues_date().getDay() == deletion_Day &&
                    d.getDues_date().getMonth() == deletion_month &&
                    d.getDues_date().getYear() == deletion_year &&
                    Integer.toString(d.getDues_money()).equals(deletion_Money) &&
                    d.getDues_des().equals(deletion_Dec)) {
                    f.getDuesList().remove(i);
                    deleted = true;
                    break;
                }
            }
    
            
            for (int i = 0; i < f.getFellowshipList().size(); i++) {
                Fellowship fe = f.getFellowshipList().get(i);
                if (fe.getFellowship_date().getDay() == deletion_Day &&
                    fe.getFellowship_date().getMonth() == deletion_month &&
                    fe.getFellowship_date().getYear() == deletion_year && 
                    Integer.toString(fe.getFellowship_money()).equals(deletion_Money) &&
                    fe.getFellowship_des().equals(deletion_Dec)) {
                    f.getFellowshipList().remove(i);
                    deleted = true;
                    break;

                }
            }

             for (int i = 0; i < f.getFriendshipList().size(); i++) {
                Friendship fr = f.getFriendshipList().get(i);
                if (fr.getFriendship_date().getDay() == deletion_Day &&
                    fr.getFriendship_date().getMonth() == deletion_month &&
                    fr.getFriendship_date().getYear() == deletion_year &&
                    Integer.toString(fr.getFriendship_money()).equals(deletion_Money) &&
                    fr.getFriendship_des().equals(deletion_Dec)) {
                    f.getFriendshipList().remove(i);
                    deleted = true;
                    break;
                }
            }
        }
    
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("social_life.ser"))) {
            for (sociallife f : socialList) {
                oos.writeObject(f);
            }
        } catch (IOException e) {
            System.out.println("Error in File writing.");
        }
        return deleted;
    }
}
