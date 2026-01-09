package com.smartparkingmanagementsystem;

public class ParkingSlot {

    private int slotId;
    private boolean isOccupied;
    private String vehicleTypeAllowed;
    private String location;

    public ParkingSlot(int slotId, String location, String vehicleTypeAllowed) {
        this.slotId = slotId;
        this.location = location;
        this.vehicleTypeAllowed = vehicleTypeAllowed;
        this.isOccupied = false;
    }

    public boolean assignSlot() {
        if (!isOccupied) {
            isOccupied = true;
            return true;
        }
        return false;
    }

    public void releaseSlot() {
        isOccupied = false;
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

    public int getSlotId() {
        return slotId;
    }

    public String getVehicleTypeAllowed() {
        return vehicleTypeAllowed;
    }
}
