package Models;

public class Trip {
    private Rider rider;
    private Cab cab;
    private double fare;
    private Location from;
    private Location to;

    public Trip(Rider rider,Cab cab,double fare,Location from,Location to){
        this.rider = rider;
        this.cab = cab;
        this.fare = fare;
        this.from = from;
        this.to = to;
    }
}
