package expense.food;

import java.io.Serializable;

import expense.Date;
import expense.expense;

public class breakfast implements Serializable {
    private Date breakfast_date;
    private int breakfast_money;
    private String breakfast_des;

    public breakfast(Date breakfast_date, int breakfast_money, String breakfast_des) {
        this.breakfast_date = breakfast_date;
        this.breakfast_money = breakfast_money;
        this.breakfast_des = breakfast_des;
        expense.updateTotalExpense(breakfast_money);

    }

    public Date getBreakfast_date() {
        return breakfast_date;
    }

    public void setBreakfast_date(Date breakfast_date) {
        this.breakfast_date = breakfast_date;
    }

    public int getBreakfast_money() {
        return breakfast_money;
    }

    public void setBreakfast_money(int breakfast_money) {
        this.breakfast_money = breakfast_money;
    }

    public String getBreakfast_des() {
        return breakfast_des;
    }

    public void setBreakfast_des(String breakfast_des) {
        this.breakfast_des = breakfast_des;
    }

    public String toString() {
        return "EXPENSE >>>  FOOD "+breakfast_date.toString() + " Breakfast Money : " + breakfast_money + " Description : " + breakfast_des;
    }
}
