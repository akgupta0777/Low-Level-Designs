package Databases;

import Exceptions.NoMatchingCabFound;
import Models.Location;
import Models.Rider;
import Models.Cab;
import Models.Trip;
import Strategies.CabMatchingStrategy;
import Strategies.DefaultCabMatchingStrategy;
import Strategies.DefaultPriceStrategy;
import Strategies.PriceStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TripManager {
    HashMap<String,List<Trip>> TripStore = new HashMap<>();
    private final double MAX_MATCHING_RADIUS = 10;
    private final CabManager cabManager = new CabManager();
    private PriceStrategy defaultPriceStrategy = new DefaultPriceStrategy();
    private CabMatchingStrategy defaultCabMatchingStrategy = new DefaultCabMatchingStrategy();

    public void book(Rider rider,double x,double y){
        List<Cab> availableCabs = cabManager.getAvailableCabs(rider,MAX_MATCHING_RADIUS);
        availableCabs = availableCabs.stream().filter(cab -> cab.getCurrentTrip()==null).toList();
        Cab matchingCab = defaultCabMatchingStrategy.findMatchingCab(availableCabs);
        if(matchingCab == null){
            throw new NoMatchingCabFound();
        }
        Location destination = new Location(x,y);
        double fare = defaultPriceStrategy.calculateFare(rider.getLocation(),destination);
        Trip newTrip = new Trip(rider,matchingCab,fare,rider.getLocation(),destination);
        if(!TripStore.containsKey(rider.getId())){
            TripStore.put(rider.getId(),new ArrayList<>());
        }
        TripStore.get(rider.getId()).add(newTrip);
        matchingCab.setCurrentTrip(newTrip);
    }
}
