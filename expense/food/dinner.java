package expense.food;

import java.io.Serializable;

import expense.Date;
import expense.expense;

public class dinner implements Serializable {
    private Date dinner_date;
    private int dinner_money;
    private String dinner_des;

    public dinner(Date dinner_date, int dinner_money, String dinner_des) {
        this.dinner_date = dinner_date;
        this.dinner_money = dinner_money;
        this.dinner_des = dinner_des;
        expense.updateTotalExpense(dinner_money);

    }

    public Date getDinner_date() {
        return dinner_date;
    }

    public void setDinner_date(Date dinner_date) {
        this.dinner_date = dinner_date;
    }

    public int getDinner_money() {
        return dinner_money;
    }

    public void setDinner_money(int dinner_money) {
        this.dinner_money = dinner_money;
    }

    public String getDinner_des() {
        return dinner_des;
    }

    public void setDinner_des(String dinner_des) {
        this.dinner_des = dinner_des;
    }

    public String toString() {
        return "EXPENSE >>>  FOOD "+dinner_date.toString() + " Dinner Money : " + dinner_money + " Descrption : " + dinner_des;
    }
}
