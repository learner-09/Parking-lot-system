package service;

import models.*;

import java.util.*;

public class CreatingParkingLotImpl implements CreatingParkingLot {

    @Override
    public ParkingLot createParkingLot(String parkingId, long numberOfFloor, long numberOfSlot) {
        Map<Long, List<ParkingPerFloor>> hashMap = new TreeMap<>();
        ParkingLot parkingLot = new ParkingLot(parkingId, numberOfFloor, numberOfSlot);
        while (numberOfFloor > 0) {
            ParkingPerFloor parkingPerFloor = new ParkingPerFloor();
            List<ParkingPerFloor> list = new LinkedList<>();
            parkingPerFloor.setFloorNumber(numberOfFloor);
            long i = 1;
            long n = numberOfSlot;
            if (n > 0) {
                ParkingSLotForTruck sLotForTruck = new ParkingSLotForTruck();
                sLotForTruck.setSlotNumber(i++);
                parkingPerFloor.setParkingSLotForTrucks(sLotForTruck);
                n--;
            }
            if (n != 0) {
                if (n >= 2) {
                    List<ParkingSLotForBike> parkingSLotForBikes = new LinkedList<>();
                    ParkingSLotForBike parkingSLotForBike0 = new ParkingSLotForBike();
                    parkingSLotForBike0.setSlotNumber(i++);
                    parkingSLotForBikes.add(parkingSLotForBike0);
                    ParkingSLotForBike parkingSLotForBike1 = new ParkingSLotForBike();
                    parkingSLotForBike1.setSlotNumber(i++);
                    parkingSLotForBikes.add(parkingSLotForBike1);
                    n = n - 2;
                    parkingPerFloor.setParkingSLotForBikes(parkingSLotForBikes);
                } else if (n == 1) {
                    List<ParkingSLotForBike> parkingSLotForBikes = new LinkedList<>();
                    ParkingSLotForBike parkingSLotForBike0 = new ParkingSLotForBike();
                    parkingSLotForBike0.setSlotNumber(i++);
                    parkingSLotForBikes.add(parkingSLotForBike0);
                    n = n - 1;
                    parkingPerFloor.setParkingSLotForBikes(parkingSLotForBikes);
                }
            }
            List<ParkingSLotForCar> parkingSLotForCarList = new LinkedList<>();
            while (n != 0) {
                ParkingSLotForCar parkingSLotForCar = new ParkingSLotForCar();
                parkingSLotForCar.setSlotNumber(i++);
                parkingSLotForCarList.add(parkingSLotForCar);
                n--;
            }
            parkingPerFloor.setParkingSLotForCars(parkingSLotForCarList);
            list.add(parkingPerFloor);
            hashMap.put(numberOfFloor, list);
            numberOfFloor--;
            System.out.println(hashMap);
        }
        System.out.println(hashMap);
        parkingLot.setParkingSLotList(hashMap);
        return parkingLot;
    }
}


