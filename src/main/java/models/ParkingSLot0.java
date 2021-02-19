package models;

public abstract class ParkingSLot0 {
    private long slotNumber;
    private boolean occupied;
    private Vehicle vehicle;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public long getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(long slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
