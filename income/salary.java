package income;

import java.io.Serializable;

import expense.Date;

public class salary implements Serializable {
    private Date salary_date;
    private int salary_money;
    private String salary_des;

    public salary(Date salary_date, int salary_money, String salary_des) {
        this.salary_date = salary_date;
        this.salary_money = salary_money;
        this.salary_des = salary_des;
        income.updateTotalExpense(salary_money);
    }

    public Date getSalary_date() {
        return salary_date;
    }

    public void setSalary_date(Date salary_date) {
        this.salary_date = salary_date;
    }

    public int getSalary_money() {
        return salary_money;
    }

    public void setSalary_money(int salary_money) {
        this.salary_money = salary_money;
    }

    public String getSalary_des() {
        return salary_des;
    }

    public void setSalary_des(String salary_des) {
        this.salary_des = salary_des;
    }

    public String toString() {
        return "INCOME >>>  SALARY "+salary_date.toString() + " Salary Money : " + salary_money + " Description : " + salary_des;
    }
}
