package services;

import enums.DisplayType;
import enums.StatusType;
import enums.VehicleType;
import models.ParkingFloor;
import models.ParkingLot;
import models.ParkingSlot;
import models.Vehicle;
import models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotService{
    private ParkingLot parkingLot;

    public ParkingLotService(){
        this.parkingLot = null;
    }

    public void createParkingLot(String parkingLotID,int numberOfFloors,int numberOfSlots){
        List<ParkingFloor> parkingFloorList = new ArrayList<>(numberOfFloors);
        for(int floorIndex=0;floorIndex<numberOfFloors;++floorIndex){
            List<ParkingSlot> parkingSlotList = new ArrayList<>(numberOfSlots);
            for(int slotIndex=0;slotIndex<numberOfSlots;++slotIndex){
                ParkingSlot parkingSlot;
                if(slotIndex==0){
                    parkingSlot = new ParkingSlot(VehicleType.TRUCK,slotIndex+1, StatusType.AVAILABLE,floorIndex+1,parkingLotID);
                }else if(slotIndex==1 || slotIndex==2){
                    parkingSlot = new ParkingSlot(VehicleType.BIKE,slotIndex+1,StatusType.AVAILABLE,floorIndex+1,parkingLotID);
                }else{
                    parkingSlot = new ParkingSlot(VehicleType.CAR,slotIndex+1,StatusType.AVAILABLE,floorIndex+1,parkingLotID);
                }
                parkingSlotList.add(parkingSlot);
            }
            ParkingFloor parkingFloor = new ParkingFloor(floorIndex+1,parkingSlotList);
            parkingFloorList.add(parkingFloor);
        }
        parkingLot = new ParkingLot(parkingLotID,numberOfFloors,numberOfSlots,parkingFloorList);
    }

    public void display(DisplayType displayType,VehicleType vehicleType){
        List<ParkingFloor> parkingFloorList = parkingLot.getParkingFloors();
        for(ParkingFloor parkingFloor : parkingFloorList){
            if(displayType.equals(DisplayType.free_count)){
                long freeCount = ParkingFloorService.getFreeCount(parkingFloor,vehicleType);
                System.out.println("No. of free slots for "+vehicleType.name()+" on Floor "+parkingFloor.getFloor()+": "+freeCount);
            }else if(displayType.equals(DisplayType.free_slots)) {
                List<ParkingSlot> freeSlots = ParkingFloorService.getFreeSlots(parkingFloor,vehicleType);
                System.out.print("Free slots for "+vehicleType.name()+" on Floor "+parkingFloor.getFloor()+": ");
                for(ParkingSlot slot : freeSlots){
                    System.out.print(slot.getID()+" ");
                }
                System.out.println();
            }else{
                List<ParkingSlot> occupiedSlots = ParkingFloorService.getOccupiedSlots(parkingFloor,vehicleType);
                System.out.print("Occupied slots for "+vehicleType.name()+" on Floor "+parkingFloor.getFloor()+": ");
                for(ParkingSlot slot : occupiedSlots){
                    System.out.print(slot.getID()+" ");
                }
                System.out.println();
            }
        }
    }

    public void parkVehicle(VehicleType vehicleType,String regNumber,String color){
        List<ParkingFloor> parkingFloorList = parkingLot.getParkingFloors();
        for(ParkingFloor parkingFloor : parkingFloorList){
            List<ParkingSlot> freeSlots = ParkingFloorService.getFreeSlots(parkingFloor,vehicleType);
            if(!freeSlots.isEmpty()){
                Vehicle vehicle = new Vehicle(vehicleType,regNumber,color);
                Ticket parkingTicket = ParkingSlotService.allotSlot(freeSlots.get(0),vehicle);
                System.out.println("Parked vehicle. Ticket ID: "+parkingTicket.getTicketID());
                return ;
            }
        }
        System.out.println("Parking Lot Full");
    }

    public void unparkVehicle(String ticketID) {
        Ticket ticket = TicketService.getTicketByID(ticketID);
        if(ticket==null){
            System.out.println("INVALID TICKET ID");
            return ;
        }
        Vehicle vehicle = ticket.getVehicle();
        ParkingSlot parkingSlot = ticket.getParkingSlot();
        ParkingSlotService.unallotSlot(parkingSlot);
        TicketService.deleteTicket(ticketID);
        System.out.println("Unparked vehicle with Registration Number: "+vehicle.getRegNumber()+" and Color: "+vehicle.getColor());
    }
}