package expense.transport;

import java.io.Serializable;
import expense.expense;
import expense.Date;

public class Bus implements Serializable{
    private Date bus_date;
    private int bus_money;
    private String bus_des;

    public Bus(Date bus_date, int bus_money, String bus_des) {
        this.bus_date = bus_date;
        this.bus_money = bus_money;
        this.bus_des = bus_des;
        expense.updateTotalExpense(bus_money);
    }

    public Date getBus_date() {
        return bus_date;
    }

    public void setBus_date(Date bus_date) {
        this.bus_date = bus_date;
    }

    public int getBus_money() {
        return bus_money;
    }

    public void setBus_money(int bus_money) {
        this.bus_money = bus_money;
    }

    public String getBus_des() {
        return bus_des;
    }

    public void setBus_des(String bus_des) {
        this.bus_des = bus_des;
    }

    @Override
    public String toString() {
        return "EXPENSE >>>  TRANSPORT  "+bus_date.toString() + "  Bus Money : " + bus_money + "  Description : " + bus_des;
    }

}
