package expense.transport;

import java.io.Serializable;
import expense.expense;
import expense.Date;

public class Taxi implements Serializable {
    private Date taxi_date;
    private int taxi_money;
    private String taxi_des;

    public Taxi(Date taxi_date, int taxi_money, String taxi_des) {
        this.taxi_date = taxi_date;
        this.taxi_money = taxi_money;
        this.taxi_des = taxi_des;
        expense.updateTotalExpense(taxi_money);
    }

    public Date getTaxi_date() {
        return taxi_date;
    }

    public void setTaxi_date(Date taxi_date) {
        this.taxi_date = taxi_date;
    }

    public int getTaxi_money() {
        return taxi_money;
    }

    public void setTaxi_money(int taxi_money) {
        this.taxi_money = taxi_money;
    }

    public String getTaxi_des() {
        return taxi_des;
    }

    public void setTaxi_des(String taxi_des) {
        this.taxi_des = taxi_des;
    }

    @Override
    public String toString() {
        return "EXPENSE >>>  TRANSPORT  "+taxi_date.toString() + "  Taxi Money : " + taxi_money + "  Description : " + taxi_des;
    }

}
