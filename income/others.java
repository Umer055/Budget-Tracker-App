package income;

import java.io.Serializable;

import expense.Date;

public class others implements Serializable {
    private Date others_date;
    private int others_money;
    private String others_des;

    public others(Date others_date, int others_money, String others_des) {
        this.others_date = others_date;
        this.others_money = others_money;
        this.others_des = others_des;
        income.updateTotalExpense(others_money);
    }

    public Date getOthers_date() {
        return others_date;
    }

    public void setOthers_date(Date others_date) {
        this.others_date = others_date;
    }

    public int getOthers_money() {
        return others_money;
    }

    public void setOthers_money(int others_money) {
        this.others_money = others_money;
    }

    public String getOthers_des() {
        return others_des;
    }

    public void setOthers_des(String others_des) {
        this.others_des = others_des;
    }

    public String toString() {
        return "INCOME >>>  OTHER "+others_date.toString() + " Others Money : " + others_money + " Description : " + others_des;
    }

}