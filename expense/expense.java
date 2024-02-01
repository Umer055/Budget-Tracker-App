package expense;
import java.util.ArrayList;

import expense.food.food;
import expense.food.breakfast;
import expense.food.lunch;
import expense.food.dinner;
import expense.food.beverages;

import expense.self.Apperal;
import expense.self.Beauty;
import expense.self.Health;
import expense.self.Household;
import expense.self.self;
import expense.social.Alumini;
import expense.social.Dues;
import expense.social.Fellowship;
import expense.social.Friendship;
import expense.social.sociallife;
import expense.transport.*;
import income.income;


public class expense {
    private food food_exp;
    private transport transport_exp;
    private sociallife social;
    private self self_exp;
    private Date date;
    public static int expense_money;
    public static int total_money;
   
    
    public food getFood() {
        return food_exp;
    }
    public void setFood(food food) {
        this.food_exp = food;
    }
    public transport getTransport() {
        return transport_exp;
    }
    public void setTransport(transport transport) {
        this.transport_exp = transport;
    }
    public sociallife getSocial() {
        return social;
    }
    public void setSocial(sociallife social) {
        this.social = social;
    }
    public self getSelf() {
        return self_exp;
    }
    public void setSelf(self self) {
        this.self_exp = self;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public static void updateTotalExpense(int amount) {
        expense_money += amount;
        income.updateTotalMoney();
    }

    public static void updateTotalMoney() {
        total_money = income.income_money - expense_money;
    }

    public static void update_Exp_money_from_file() {
        ArrayList<food> foodList = food.readFromFile();
        ArrayList<self> self_devList = self.readFromFile();
        ArrayList<sociallife> social_lifeList = sociallife.readFromFile();
        ArrayList<transport> transportList = transport.readFromFile();
        
        for (food f : foodList) {
            for (breakfast b : f.getBreakfastList()) {
                expense_money += b.getBreakfast_money();
            }
        }

        for (food f : foodList) {
            for (lunch b : f.getLunchList()) {
                expense_money += b.getLunch_money();
            }
        }

        for (food f : foodList) {
            for (dinner d : f.getDinnerList()) {
                expense_money += d.getDinner_money();
            }
        }

        for (food f : foodList) {
            for (beverages b : f.getBeveragesList()) {
                expense_money += b.getBeverages_money();
            }
        }

        for (self s : self_devList) {
            
            for (Health h : s.getHealthList()) {
                expense_money += h.getHealth_money();
            }
        }

        for (self s : self_devList) {
            
            for (Apperal a : s.getApperalList()) {
                expense_money += a.getApperal_money();
            }
        }

        for (self s : self_devList) {
            
            for (Household h : s.getHouseholdList()) {
                expense_money += h.getHousehold_money();
            }
        }

        for (self s : self_devList) {
            
            for (Beauty b : s.getBeautyList()) {
                expense_money += b.getBeauty_money();
            }
        }

        for (sociallife s : social_lifeList) {
            
            for (Friendship f : s.getFriendshipList()) {
                expense_money += f.getFriendship_money();
            }
        }

        for (sociallife s : social_lifeList) {
            
            for (Fellowship f : s.getFellowshipList()) {
                expense_money += f.getFellowship_money();
            }
        }

        for (sociallife s : social_lifeList) {
            
            for (Alumini a : s.getAluminiList()) {
                expense_money += a.getAlumini_money();
            }
        }

        for (sociallife s : social_lifeList) {
            
            for (Dues d : s.getDuesList()) {
                expense_money += d.getDues_money();
            }
        }

        for (transport t : transportList) {
            
            for (Car c : t.getCarList()) {
                expense_money += c.getCar_money();
            }
        }

        for (transport t : transportList) {
            
            for (Bus b : t.getBusList()) {
                expense_money += b.getBus_money();
            }
        }

        for (transport t : transportList) {
            
            for (Subway s : t.getSubwayList()) {
                expense_money += s.getSubway_money();
            }
        }

        for (transport t : transportList) {
            
            for (Taxi tx : t.getTaxiList()) {
                expense_money += tx.getTaxi_money();
            }
        }

       
    }
}



