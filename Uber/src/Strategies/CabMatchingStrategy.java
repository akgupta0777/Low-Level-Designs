package Strategies;

import Models.Cab;

import java.util.List;

public interface CabMatchingStrategy {
    public Cab findMatchingCab(List<Cab> candidateCabs);
}
