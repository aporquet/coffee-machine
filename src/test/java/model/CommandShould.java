package model;

import common.DrinkType;
import common.IncorrectNumberOfSugarException;
import org.junit.Assert;
import org.junit.Test;

public class CommandShould {

    @Test
    public void be_had_a_type_of_drink_coffee_tea_or_chocolate(){
        Command command = new Command(DrinkType.Tea, 2, true);
        String drinkType = command.getDrinkType().getDrinkName();
        Assert.assertTrue(drinkType == "Tea");
    }

    @Test
    public void also_had_an_orange_juice_drink_type(){
        Command command = new Command(DrinkType.OrangeJuice, 0, false);
        String drinkType = command.getDrinkType().getDrinkName();
        Assert.assertTrue(drinkType == "Orange juice");
    }

    @Test
    public void be_had_0_or_1_or_2_sugar(){
        Command firstCommand = new Command(DrinkType.Coffee, 1, false);
        Assert.assertTrue(firstCommand.getNumberOfSugar() == 1);
        Command secondCommand = new Command(DrinkType.Coffee, 0, true);
        Assert.assertTrue(secondCommand.getNumberOfSugar() == 0);
        Command thirdCommand = new Command(DrinkType.Coffee, 2, false);
        Assert.assertTrue(thirdCommand.getNumberOfSugar() == 2);
    }

    @Test
            (expected = IncorrectNumberOfSugarException.class)
    public void not_had_3_sugars(){
        Command command = new Command(DrinkType.Chocolate, 3, true);
    }

    @Test
    public void had_stick_if_this_command_contains_a_sugar(){
        Command command = new Command(DrinkType.Coffee, 1, false);
        Assert.assertTrue(command.hasStick() == true);
    }

    @Test
    public void not_had_stick_if_this_command_contains_0_sugar(){
        Command command = new Command(DrinkType.Coffee, 0, false);
        Assert.assertTrue(command.hasStick() == false);
    }

    @Test
    public void had_a_drink_type_very_hot(){
        Command command = new Command(DrinkType.Coffee, 1, true);
        Assert.assertTrue(command.isHot() == true);
    }

    @Test
    public void not_had_hot_drink_if_customer_dont_want_that(){
        Command command = new Command(DrinkType.Coffee, 1, false);
        Assert.assertTrue(command.isHot() == false);
    }

    @Test
    public void not_had_hot_drink_this_type_of_drink_cannot_be_hot(){
        Command command = new Command(DrinkType.OrangeJuice, 1, true);
        Assert.assertTrue(command.isHot() == false);
    }


}
