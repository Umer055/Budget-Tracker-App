package income;

import java.io.Serializable;

import expense.Date;

public class bonus implements Serializable {
    private Date bonus_date;
    private int bonus_money;
    private String bonus_des;

    public bonus(Date bonus_date, int bouns_money, String bonus_des) {
        this.bonus_date = bonus_date;
        this.bonus_money = bouns_money;
        this.bonus_des = bonus_des;
        income.updateTotalExpense(bouns_money);

    }

    public Date getBonus_date() {
        return bonus_date;
    }

    public void setBonus_date(Date bonus_date) {
        this.bonus_date = bonus_date;
    }

    public int getBonus_money() {
        return bonus_money;
    }

    public void setSalary_money(int bonus_money) {
        this.bonus_money = bonus_money;
    }

    public String getBonus_des() {
        return bonus_des;
    }

    public void setBonus_des(String bonus_des) {
        this.bonus_des = bonus_des;
    }

    public String toString() {
        return "INCOME >>>  BONUS "+bonus_date.toString() + " Bonus Money : " + bonus_money + " Description : " + bonus_des;
    }
}


    