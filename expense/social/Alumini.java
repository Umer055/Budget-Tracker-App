package expense.social;

import java.io.Serializable;
import expense.expense;
import expense.Date;

public class Alumini implements Serializable{
    private Date alumini_date;
    private int alumini_money;
    private String alumini_des;

    public Alumini(Date alumini_date, int alumini_money, String alumini_des) {
        this.alumini_date = alumini_date;
        this.alumini_money = alumini_money;
        this.alumini_des = alumini_des;
        expense.updateTotalExpense(alumini_money);
    }

    public Date getAlumini_date() {
        return alumini_date;
    }

    public void setAlumini_date(Date alumini_date) {
        this.alumini_date = alumini_date;
    }

    public int getAlumini_money() {
        return alumini_money;
    }

    public void setAlumini_money(int alumini_money) {
        this.alumini_money = alumini_money;
    }

    public String getAlumini_des() {
        return alumini_des;
    }

    public void setAlumini_des(String alumini_des) {
        this.alumini_des = alumini_des;
    }

    @Override
    public String toString() {
        return "EXPENSE >>>  SOCIAL  "+ alumini_date + "  Alumini Money : " + alumini_money + "  Description : "+ alumini_des;
    }

}
