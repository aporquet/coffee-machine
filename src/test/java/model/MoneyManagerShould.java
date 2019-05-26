package model;

import common.DrinkType;
import common.NotEnoughtMoneyException;
import org.junit.Assert;
import org.junit.Test;

public class MoneyManagerShould {

    @Test
    public void receive_money_from_customer(){
        MoneyManager moneyManager = new MoneyManager(0.3);
        double moneyCustomer = moneyManager.getCustomerMoney();
        Assert.assertTrue(moneyCustomer > 0);
    }

    @Test
    public void valid_command_if_customer_money_is_greater_than_his_drink_command_price(){
        MoneyManager moneyManager = new MoneyManager(1);
        Command command = new Command(DrinkType.Coffee, 0);
        boolean validator = moneyManager.checkCommand(command);
        Assert.assertTrue(validator == true);
    }

    @Test
            (expected = NotEnoughtMoneyException.class)
    public void valid_command_if_customer_money_is_poor_than_his_drink_command_price(){
        MoneyManager moneyManager = new MoneyManager(0.3);
        Command command = new Command(DrinkType.Coffee, 0);
        boolean validator = moneyManager.checkCommand(command);
    }
}
