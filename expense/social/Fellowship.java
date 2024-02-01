package expense.social;

import java.io.Serializable;
import expense.expense;
import expense.Date;

public class Fellowship implements Serializable{
    private Date fellowship_date;
    private int fellowship_money;
    private String fellowship_des;

    public Fellowship(Date fellowship_date, int fellowship_money, String fellowship_des) {
        this.fellowship_date = fellowship_date;
        this.fellowship_money = fellowship_money;
        this.fellowship_des = fellowship_des;
        expense.updateTotalExpense(fellowship_money);
    }

    public Date getFellowship_date() {
        return fellowship_date;
    }

    public void setFellowship_date(Date fellowship_date) {
        this.fellowship_date = fellowship_date;
    }

    public int getFellowship_money() {
        return fellowship_money;
    }

    public void setFellowship_money(int fellowship_money) {
        this.fellowship_money = fellowship_money;
    }

    public String getFellowship_des() {
        return fellowship_des;
    }

    public void setFellowship_des(String fellowship_des) {
        this.fellowship_des = fellowship_des;
    }

    @Override
    public String toString() {
        return "EXPENSE >>>  SOCIAL  "+fellowship_date + "  Fellowship Money : " + fellowship_money
                + "  Description : " + fellowship_des;
    }
    
}
