package models;
import java.util.List;

public class ParkingLot{
    private String ID;
    private int numberOfFloors,numberOfSlots;
    private List<ParkingFloor> parkingFloors;

    public ParkingLot(String id,int floors,int slots,List<ParkingFloor> parkingFloors){
        this.ID=id;
        this.numberOfFloors=floors;
        this.numberOfSlots=slots;
        this.parkingFloors = parkingFloors;
    }

    public List<ParkingFloor> getParkingFloors(){
        return this.parkingFloors;
    }
}