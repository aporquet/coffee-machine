package model;

import common.DrinkType;
import common.IncorrectNumberOfSugarException;

public class Command {

    private DrinkType drinkType;
    private int numberOfSugar;
    private boolean hasStick;
    private boolean isHot;

    public Command(DrinkType drinkType, int numberOfSugar, boolean isHot) {
        if (numberOfSugar < 0 || numberOfSugar > 2){
            throw new IncorrectNumberOfSugarException();
        }
        this.drinkType = drinkType;
        this.numberOfSugar = numberOfSugar;
        this.isHot = isHot;
        if (numberOfSugar != 0){
            hasStick = true;
        } else {
            hasStick = false;
        }
        if (drinkType.canBeHot() == false && isHot == true){
            this.isHot = false;
        }
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public int getNumberOfSugar() {
        return numberOfSugar;
    }

    public boolean hasStick() {
        return hasStick;
    }

    public boolean isHot() {
        return isHot;
    }

}
