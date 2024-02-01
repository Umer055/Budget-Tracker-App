package expense.social;

import java.io.Serializable;
import expense.expense;
import expense.Date;

public class Dues implements Serializable{
    private Date dues_date;
    private int dues_money;
    private String dues_des;

    public Dues(Date dues_date, int dues_money, String dues_des) {
        this.dues_date = dues_date;
        this.dues_money = dues_money;
        this.dues_des = dues_des;
        expense.updateTotalExpense(dues_money);
    }

    public Date getDues_date() {
        return dues_date;
    }

    public void setDues_date(Date dues_date) {
        this.dues_date = dues_date;
    }

    public int getDues_money() {
        return dues_money;
    }

    public void setDues_money(int dues_money) {
        this.dues_money = dues_money;
    }

    public String getDues_des() {
        return dues_des;
    }

    public void setDues_des(String dues_des) {
        this.dues_des = dues_des;
    }

    @Override
    public String toString() {
        return "EXPENSE >>>  SOCIAL  "+ dues_date + "  Dues Money : " + dues_money + "  Description : " + dues_des;
    }

}
