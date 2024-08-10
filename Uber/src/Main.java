import Controllers.CabController;
import Controllers.RiderController;
import Databases.TripManager;
import Strategies.CabMatchingStrategy;
import Strategies.DefaultCabMatchingStrategy;
import Strategies.DefaultPriceStrategy;
import Strategies.PriceStrategy;

public class Main {
    public static void main(String[] args) {
        RiderController riderController = new RiderController();
        CabController cabController = new CabController();

        // Registering a rider and a cab
        String rider1 = riderController.registerRider("Abhay","1234567890");
        String cab1 = cabController.registerCab("Avinash","9393203830");
        String cab2 = cabController.registerCab("Ramit Kapoor","9324924256");

        // Updating location of rider and cab
        riderController.updateLocation(rider1,10,20);
        cabController.updateLocation(cab1,50,50);
        cabController.updateLocation(cab2,10,20);

        // Update driver availability
        cabController.updateAvailability(cab1,false);

        // Book a trip for rider
        riderController.book(rider1,100,100);

    }
}