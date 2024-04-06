package models;

public class Ticket{
    private Vehicle vehicle;
    private String ticketID;
    private ParkingSlot parkingSlot;

    public Ticket(String ticketID,Vehicle vehicle,ParkingSlot parkingSlot){
        this.vehicle = vehicle;
        this.ticketID = ticketID;
        this.parkingSlot = parkingSlot;
    }

    public String getTicketID(){
        return this.ticketID;
    }

    public Vehicle getVehicle(){
        return this.vehicle;
    }

    public ParkingSlot getParkingSlot(){
        return this.parkingSlot;
    }
}