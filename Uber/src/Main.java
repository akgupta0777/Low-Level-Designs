import Controllers.CabController;
import Controllers.RiderController;
import Models.Trip;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RiderController riderController = new RiderController();
        CabController cabController = new CabController();

        // Registering a rider and a cab
        String rider1 = riderController.registerRider("Abhay","1234567890");
        String rider2 = riderController.registerRider("Raghav","9865142873");
        String rider3 = riderController.registerRider("Harika","9564213785");
        String cab1 = cabController.registerCab("Avinash","9393203830");
        String cab2 = cabController.registerCab("Ramit Kapoor","9324924256");
        String cab3 = cabController.registerCab("Onkar Birajdar","8562412397");
        String cab4 = cabController.registerCab("Himansh Mishra","7596842136");

        // Updating location of rider and cab
        riderController.updateLocation(rider1,10,20);
        riderController.updateLocation(rider2,25,30);
        riderController.updateLocation(rider3,65,50);
        cabController.updateLocation(cab1,50,50);
        cabController.updateLocation(cab2,20,20);
        cabController.updateLocation(cab3,30,35);
        cabController.updateLocation(cab4,70,60);

        // Update driver availability
        cabController.updateAvailability(cab1,false);

        // Book a trip for rider
        riderController.book(rider1,100,100);
        riderController.book(rider2,90,100);
        riderController.book(rider3,100,100);

        // Fetch ride history for a particular rider
        List<Trip> rideHistory = riderController.fetchRideHistory(rider1);
        for(Trip trip : rideHistory){
            System.out.println(trip.toString());
        }

        rideHistory = riderController.fetchRideHistory(rider2);
        for(Trip trip : rideHistory){
            System.out.println(trip.toString());
        }

        rideHistory = riderController.fetchRideHistory(rider3);
        for(Trip trip : rideHistory){
            System.out.println(trip.toString());
        }

        // End trip for cab2,cab3 and cab4
        // Ending trip for cab1 will throw exception as cab1 is unavailable
        // cabController.endRide(cab1);
        cabController.endRide(cab2);
        cabController.endRide(cab3);
        cabController.endRide(cab4);

        // Fetch ride history for a particular rider
        rideHistory = riderController.fetchRideHistory(rider1);
        for(Trip trip : rideHistory){
            System.out.println(trip.toString());
        }

        rideHistory = riderController.fetchRideHistory(rider2);
        for(Trip trip : rideHistory){
            System.out.println(trip.toString());
        }

        rideHistory = riderController.fetchRideHistory(rider3);
        for(Trip trip : rideHistory){
            System.out.println(trip.toString());
        }
    }
}