package service;

import models.ParkingLot;
import models.ParkingPerFloor;

import java.util.List;
import java.util.Map;

public interface CreatingParkingLot {
    ParkingLot createParkingLot(String parkingId, long numberOfFloor, long numberOfSlot);
}
