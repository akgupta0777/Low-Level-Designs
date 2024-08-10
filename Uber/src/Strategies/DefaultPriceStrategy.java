package Strategies;

import Models.Location;

public class DefaultPriceStrategy implements PriceStrategy{
    public double calculateFare(Location from,Location to){
        double distance = from.calculateDistance(to);
        return distance*10;
    }
}
