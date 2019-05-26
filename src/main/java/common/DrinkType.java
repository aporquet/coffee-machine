package common;

public enum DrinkType {
    Tea("Tea", 0.4, true),
    Coffee("Coffee", 0.6, true),
    Chocolate("Chocolate", 0.5, true),
    OrangeJuice("Orange juice", 0.6, false);

    private String drinkName;
    private double drinkPrice;
    private boolean canBeHot;

    DrinkType(String drinkName, double drinkPrice, boolean canBeHot) {
        this.drinkName = drinkName;
        this.drinkPrice = drinkPrice;
        this.canBeHot = canBeHot;
    }

    public double getDrinkPrice() {
        return drinkPrice;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public boolean canBeHot() {
        return canBeHot;
    }
}