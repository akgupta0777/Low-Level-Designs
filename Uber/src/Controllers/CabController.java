package Controllers;

import Databases.CabManager;
import Models.Location;
import Utils.IdGeneration;

public class CabController {
    private CabManager cabManager = new CabManager();

    public String registerCab(String name,String phone){
        String id = IdGeneration.generateID();
        cabManager.createCab(id,name,phone);
        System.out.println("Cab Register Successfully! ID: "+id);
        return id;
    }

    public void updateLocation(String id,int x,int y){
        cabManager.updateLocation(id,x,y);
        System.out.println("Location updated successfully!");
    }

    public void updateAvailability(String id,boolean availability){
        cabManager.updateAvailability(id,availability);
        System.out.println("Availability set to "+availability);
    }
}
