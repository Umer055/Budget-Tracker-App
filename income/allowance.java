package income;

import java.io.Serializable;

import expense.Date;

public class allowance implements Serializable {
    private Date allowance_date;
    private int allowance_money;
    private String allowance_des;

    public allowance(Date allowance_date, int allowance_money, String allowance_des) {
        this.allowance_date = allowance_date;
        this.allowance_money = allowance_money;
        this.allowance_des = allowance_des;
        income.updateTotalExpense(allowance_money);
    }

    public Date getAllowance_date() {
        return allowance_date;
    }

    public void setAllowance_date(Date allowance_date) {
        this.allowance_date = allowance_date;
    }

    public int getAllowance_money() {
        return allowance_money;
    }

    public void setAllowance_money(int allowance_money) {
        this.allowance_money = allowance_money;
    }

    public String getAllowance_des() {
        return allowance_des;
    }

    public void setAllowance_des(String allowance_des) {
        this.allowance_des = allowance_des;
    }

    public String toString() {
        return "INCOME >>>  ALLOWANCE "+allowance_date.toString() + " Allowance Money : " + allowance_money + " Description : " + allowance_des;
    }
}
