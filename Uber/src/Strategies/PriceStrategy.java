package Strategies;

import Models.Location;

public interface PriceStrategy {
    public double calculateFare(Location from,Location to);
}
