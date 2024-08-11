package Databases;

import Exceptions.RiderNotFoundException;
import Models.Location;
import Models.Rider;

import java.util.HashMap;

public class RiderManager {
    private final HashMap<String,Rider> RiderStore = new HashMap<>();
    private static volatile RiderManager instance = null;

    private RiderManager(){}

    // Singleton design pattern for single static instance throughout the app.
    public static RiderManager getInstance(){
        if(instance == null){
            synchronized (RiderManager.class){
                if(instance == null){
                    instance = new RiderManager();
                }
            }
        }
        return instance;
    }
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
