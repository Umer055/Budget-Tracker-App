package expense.self;

import java.io.Serializable;
import expense.expense;
import expense.Date;

public class Household implements Serializable{
    private Date household_date;
    private int household_money;
    private String household_des;

    public Household(Date household_date, int household_money, String household_des) {
        this.household_date = household_date;
        this.household_money = household_money;
        this.household_des = household_des;
        expense.updateTotalExpense(household_money);
    }

    public Date getHousehold_date() {
        return household_date;
    }

    public void setHousehold_date(Date household_date) {
        this.household_date = household_date;
    }

    public int getHousehold_money() {
        return household_money;
    }

    public void setHousehold_money(int household_money) {
        this.household_money = household_money;
    }

    public String getHousehold_des() {
        return household_des;
    }

    public void setHousehold_des(String household_des) {
        this.household_des = household_des;
    }

    @Override
    public String toString() {
        return "EXPENSE >>>  SELF  "+ household_date + "  Household Money : " + household_money
                + "  Description : " + household_des;
    }

}
