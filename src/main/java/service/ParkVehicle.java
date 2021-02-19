package service;


import models.ParkingLot;
import models.ParkingPerFloor;
import models.Tickets;
import models.Type;

import java.util.List;
import java.util.Map;

public interface ParkVehicle {
    boolean unParkVehicle(String ticketId,ParkingLot parkingLot,List<Tickets> ticketsList);
    Tickets parkVehicle(String type,String registrationNumber, String color,ParkingLot parkingLot,List<Tickets> ticketsList);
}
