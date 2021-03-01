import models.ParkingLot;
import models.ParkingPerFloor;
import models.Tickets;
import models.Type;
import service.CreatingParkingLotImpl;
import service.DisplayServiceImpl;
import service.ParkVehicle;
import service.ParkVehicleImpl;

import java.util.*;

public class Runner {
    private static ParkingLot parkingLot = null;
    private static List<Tickets> TicketList = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            String cmd[] = input.split(" ");
            switch (cmd[0]) {
                case "create_parking_lot":
                    parkingLot = new CreatingParkingLotImpl().createParkingLot(cmd[1], Long.parseLong(cmd[2]), Long.parseLong(cmd[3]));
                    if (parkingLot != null) {
                        System.out.println("Created parking lot with " + cmd[2] + " floors and " + cmd[3] + " slots per floor");
                    }
                    break;
                case "park_vehicle":
                    System.out.println(new ParkVehicleImpl().parkVehicle(cmd[1], cmd[2], cmd[3], parkingLot, TicketList));
                    break;
                case "unpark_vehicle":
                    new ParkVehicleImpl().unParkVehicle(cmd[1], parkingLot, TicketList);
                    break;

                case "display":
                    switch (cmd[1]) {
                        case "free_count":
                            new DisplayServiceImpl().free_count(cmd[2], parkingLot);
                            break;
                        case "free_slots":
                            new DisplayServiceImpl().free_slots(cmd[2], parkingLot);
                            break;
                        case "occupied_slots":
                            new DisplayServiceImpl().occupied_slots(cmd[2], parkingLot);
                            break;
                    }
                    break;

            }
        }
    }
}
