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
        try {
            moneyManager.checkCommand(command);
        }
        catch (NotEnoughtMoneyException e){
            double differencePrice = command.getDrinkType().getDrinkPrice() - moneyManager.getCustomerMoney();
            return "You need to add "+differencePrice+" to buy this drink";
        }
        return " "+command.getDrinkType()+" "+command.getNumberOfSugar()+" "+command.hasStick();
    }
}
