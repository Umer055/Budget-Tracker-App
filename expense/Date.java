package expense;

import java.io.Serializable;

public class Date implements Serializable{
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public boolean equals(Date d){
        if(this.day==d.day && this.month==d.month && this.year==d.year){
            return true;
        }
        else return false;
    }

    public String dayString(){
        return Integer.toString(this.day);
    }

     public String monthString(){
        return Integer.toString(this.month);
    }

     public String yearString(){
        return Integer.toString(this.year);
    }
    
    public String toString(){
        return "Date : "+this.day + "/" + this.month + "/" + this.year;
    }
}
