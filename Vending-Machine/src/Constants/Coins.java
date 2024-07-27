package Constants;

public enum Coins {
    PENNY(0.01),
    NICKEL(0.05),
    DIME(0.1),
    QUARTER(0.25);


    private final double value;
    Coins(double value){
        this.value = value;
    }

    public double getValue(){
        return value;
    }
}
