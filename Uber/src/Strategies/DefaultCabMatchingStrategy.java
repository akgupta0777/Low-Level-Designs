package Strategies;

import Models.Cab;

import java.util.List;

public class DefaultCabMatchingStrategy implements CabMatchingStrategy{

    @Override
    public Cab findMatchingCab(List<Cab> candidateCabs) {
        if(candidateCabs.isEmpty())
            return null;
        return candidateCabs.get(0);
    }
}
