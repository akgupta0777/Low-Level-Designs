package Models;

public class Cab {
    private String id;
    private String driverName;
    private String phone;
    private Location location;
    private boolean isAvailable;
    private Trip currentTrip;

    public Cab(String id,String name,String phone,Location location){
        this.id = id;
        this.driverName = name;
        this.phone = phone;
        this.location = location;
        this.isAvailable = true;
    }

    public void setLocation(Location location){
        this.location = location;
    }

    public Location getLocation(){
        return this.location;
    }

    public boolean getIsAvailable(){
        return this.isAvailable;
    }

    public void setAvailability(boolean availability){
        this.isAvailable = availability;
    }

    public Trip getCurrentTrip(){
        return this.currentTrip;
    }

    public void setCurrentTrip(Trip trip){
        this.currentTrip = trip;
    }

    public String getId(){
        return this.id;
    }

    public String getDriverName(){
        return this.driverName;
    }
}
