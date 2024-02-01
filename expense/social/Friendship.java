package expense.social;

import java.io.Serializable;
import expense.expense;
import expense.Date;

public class Friendship implements Serializable{
    private Date friendship_date;
    private int friendship_money;
    private String friendship_des;

    public Friendship(Date friendship_date, int friendship_money, String friendship_des) {
        this.friendship_date = friendship_date;
        this.friendship_money = friendship_money;
        this.friendship_des = friendship_des;
        expense.updateTotalExpense(friendship_money);
    }

    public Date getFriendship_date() {
        return friendship_date;
    }

    public void setFriendship_date(Date friendship_date) {
        this.friendship_date = friendship_date;
    }

    public int getFriendship_money() {
        return friendship_money;
    }

    public void setFriendship_money(int friendship_money) {
        this.friendship_money = friendship_money;
    }

    public String getFriendship_des() {
        return friendship_des;
    }

    public void setFriendship_des(String friendship_des) {
        this.friendship_des = friendship_des;
    }

    @Override
    public String toString() {
        return "EXPENSE >>>  SOCIAL  "+ friendship_date + "  Friendship Money : " + friendship_money
                + "  Description : " + friendship_des;
    }

}
