package expense.transport;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


import expense.MyObjectOutputStream;
import expense.social.Alumini;
import expense.social.Dues;
import expense.social.Fellowship;
import expense.social.Friendship;
import expense.social.sociallife;


public class transport implements Serializable {
    private ArrayList<Car> carList;
    private ArrayList<Bus> busList;
    private ArrayList<Subway> subwayList;
    private ArrayList<Taxi> taxiList;

    public transport() {
        carList = new ArrayList<>();
        busList = new ArrayList<>();
        subwayList = new ArrayList<>();
        taxiList = new ArrayList<>();
    }

    public void addBus(Bus b) {
        busList.add(b);
    }

    public void addCar(Car c) {
        carList.add(c);
    }

    public void addSubway(Subway s) {
        subwayList.add(s);
    }

    public void addTaxi(Taxi t) {
        taxiList.add(t);
    }

    public ArrayList<Car> getCarList() {
        return carList;
    }

    public void setCarList(ArrayList<Car> carList) {
        this.carList = carList;
    }

    public ArrayList<Bus> getBusList() {
        return busList;
    }

    public void setBusList(ArrayList<Bus> busList) {
        this.busList = busList;
    }

    public ArrayList<Subway> getSubwayList() {
        return subwayList;
    }

    public void setSubwayList(ArrayList<Subway> subwayList) {
        this.subwayList = subwayList;
    }

    public ArrayList<Taxi> getTaxiList() {
        return taxiList;
    }

    public void setTaxiList(ArrayList<Taxi> taxiList) {
        this.taxiList = taxiList;
    }

    public static void writeToFile(transport t){
        try{
            File f = new File("transport.ser");
            ObjectOutputStream oos;
            if(f.exists()){
                oos = new MyObjectOutputStream(new FileOutputStream(f,true));
            }
            else{
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(t);
            oos.close();
        }
        catch(IOException exception){
            System.out.println("Error in File writing. ");
        }
    }

    
    public static ArrayList<transport> readFromFile() {
        ArrayList<transport> transportList = new ArrayList<>();
        try (FileInputStream fin = new FileInputStream("transport.ser");
             ObjectInputStream ois = new ObjectInputStream(fin)) {

            while (true) {
                transport t = (transport) ois.readObject();
                System.out.println(t.toString());
                transportList.add(t);
            }
        } catch (EOFException e) {
            // End of file reached, do nothing
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
        }
        return transportList;
    }


    
    public static boolean deleteFromFile(int deletion_Day,int deletion_month,int deletion_year, String deletion_Money, String deletion_Dec) {
        ArrayList<transport> transportList = readFromFile();
        boolean deleted = false;
        
        for (transport f : transportList) {
            
            for (int i = 0; i < f.getBusList().size(); i++) {
                Bus b = f.getBusList().get(i);
                if (b.getBus_date().getDay() == deletion_Day &&
                    b.getBus_date().getMonth() == deletion_month &&
                    b.getBus_date().getYear() == deletion_year &&
                    Integer.toString(b.getBus_money()).equals(deletion_Money) &&
                    b.getBus_des().equals(deletion_Dec)) {
                    f.getBusList().remove(i);
                    deleted = true;
                    break; 
                }
            }
    
            for (int i = 0; i < f.getCarList().size(); i++) {
                Car d = f.getCarList().get(i);
                if (d.getCar_date().getDay() == deletion_Day &&
                    d.getCar_date().getMonth() == deletion_month &&
                    d.getCar_date().getYear() == deletion_year &&
                    Integer.toString(d.getCar_money()).equals(deletion_Money) &&
                    d.getCar_des().equals(deletion_Dec)) {
                    f.getCarList().remove(i);
                    deleted = true;
                    break;
                }
            }
    
            
            for (int i = 0; i < f.getSubwayList().size(); i++) {
                Subway fe = f.getSubwayList().get(i);
                if (fe.getSubway_date().getDay() == deletion_Day &&
                    fe.getSubway_date().getMonth() == deletion_month &&
                    fe.getSubway_date().getYear() == deletion_year && 
                    Integer.toString(fe.getSubway_money()).equals(deletion_Money) &&
                    fe.getSubway_des().equals(deletion_Dec)) {
                    f.getSubwayList().remove(i);
                    deleted = true;
                    break;
                }
            }

             for (int i = 0; i < f.getTaxiList().size(); i++) {
                Taxi fr = f.getTaxiList().get(i);
                if (fr.getTaxi_date().getDay() == deletion_Day &&
                    fr.getTaxi_date().getMonth() == deletion_month &&
                    fr.getTaxi_date().getYear() == deletion_year &&
                    Integer.toString(fr.getTaxi_money()).equals(deletion_Money) &&
                    fr.getTaxi_des().equals(deletion_Dec)) {
                    f.getTaxiList().remove(i);
                    deleted = true;
                    break;
                }
            }
        }
    
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("transport.ser"))) {
            for (transport f : transportList) {
                oos.writeObject(f);
            }
        } catch (IOException e) {
            System.out.println("Error in File writing.");
        }
        return deleted;
    }

}
