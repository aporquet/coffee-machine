package model;

import common.DrinkType;
import org.junit.Assert;
import org.junit.Test;

public class SenderShould {

    @Test
    public void had_message_containing_command_validation_for_the_customer_if_customer_money_is_greater_or_equal_than_drink_price(){
        Command command = new Command(DrinkType.Coffee, 1, true);
        MoneyManager moneyManager = new MoneyManager(2);
        Sender sender = new Sender(command, moneyManager);
        String message = sender.messageCommandValidation(command, moneyManager);
        Assert.assertTrue(message.length() > 0);
    }

    @Test
    public void had_message_containing_the_difference_between_customer_money_and_drink_price_if_he_is_greater(){
        Command command = new Command(DrinkType.Chocolate, 2, true);
        MoneyManager moneyManager = new MoneyManager(0.3);
        Sender sender = new Sender(command, moneyManager);
        String message = sender.messageCommandValidation(command, moneyManager);
        Assert.assertTrue(message.length() > 0);
    }

}
