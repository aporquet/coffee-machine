package model;

public class Sender {

    private Command command;

    public Sender(Command command){
        this.command = command;
    }

    public String printCommandValidation(Command command){
        return " "+command.getDrinkType()+" "+command.getNumberOfSugar()+" "+command.hasStick();
    }
}
