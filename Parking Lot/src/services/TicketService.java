package services;

import models.ParkingSlot;
import models.Ticket;
import models.Vehicle;

import java.util.HashMap;

public class TicketService{
    private static HashMap<String,Ticket> ticketRecord = new HashMap<>();

    public static String generateTicketID(ParkingSlot parkingSlot){
        return parkingSlot.getParkingLotID()+"_"+parkingSlot.getFloor()+"_"+parkingSlot.getID();
    }

    public static Ticket generateTicket(ParkingSlot parkingSlot, Vehicle vehicle){
        String ticketID = generateTicketID(parkingSlot);
        Ticket ticket = new Ticket(ticketID,vehicle,parkingSlot);
        ticketRecord.put(ticketID,ticket);
        return ticket;
    }

    public static Ticket getTicketByID(String ticketID){
        return ticketRecord.getOrDefault(ticketID,null);
    }

    public static void deleteTicket(String ticketID){
        ticketRecord.remove(ticketID);
    }
}