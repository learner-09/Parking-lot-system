package service;

import models.*;

import java.util.List;
import java.util.Map;

public class ParkVehicleImpl implements ParkVehicle {
    @Override
    public boolean unParkVehicle(String ticketId, ParkingLot parkingLot, List<Tickets> ticketsList) {
        String[] list = ticketId.split("_");
        for (Tickets tickets : ticketsList) {
            if (tickets.getId().equals(ticketId)) {
                Type type = tickets.getType();
                if (String.valueOf(type).equals("Car")) {
                    System.out.println(parkingLot.getParkingSLotList().get(Long.parseLong(list[1])).size());
                    int indexOfCar = Integer.parseInt(list[2]) - 4;
                    ParkingSLotForCar parkingSLotForCar = parkingLot.getParkingSLotList().get(Long.parseLong(list[1])).get(0).getParkingSLotForCars().get(indexOfCar);
                    parkingSLotForCar.setOccupied(false);
                    parkingSLotForCar.setVehicle(null);
                    return true;
                } else if (String.valueOf(type).equals("Truck")) {
                    System.out.println(parkingLot.getParkingSLotList().get(Long.parseLong(list[1])).size());
                    int indexOfTruck = Integer.parseInt(list[2]);
                    ParkingSLotForTruck parkingSLotForTruck = parkingLot.getParkingSLotList().get(Long.parseLong(list[1])).get(0).getParkingSLotForTrucks();
                    parkingSLotForTruck.setOccupied(false);
                    parkingSLotForTruck.setVehicle(null);
                    return true;
                } else if (String.valueOf(type).equals("Bike")) {
                    System.out.println(parkingLot.getParkingSLotList().get(Long.parseLong(list[1])).size());
                    int indexOfBike = Integer.parseInt(list[2]) - 2;
                    ParkingSLotForBike parkingSLotForBike = parkingLot.getParkingSLotList().get(Long.parseLong(list[1])).get(0).getParkingSLotForBikes().get(indexOfBike);
                    parkingSLotForBike.setOccupied(false);
                    parkingSLotForBike.setVehicle(null);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Tickets parkVehicle(String type, String registrationNumber, String color, ParkingLot parking, List<Tickets> ticketsList) {
        if (parking == null) {
            System.out.println("Hello");
            return null;
        }
        Map<Long, List<ParkingPerFloor>> parkingLot = parking.getParkingSLotList();
        for (Long i : parkingLot.keySet()) {
            List<ParkingPerFloor> parkingPerFloorList = parkingLot.get(i);
            for (ParkingPerFloor parkingPerFloor : parkingPerFloorList) {
                if (type.equals(Type.Car.toString())) {
                    List<ParkingSLotForCar> parkingSLotForCars = parkingPerFloor.getParkingSLotForCars();
                    for (ParkingSLotForCar parkingSLotForCar : parkingSLotForCars) {
                        if (!parkingSLotForCar.isOccupied()) {
                            parkingSLotForCar.setOccupied(true);
                            parkingSLotForCar.setVehicle(new Vehicle(Type.Car, color, registrationNumber));
                            String id = parking.getId() + "_" + parkingPerFloor.getFloorNumber() + "_" + parkingSLotForCar.getSlotNumber();
                            Tickets tickets = new Tickets();
                            tickets.setId(id);
                            tickets.setType(Type.Car);
                            ticketsList.add(tickets);
                            return tickets;
                        }
                    }
                } else if (type.equals(Type.Truck.toString())) {
                    List<ParkingSLotForCar> parkingSLotForCars = parkingPerFloor.getParkingSLotForCars();
                    ParkingSLotForTruck parkingSLotForTrucks = parkingPerFloor.getParkingSLotForTrucks();
                    if (!parkingSLotForTrucks.isOccupied()) {
                        parkingSLotForTrucks.setOccupied(true);
                        parkingSLotForTrucks.setVehicle(new Vehicle(Type.Truck, color, registrationNumber));
                        String id = parking.getId() + "_" + parkingPerFloor.getFloorNumber() + "_" + parkingSLotForTrucks.getSlotNumber();
                        Tickets tickets = new Tickets();
                        tickets.setId(id);
                        tickets.setType(Type.Truck);
                        ticketsList.add(tickets);
                        return tickets;
                    }
                } else if (type.equals(Type.Bike.toString())) {
                    List<ParkingSLotForBike> parkingSLotForBikes = parkingPerFloor.getParkingSLotForBikes();
                    for (ParkingSLotForBike parkingSLotForBike : parkingSLotForBikes) {
                        if (!parkingSLotForBike.isOccupied()) {
                            System.out.println("Hello");
                            parkingSLotForBike.setOccupied(true);
                            parkingSLotForBike.setVehicle(new Vehicle(Type.Bike, color, registrationNumber));
                            String id = parking.getId() + "_" + parkingPerFloor.getFloorNumber() + "_" + parkingSLotForBike.getSlotNumber();
                            Tickets tickets = new Tickets();
                            tickets.setId(id);
                            tickets.setType(Type.Bike);
                            ticketsList.add(tickets);
                            return tickets;
                        }
                    }
                }
            }

        }
        return null;
    }
}
