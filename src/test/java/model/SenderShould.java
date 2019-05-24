package model;

import org.junit.Assert;
import org.junit.Test;

public class SenderShould {

    @Test
    public void had_message_containing_command_validation_for_the_customer(){
        Command command = new Command(DrinkType.Coffee, 1);
        Sender sender = new Sender(command);
        String message = sender.printCommandValidation(command);
        Assert.assertTrue(message.length() > 0);
    }
}
