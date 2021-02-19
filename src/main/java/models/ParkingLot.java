package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private String id;
    private long numberOfFloors;
    private long numberOfSlot;
    private Map<Long,List<ParkingPerFloor>> parkingSLotList;


    public ParkingLot(String id, long numberOfFloors, long numberOfSlot) {
        this.id = id;
        this.numberOfFloors = numberOfFloors;
        this.numberOfSlot = numberOfSlot;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(long numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public long getNumberOfSlot() {
        return numberOfSlot;
    }

    public void setNumberOfSlot(long numberOfSlot) {
        this.numberOfSlot = numberOfSlot;
    }

    public Map<Long, List<ParkingPerFloor>> getParkingSLotList() {
        return parkingSLotList;
    }

    public void setParkingSLotList(Map<Long, List<ParkingPerFloor>> parkingSLotList) {
        this.parkingSLotList = parkingSLotList;
    }
}
