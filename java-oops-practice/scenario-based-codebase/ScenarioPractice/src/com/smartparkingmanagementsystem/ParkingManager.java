package com.smartparkingmanagementsystem;

import java.util.*;

public class ParkingManager {

    private Map<Integer, String> bookingRecords = new HashMap<>(); 

    public void parkVehicle(ParkingSlot slot, Vehicle vehicle) {
        if (slot.assignSlot()) {
            bookingRecords.put(slot.getSlotId(), vehicle.getVehicleNumber());
            System.out.println("Vehicle parked at Slot " + slot.getSlotId());
        } else {
            System.out.println("Slot already occupied!");
        }
    }

    public void unparkVehicle(ParkingSlot slot) {
        slot.releaseSlot();
        bookingRecords.remove(slot.getSlotId());
        System.out.println("Slot " + slot.getSlotId() + " is now free");
    }

    public void showLogs() {
        System.out.println("Parking Logs: " + bookingRecords);
    }
}
