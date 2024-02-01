package expense.self;

import java.io.Serializable;
import expense.expense;
import expense.Date;

public class Health implements Serializable{
    private Date health_date;
    private int health_money;
    private String health_des;

    public Health(Date health_date, int health_money, String health_des) {
        this.health_date = health_date;
        this.health_money = health_money;
        this.health_des = health_des;
        expense.updateTotalExpense(health_money);
    }

    public Date getHealth_date() {
        return health_date;
    }

    public void setHealth_date(Date health_date) {
        this.health_date = health_date;
    }

    public int getHealth_money() {
        return health_money;
    }

    public void setHealth_money(int health_money) {
        this.health_money = health_money;
    }

    public String getHealth_des() {
        return health_des;
    }

    public void setHealth_des(String health_des) {
        this.health_des = health_des;
    }

    @Override
    public String toString() {
        return "EXPENSE >>>  SELF  "+health_date.toString() + ", Health Money : " + health_money + " Description : " + health_des;
    }

    
}
