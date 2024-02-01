package expense.transport;

import java.io.Serializable;
import expense.expense;
import expense.Date;

public class Car implements Serializable {
    private Date car_date;
    private int car_money;
    private String car_des;

    public Car(Date car_date, int car_money, String car_des) {
        this.car_date = car_date;
        this.car_money = car_money;
        this.car_des = car_des;
        expense.updateTotalExpense(car_money);
    }

    public Date getCar_date() {
        return car_date;
    }

    public void setCar_date(Date car_date) {
        this.car_date = car_date;
    }

    public int getCar_money() {
        return car_money;
    }

    public void setCar_money(int car_money) {
        this.car_money = car_money;
    }

    public String getCar_des() {
        return car_des;
    }

    public void setCar_des(String car_des) {
        this.car_des = car_des;
    }

    @Override
    public String toString() {
        return "EXPENSE >>>  TRANSPORT  "+car_date.toString() + "  Car Money : " + car_money + "  Description : " + car_des;
    }
}