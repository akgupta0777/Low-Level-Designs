import java.util.*;
import constants.Commands;
import enums.DisplayType;
import enums.VehicleType;
import services.ParkingLotService;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingLotService parkingLotService = new ParkingLotService();
        while(true){
            String input = sc.nextLine().trim();
            String[] inputSplit = input.split(" ");
            try{
                switch (inputSplit[0]){
                    case Commands.CREATE:{
                        parkingLotService.createParkingLot(inputSplit[1],Integer.parseInt(inputSplit[2]),Integer.parseInt(inputSplit[3]));
                    }
                    break;
                    case Commands.DISPLAY:{
                        parkingLotService.display(DisplayType.valueOf(inputSplit[1]), VehicleType.valueOf(inputSplit[2]));
                    }
                    break;
                    case Commands.PARK:{
                        parkingLotService.parkVehicle(VehicleType.valueOf(inputSplit[1]),inputSplit[2],inputSplit[3]);
                    }
                    break;
                    case Commands.UNPARK:{
                        parkingLotService.unparkVehicle(inputSplit[1]);
                    }
                    break;
                    case Commands.EXIT:{
                        System.exit(0);
                    }
                    break;
                    default : {
                        System.out.println("INVALID INPUT");
                    }
                }
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
    }
}