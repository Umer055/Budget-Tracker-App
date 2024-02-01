package expense.self;

import java.io.Serializable;
import expense.expense;
import expense.Date;

public class Apperal implements Serializable{
    private Date apperal_date;
    private int apperal_money;
    private String apperal_des;

    public Apperal(Date apperal_date, int apperal_money, String apperal_des) {
        this.apperal_date = apperal_date;
        this.apperal_money = apperal_money;
        this.apperal_des = apperal_des;
        expense.updateTotalExpense(apperal_money);
    }

    public Date getApperal_date() {
        return apperal_date;
    }

    public void setApperal_date(Date apperal_date) {
        this.apperal_date = apperal_date;
    }

    public int getApperal_money() {
        return apperal_money;
    }

    public void setApperal_money(int apperal_money) {
        this.apperal_money = apperal_money;
    }

    public String getApperal_des() {
        return apperal_des;
    }

    public void setApperal_des(String apperal_des) {
        this.apperal_des = apperal_des;
    }

    public String toString() {
        return "EXPENSE >>>  SELF  "+apperal_date.toString() + " Apperal Money : " + apperal_money + " Description : "+ apperal_des;
    }

}
