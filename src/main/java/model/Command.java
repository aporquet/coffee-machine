package model;

import common.DrinkType;
import common.IncorrectNumberOfSugarException;

class Command {

    private DrinkType drinkType;
    private int numberOfSugar;
    private boolean hasStick;

    public Command(DrinkType drinkType, int numberOfSugar) {
        if (numberOfSugar < 0 || numberOfSugar > 2){
            throw new IncorrectNumberOfSugarException();
        }
        this.drinkType = drinkType;
        this.numberOfSugar = numberOfSugar;
        if (numberOfSugar != 0){
            hasStick = true;
        } else {
            hasStick = false;
        }
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public int getNumberOfSugar() {
        return numberOfSugar;
    }

    String mapperDrinkType(DrinkType drinkType){
        if (drinkType == DrinkType.Tea){
            return "T";
        }
        if (drinkType == DrinkType.Chocolate){
            return "H";
        }
        return "C";
    }

    public boolean hasStick() {
        return hasStick;
    }
}
