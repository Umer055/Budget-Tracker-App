package expense.food;

import java.io.Serializable;

import expense.Date;
import expense.expense;

public class lunch implements Serializable {
    private Date lunch_date;
    private int lunch_money;
    private String lunch_des;

    public lunch(Date lunch_date, int lunch_money, String lunch_des) {
        this.lunch_date = lunch_date;
        this.lunch_money = lunch_money;
        this.lunch_des = lunch_des;
        expense.updateTotalExpense(lunch_money);

    }

    public Date getLunch_date() {
        return lunch_date;
    }

    public void setLunch_date(Date lunch_date) {
        this.lunch_date = lunch_date;
    }

    public int getLunch_money() {
        return lunch_money;
    }

    public void setLunch_money(int lunch_money) {
        this.lunch_money = lunch_money;
    }

    public String getLunch_des() {
        return lunch_des;
    }

    public void setLunch_des(String lunch_des) {
        this.lunch_des = lunch_des;
    }

    public String toString() {
        return "EXPENSE >>>  FOOD "+lunch_date.toString() + " Lunch  Money : " + lunch_money + " Description : " + lunch_des;
    }
}
