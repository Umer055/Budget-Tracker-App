package expense.self;

import java.io.Serializable;
import expense.expense;
import expense.Date;

public class Beauty implements Serializable{
    private Date beauty_date;
    private int beauty_money;
    private String beauty_des;

    public Beauty(Date beauty_date, int beauty_money, String beauty_des) {
        this.beauty_date = beauty_date;
        this.beauty_money = beauty_money;
        this.beauty_des = beauty_des;
        expense.updateTotalExpense(beauty_money);
    }

    public Date getBeauty_date() {
        return beauty_date;
    }

    public void setBeauty_date(Date beauty_date) {
        this.beauty_date = beauty_date;
    }

    public int getBeauty_money() {
        return beauty_money;
    }

    public void setBeauty_money(int beauty_money) {
        this.beauty_money = beauty_money;
    }

    public String getBeauty_des() {
        return beauty_des;
    }

    public void setBeauty_des(String beauty_des) {
        this.beauty_des = beauty_des;
    }

    public String toString() {
        return "EXPENSE >>>  SELF  "+beauty_date.toString() + " Beauty Money : " + beauty_money + " Description : "
                + beauty_des;
    }
}
