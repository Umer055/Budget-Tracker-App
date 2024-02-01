package expense.transport;

import java.io.Serializable;
import expense.expense;
import expense.Date;

public class Subway implements Serializable {
    private Date subway_date;
    private int subway_money;
    private String subway_des;

    public Subway(Date subway_date, int subway_money, String subway_des) {
        this.subway_date = subway_date;
        this.subway_money = subway_money;
        this.subway_des = subway_des;
        expense.updateTotalExpense(subway_money);
    }

    public Date getSubway_date() {
        return subway_date;
    }

    public void setSubway_date(Date subway_date) {
        this.subway_date = subway_date;
    }

    public int getSubway_money() {
        return subway_money;
    }

    public void setSubway_money(int subway_money) {
        this.subway_money = subway_money;
    }

    public String getSubway_des() {
        return subway_des;
    }

    public void setSubway_des(String subway_des) {
        this.subway_des = subway_des;
    }

    @Override
    public String toString() {
        return "EXPENSE >>>  TRANSPORT  "+subway_date.toString() + "  Subway Money : " + subway_money + "   Description : " + subway_des;
    }

}
