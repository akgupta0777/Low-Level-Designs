package Services;

public class DiceService {
    private int minValue,maxValue;

    public DiceService(int numberOfDices){
        this.minValue = numberOfDices;
        this.maxValue = 6*numberOfDices;
    }

    public int rollDice(){
        return (int)(Math.random()*(maxValue-minValue))+minValue;
    }
}
