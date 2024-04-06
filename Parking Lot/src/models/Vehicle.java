package models;

import enums.VehicleType;

public class Vehicle{
    private VehicleType vehicleType;
    private String regNumber;
    private String color;

    public Vehicle(VehicleType vehicleType,String regNumber,String color){
        this.vehicleType = vehicleType;
        this.regNumber = regNumber;
        this.color = color;
    }

    public String getRegNumber(){
        return this.regNumber;
    }

    public String getColor(){
        return this.color;
    }

}