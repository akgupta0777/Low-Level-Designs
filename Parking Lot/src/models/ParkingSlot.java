package models;

import enums.StatusType;
import enums.VehicleType;

public class ParkingSlot{
    private VehicleType vehicleType;
    private int slotID;
    private StatusType slotStatus;
    private int floor;
    private String parkingLotID;
    private Ticket ticket;

    public ParkingSlot(VehicleType vehicleType,int slotID,StatusType status,int floor,String parkingLotID){
        this.vehicleType = vehicleType;
        this.slotID = slotID;
        this.slotStatus = status;
        this.floor = floor;
        this.parkingLotID = parkingLotID;
    }

    public VehicleType getVehicleType(){
        return this.vehicleType;
    }

    public StatusType getStatus(){
        return this.slotStatus;
    }

    public void setStatus(StatusType status){
        this.slotStatus = status;
    }

    public int getID(){
        return this.slotID;
    }

    public int getFloor(){
        return this.floor;
    }

    public String getParkingLotID(){
        return this.parkingLotID;
    }

    public void setTicket(Ticket ticket){
        this.ticket = ticket;
    }
}