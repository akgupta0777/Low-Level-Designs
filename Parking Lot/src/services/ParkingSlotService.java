package services;

import enums.StatusType;
import models.ParkingSlot;
import models.Ticket;
import models.Vehicle;

public class ParkingSlotService{

    public static Ticket allotSlot(ParkingSlot parkingSlot, Vehicle vehicle){
        parkingSlot.setStatus(StatusType.UNAVAILABLE);
        Ticket ticket = TicketService.generateTicket(parkingSlot,vehicle);
        parkingSlot.setTicket(ticket);
        return ticket;
    }

    public static void unallotSlot(ParkingSlot parkingSlot){
        parkingSlot.setStatus(StatusType.AVAILABLE);
        parkingSlot.setTicket(null);
    }
}