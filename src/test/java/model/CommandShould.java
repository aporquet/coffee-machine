package model;

import org.junit.Assert;
import org.junit.Test;

public class CommandShould {

    @Test
    public void be_had_a_type_of_drink_coffee_tea_or_chocolate(){
        Command command = new Command(DrinkType.Tea, 2);
        String drinkType = command.mapperDrinkType(command.getDrinkType());
        Assert.assertTrue(drinkType == "T");
    }

    @Test
    public void be_had_0_or_1_or_2_sugar(){
        Command firstCommand = new Command(DrinkType.Coffee, 1);
        Assert.assertTrue(firstCommand.getNumberOfSugar() == 1);
        Command secondCommand = new Command(DrinkType.Coffee, 0);
        Assert.assertTrue(secondCommand.getNumberOfSugar() == 0);
        Command thirdCommand = new Command(DrinkType.Coffee, 2);
        Assert.assertTrue(thirdCommand.getNumberOfSugar() == 2);
    }

    @Test
            (expected = IncorrectNumberOfSugarException.class)
    public void not_had_3_sugars(){
        Command command = new Command(DrinkType.Chocolate, 3);
    }

    @Test
    public void had_stick_if_this_command_contains_a_sugar(){
        Command command = new Command(DrinkType.Coffee, 1);
        Assert.assertTrue(command.hasStick() == true);
    }

    @Test
    public void not_had_stick_if_this_command_contains_0_sugar(){
        Command command = new Command(DrinkType.Coffee, 0);
        Assert.assertTrue(command.hasStick() == false);
    }

}
