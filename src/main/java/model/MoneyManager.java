package model;

import common.NotEnoughtMoneyException;

class MoneyManager {

    private double customerMoney;
    private boolean validCommand;

    public MoneyManager(double customerMoney) {
        this.customerMoney = customerMoney;
    }

    public double getCustomerMoney() {
        return customerMoney;
    }

    public boolean checkCommand(Command command) {
        if (command.getDrinkType().getDrinkPrice() > customerMoney){
            throw new NotEnoughtMoneyException();
        }
        return validCommand = true;
    }

    public boolean isValidCommand() {
        return validCommand;
    }

    public void setValidCommand(boolean validCommand) {
        this.validCommand = validCommand;
    }
}
