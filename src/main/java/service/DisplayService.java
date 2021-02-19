package service;


import models.ParkingLot;
import models.ParkingPerFloor;

import java.util.List;
import java.util.Map;

public interface DisplayService {
    void free_count(String vehicleType, ParkingLot parkingLot);
    void free_slots(String vehicleType, ParkingLot parkingLot);
    void occupied_slots(String vehicleType, ParkingLot parkingLot);
}
