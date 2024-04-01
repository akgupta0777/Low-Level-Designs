package Models;

import java.util.UUID;

public class Player {
    private String name,uniqueID;

    public Player(String name){
        this.name = name;
        this.uniqueID = UUID.randomUUID().toString();
    }

    public String getName(){
        return this.name;
    }

    public String getID(){
        return this.uniqueID;
    }
}
