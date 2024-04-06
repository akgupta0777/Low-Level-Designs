package models;
import java.util.List;

public class ParkingFloor{
    private List<ParkingSlot> slots;
    private int floor;

    public ParkingFloor(int floor,List<ParkingSlot> slots){
        this.floor = floor;
        this.slots = slots;
    }

    public int getFloor(){
        return this.floor;
    }

    public List<ParkingSlot> getParkingSlots(){
        return this.slots;
    }
}