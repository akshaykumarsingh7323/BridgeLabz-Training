package com.parceltracker;

public class UseParcelTracker {
    public static void main(String[] args) {

        ParcelTracker tracker = new ParcelTracker();

        tracker.trackParcel();

        tracker.addCheckpoint("In Transit", "Out for Delivery");
        tracker.trackParcel();

        tracker.markParcelLost("Shipped");
        tracker.trackParcel();
    }
}
