package expense.food;

import java.io.Serializable;

import expense.Date;
import expense.expense;

public class beverages implements Serializable {
    private Date beverages_date;
    private int beverages_money;
    private String beverages_des;

    public beverages(Date beverages_date, int beverages_money, String beverages_des) {
        this.beverages_date = beverages_date;
        this.beverages_money = beverages_money;
        this.beverages_des = beverages_des;
        expense.updateTotalExpense(beverages_money);
    }

    public Date getBeverages_date() {
        return beverages_date;
    }

    public void setBeverages_date(Date beverages_date) {
        this.beverages_date = beverages_date;
    }

    public int getBeverages_money() {
        return beverages_money;
    }

    public void setBeverages_money(int beverages_money) {
        this.beverages_money = beverages_money;
    }

    public String getBeverages_des() {
        return beverages_des;
    }

    public void setBeverages_des(String beverages_des) {
        this.beverages_des = beverages_des;
    }

    public String toString() {
        return "EXPENSE >>>  FOOD "+beverages_date.toString() + " Beverages Money : " + beverages_money + " Description : " + beverages_des;
    }
   
}
