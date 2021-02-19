package service;

import models.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayServiceImpl implements DisplayService{
    @Override
    public void free_count(String vehicleType, ParkingLot parkingLot) {
        Utility(parkingLot,vehicleType);
    }

    @Override
    public void free_slots(String type, ParkingLot parking) {
        utilForSlotsCounting(type,parking,false);
    }

    @Override
    public void occupied_slots(String vehicleType, ParkingLot parkingLot) {
        utilForSlotsCounting(vehicleType,parkingLot,true);
    }

    private void Utility(ParkingLot parking,String type){
        int count=0;
        Map<Long,List<ParkingPerFloor>> parkingLot=parking.getParkingSLotList();
        for(Long i:parkingLot.keySet()){
            List<ParkingPerFloor> parkingPerFloorList=parkingLot.get(i);
            for (ParkingPerFloor parkingPerFloor:parkingPerFloorList){
                if(type.equals(Type.Car.toString())){
                    List<ParkingSLotForCar> parkingSLotForCars=parkingPerFloor.getParkingSLotForCars();
                    for(ParkingSLotForCar parkingSLotForCar:parkingSLotForCars){
                        if(!parkingSLotForCar.isOccupied()){
                            count++;
                        }
                    }
                    System.out.println("No. of free slots for "+type+" on Floor "+parkingPerFloor.getFloorNumber()+": "+count);
                    count=0;
                }
                else if(type.equals(Type.Truck.toString())){
                    List<ParkingSLotForCar> parkingSLotForCars=parkingPerFloor.getParkingSLotForCars();
                    ParkingSLotForTruck parkingSLotForTrucks = parkingPerFloor.getParkingSLotForTrucks();
                    if(!parkingSLotForTrucks.isOccupied()){
                        count++;
                    }
                    System.out.println("No. of free slots for "+type+" on Floor "+parkingPerFloor.getFloorNumber()+": "+count);
                    count=0;
                }
                else if(type.equals(Type.Bike.toString())){
                    List<ParkingSLotForBike> parkingSLotForBikes=parkingPerFloor.getParkingSLotForBikes();
                    for(ParkingSLotForBike parkingSLotForBike:parkingSLotForBikes){
                        if(!parkingSLotForBike.isOccupied()){
                            count++;
                        }
                    }
                    System.out.println("No. of free slots for "+type+" on Floor "+parkingPerFloor.getFloorNumber()+": "+count);
                    count=0;
                }
            }

        }
    }

    private void utilForSlotsCounting(String type,ParkingLot parking,boolean check){
        String listOfSlotsPerfloor="";
        Map<Long,List<ParkingPerFloor>> parkingLot=parking.getParkingSLotList();
        for(Long i:parkingLot.keySet()){
            List<ParkingPerFloor> parkingPerFloorList=parkingLot.get(i);
            for (ParkingPerFloor parkingPerFloor:parkingPerFloorList){
                if(type.equals(Type.Car.toString())){
                    List<ParkingSLotForCar> parkingSLotForCars=parkingPerFloor.getParkingSLotForCars();
                    for(ParkingSLotForCar parkingSLotForCar:parkingSLotForCars){
                        if(parkingSLotForCar.isOccupied()==check){
                            listOfSlotsPerfloor=listOfSlotsPerfloor+" "+parkingSLotForCar.getSlotNumber()+"";
                        }
                    }
                    System.out.println("Free slots for "+type+" on Floor "+parkingPerFloor.getFloorNumber()+": "+listOfSlotsPerfloor);
                    listOfSlotsPerfloor="";
                }
                else if(type.equals(Type.Truck.toString())){
                    List<ParkingSLotForCar> parkingSLotForCars=parkingPerFloor.getParkingSLotForCars();
                    ParkingSLotForTruck parkingSLotForTrucks = parkingPerFloor.getParkingSLotForTrucks();
                    if(parkingSLotForTrucks.isOccupied()==check){
                        listOfSlotsPerfloor=listOfSlotsPerfloor+" "+parkingSLotForTrucks.getSlotNumber();
                    }
                    System.out.println("Free slots for "+type+" on Floor "+parkingPerFloor.getFloorNumber()+": "+listOfSlotsPerfloor);
                    listOfSlotsPerfloor="";
                }
                else if(type.equals(Type.Bike.toString())){
                    List<ParkingSLotForBike> parkingSLotForBikes=parkingPerFloor.getParkingSLotForBikes();
                    for(ParkingSLotForBike parkingSLotForBike:parkingSLotForBikes){
                        if(parkingSLotForBike.isOccupied()==check){
                            listOfSlotsPerfloor=listOfSlotsPerfloor+" "+parkingSLotForBike.getSlotNumber();
                        }
                    }
                    System.out.println("Free slots for "+type+" on Floor "+parkingPerFloor.getFloorNumber()+": "+listOfSlotsPerfloor);
                    listOfSlotsPerfloor="";
                }
            }

        }}
}
