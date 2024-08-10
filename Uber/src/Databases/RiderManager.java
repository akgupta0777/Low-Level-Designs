package Databases;

import Exceptions.RiderNotFoundException;
import Models.Location;
import Models.Rider;

import java.util.HashMap;

public class RiderManager {
    HashMap<String,Rider> RiderStore = new HashMap<>();

    public Rider getRider(String id){
        return RiderStore.getOrDefault(id, null);
    }

    public void registerRider(String id,String name,String phone){
        Location initial = new Location(0,0);
        Rider rider = new Rider(id,name,phone,initial);
        RiderStore.put(id,rider);
    }

    public void updateLocation(String id,double x,double y){
        Rider rider = getRider(id);
        if(rider==null){
            throw new RiderNotFoundException();
        }
        Location location = new Location(x,y);
        rider.setLocation(location);
    }
}
