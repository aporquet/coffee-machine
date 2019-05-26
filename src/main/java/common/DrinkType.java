package common;

public enum DrinkType {
    Tea("Tea", 0.4),
    Coffee("Coffee", 0.6),
    Chocolate("Chocolate", 0.5);

    private String drinkName;
    private double drinkPrice;

    DrinkType(String drinkName, double drinkPrice){
        this.drinkName = drinkName;
        this.drinkPrice = drinkPrice;
    }

    public double getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(double drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }
}
