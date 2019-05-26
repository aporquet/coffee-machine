package model;

import common.NotEnoughtMoneyException;

public class Sender {

    private Command command;
    private MoneyManager moneyManager;

    public Sender(Command command, MoneyManager moneyManager){
        this.command = command;
        this.moneyManager = moneyManager;
    }

    public String messageCommandValidation(Command command, MoneyManager moneyManager){
        /*TODO: Change boolean to map a message to boolean values*/
        try {
            moneyManager.checkCommand(command);
        }
        catch (NotEnoughtMoneyException e){
            double differencePrice = command.getDrinkType().getDrinkPrice() - moneyManager.getCustomerMoney();
            return "You need to add "+differencePrice+" to buy this drink";
        }
        return "drink maker do a "+command.getDrinkType().getDrinkName()+" very "+command.isHot()+" with "+command.getNumberOfSugar()+" and a "+command.hasStick();
    }
}
