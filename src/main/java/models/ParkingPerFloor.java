package models;

import java.util.List;

public class ParkingPerFloor {
    long floorNumber;
    private ParkingSLotForTruck parkingSLotForTrucks;
    private List<ParkingSLotForBike> parkingSLotForBikes;
    private List<ParkingSLotForCar> parkingSLotForCars;

    public long getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(long floorNumber) {
        this.floorNumber = floorNumber;
    }

    public ParkingPerFloor(ParkingSLotForTruck parkingSLotForTrucks, List<ParkingSLotForBike> parkingSLotForBikes, List<ParkingSLotForCar> parkingSLotForCars, long floorNumber) {
        this.floorNumber = floorNumber;
        this.parkingSLotForTrucks = parkingSLotForTrucks;
        this.parkingSLotForBikes = parkingSLotForBikes;
        this.parkingSLotForCars = parkingSLotForCars;
    }

    public ParkingPerFloor() {
    }

    public ParkingSLotForTruck getParkingSLotForTrucks() {
        return parkingSLotForTrucks;
    }

    public void setParkingSLotForTrucks(ParkingSLotForTruck parkingSLotForTrucks) {
        this.parkingSLotForTrucks = parkingSLotForTrucks;
    }

    public List<ParkingSLotForBike> getParkingSLotForBikes() {
        return parkingSLotForBikes;
    }

    public void setParkingSLotForBikes(List<ParkingSLotForBike> parkingSLotForBikes) {
        this.parkingSLotForBikes = parkingSLotForBikes;
    }

    public List<ParkingSLotForCar> getParkingSLotForCars() {
        return parkingSLotForCars;
    }

    public void setParkingSLotForCars(List<ParkingSLotForCar> parkingSLotForCars) {
        this.parkingSLotForCars = parkingSLotForCars;
    }
}
