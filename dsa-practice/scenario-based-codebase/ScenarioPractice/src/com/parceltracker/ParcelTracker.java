package com.parceltracker;

class ParcelTracker {

    private ParcelStage head;

    public ParcelTracker() {
        head = new ParcelStage("Packed");
        ParcelStage shipped = new ParcelStage("Shipped");
        ParcelStage transit = new ParcelStage("In Transit");
        ParcelStage delivered = new ParcelStage("Delivered");

        head.next = shipped;
        shipped.next = transit;
        transit.next = delivered;
    }

    public void addCheckpoint(String afterStage, String newStage) {

        ParcelStage temp = head;

        while (temp != null) {
            if (temp.stageName.equals(afterStage)) {
                ParcelStage node = new ParcelStage(newStage);
                node.next = temp.next;
                temp.next = node;
                System.out.println("Checkpoint added: " + newStage);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Stage not found");
    }

    public void trackParcel() {

        if (head == null) {
            System.out.println("Parcel lost (No tracking info)");
            return;
        }

        ParcelStage temp = head;
        System.out.print("Parcel Status: ");

        while (temp != null) {
            System.out.print(temp.stageName + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void markParcelLost(String stage) {

        ParcelStage temp = head;

        while (temp != null && temp.next != null) {
            if (temp.stageName.equals(stage)) {
                temp.next = null;
                System.out.println("Parcel lost after stage: " + stage);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Stage not found");
    }
}

