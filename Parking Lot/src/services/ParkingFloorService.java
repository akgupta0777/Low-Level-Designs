package services;

import enums.StatusType;
import enums.VehicleType;
import models.ParkingFloor;
import models.ParkingSlot;

import java.util.List;

public class ParkingFloorService{

    public static long getFreeCount(ParkingFloor parkingFloor, VehicleType vehicleType){
        List<ParkingSlot> parkingSlotList = parkingFloor.getParkingSlots();
        long count = parkingSlotList.stream().filter(slot -> (slot.getVehicleType().equals(vehicleType) && slot.getStatus().equals(StatusType.AVAILABLE))).count();
        return count;
    }

    public static List<ParkingSlot> getFreeSlots(ParkingFloor parkingFloor, VehicleType vehicleType){
        List<ParkingSlot> parkingSlotList = parkingFloor.getParkingSlots();
        List<ParkingSlot> freeSlotList = parkingSlotList.stream().filter(slot -> (slot.getVehicleType().equals(vehicleType) && slot.getStatus().equals(StatusType.AVAILABLE))).toList();
        return freeSlotList;
    }

    public static List<ParkingSlot> getOccupiedSlots(ParkingFloor parkingFloor, VehicleType vehicleType){
        List<ParkingSlot> parkingSlotList = parkingFloor.getParkingSlots();
        List<ParkingSlot> occupiedSlotList = parkingSlotList.stream().filter(slot -> (slot.getVehicleType().equals(vehicleType) && slot.getStatus().equals(StatusType.UNAVAILABLE))).toList();
        return occupiedSlotList;
    }
}