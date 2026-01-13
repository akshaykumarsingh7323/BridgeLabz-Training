package com.compartmentnavigationsystem;

class TrainCompanion {

    private Compartment head;
    private Compartment tail;

    public void addCompartment(String name) {
        Compartment newCompartment = new Compartment(name);

        if (head == null) {
            head = tail = newCompartment;
        } else {
            tail.next = newCompartment;
            newCompartment.prev = tail;
            tail = newCompartment;
        }
    }

    public void removeCompartment(String name) {
        Compartment current = head;

        while (current != null) {
            if (current.name.equals(name)) {

                if (current == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                }
                else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                }
                else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println(name + " removed.");
                return;
            }
            current = current.next;
        }
        System.out.println("Compartment not found.");
    }

    public Compartment moveNext(Compartment current) {
        if (current != null && current.next != null)
            return current.next;

        System.out.println("No next compartment.");
        return current;
    }

    public Compartment movePrevious(Compartment current) {
        if (current != null && current.prev != null)
            return current.prev;

        System.out.println("No previous compartment.");
        return current;
    }

    public Compartment searchCompartment(String name) {
        Compartment current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name))
                return current;
            current = current.next;
        }
        return null;
    }

    public void showAdjacent(Compartment current) {
        if (current == null) return;

        System.out.println("Current: " + current.name);
        System.out.println("Previous: " +
                (current.prev != null ? current.prev.name : "None"));
        System.out.println("Next: " +
                (current.next != null ? current.next.name : "None"));
    }

    public void displayTrain() {
        Compartment temp = head;
        System.out.print("Train Layout: ");
        while (temp != null) {
            System.out.print(temp.name + " <-> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public Compartment getHead() {
        return head;
    }
}

