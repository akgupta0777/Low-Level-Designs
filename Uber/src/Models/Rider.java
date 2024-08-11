package Models;

public class Rider {
    private String id;
    private String name;
    private String phone;
    private Location location;

    public Rider(String id,String name,String phone,Location location){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.location = location;
    }

    public void setLocation(Location location){
        this.location = location;
    }

    public Location getLocation(){
        return this.location;
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }
    
}
