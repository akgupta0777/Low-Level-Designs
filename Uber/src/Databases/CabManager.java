package Databases;

import Exceptions.CabNotFoundException;
import Models.Cab;
import Models.Location;
import Models.Rider;

import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;

public class CabManager {
    private final HashMap<String,Cab> CabStore = new HashMap<>();
    private static volatile CabManager instance = null;
    private CabManager(){

    }

    // Singleton pattern for single object creation
    public static CabManager getInstance(){
        if(instance == null){
            synchronized (CabManager.class){
                if(instance == null){
                    instance = new CabManager();
                }
            }
        }
        return instance;
    }

    public Cab getCab(String id){
        Cab cab = CabStore.getOrDefault(id,null);
        if(cab==null){
            throw new CabNotFoundException();
        }
        return cab;
    }

    public void createCab(String id,String name,String phone){
        Location initial = new Location(0,0);
        Cab cab = new Cab(id,name,phone,initial);
        CabStore.put(id,cab);
    }

    public void updateLocation(String id,int x,int y){
        Cab cab = getCab(id);
        Location location = new Location(x,y);
        cab.setLocation(location);
    }

    public void updateAvailability(String id,boolean availability){
        Cab cab = getCab(id);
        cab.setAvailability(availability);
    }

    public List<Cab> getAvailableCabs(Rider rider,double MAX_RADIUS){
        List<Cab> availableCabs = new ArrayList<>();
        for(Cab cab : CabStore.values()){
            if(cab.getIsAvailable() && cab.getLocation().calculateDistance(rider.getLocation())<=MAX_RADIUS){
                availableCabs.add(cab);
            }
        }
        return availableCabs;
    }
}
