package Controllers;

import Databases.RiderManager;
import Databases.TripManager;
import Models.Trip;
import Utils.IdGeneration;

import java.util.List;

public class RiderController {
    private final RiderManager riderManager = RiderManager.getInstance();
    private TripManager tripManager = new TripManager();

    public RiderController(){

    }

    public RiderController(TripManager tripManager){
        this.tripManager = tripManager;
    }

    public String registerRider(String name,String phone){
        String id = IdGeneration.generateID();
        riderManager.registerRider(id,name,phone);
        System.out.println("Rider registered Successfully! ID: "+id);
        return id;
    }

    public void updateLocation(String id,double x,double y){
        riderManager.updateLocation(id,x,y);
        System.out.println("Location updated successfully!");
    }

    public void book(String id,double x,double y){
        tripManager.book(riderManager.getRider(id),x,y);
        System.out.println("Cab Successfully Booked.");
    }

    public List<Trip> fetchRideHistory(String id){
        List<Trip> rideHistory = tripManager.getTrips(id);
        return rideHistory;
    }
}
