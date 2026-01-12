package com.emergencypatientnavigation;

class AmbulanceRoute {

    private UnitNode head = null;

    public void addUnit(String name, boolean available) {
        UnitNode newNode = new UnitNode(name, available);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        UnitNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
    }

    public void findNearestAvailableUnit() {
        if (head == null) {
            System.out.println("No hospital units available");
            return;
        }

        UnitNode temp = head;
        do {
            if (temp.available) {
                System.out.println("Patient redirected to: " + temp.unitName);
                return;
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println("No units currently available");
    }

    public void removeUnit(String unitName) {
        if (head == null) return;

        UnitNode curr = head;
        UnitNode prev = null;

        do {
            if (curr.unitName.equals(unitName)) {

                if (curr.next == head && curr == head) {
                    head = null;
                    return;
                }

                if (curr == head) {
                    UnitNode last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = curr.next;
                }

                System.out.println(unitName + " removed (Maintenance)");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void displayRoute() {
        if (head == null) return;

        UnitNode temp = head;
        do {
            System.out.print(temp.unitName + " → ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to " + head.unitName + ")");
    }
}
