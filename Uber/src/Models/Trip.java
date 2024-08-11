package Models;

enum TripStatus{
    IN_PROGRESS,
    FINISHED
}

public class Trip {
    private Rider rider;
    private Cab cab;
    private double fare;
    private Location from;
    private Location to;
    private TripStatus status;

    public Trip(Rider rider,Cab cab,double fare,Location from,Location to){
        this.rider = rider;
        this.cab = cab;
        this.fare = fare;
        this.from = from;
        this.to = to;
        this.status = TripStatus.IN_PROGRESS;
    }

    public void end(){
        this.status = TripStatus.FINISHED;
    }

    @Override
    public String toString(){
        return "Rider ID : "+rider.getId()+" \nRider Name: "+rider.getName()+" \nCab ID: "+cab.getId()+" \nDriver's Name: "+cab.getDriverName()+" \nRide fare: "+fare+" \nFrom Location: "+from.toString()+" \nTo Location: "+to.toString()+" \nTrip Status: "+status.toString();
    }
}
