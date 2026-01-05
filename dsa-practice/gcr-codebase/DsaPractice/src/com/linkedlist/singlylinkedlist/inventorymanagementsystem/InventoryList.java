package com.linkedlist.singlylinkedlist.inventorymanagementsystem;

class InventoryList {
    private Item head;

    public void addAtBeginning(Item newItem) {
        newItem.next = head;
        head = newItem;
    }

    public void addAtEnd(Item newItem) {
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    public void addAtPosition(int position, Item newItem) {
        if (position <= 1 || head == null) {
            addAtBeginning(newItem);
            return;
        }

        Item temp = head;
        for (int i = 1; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        newItem.next = temp.next;
        temp.next = newItem;
    }

    /* ================= REMOVE ================= */

    public void removeByItemId(int itemId) {
        if (head == null) return;

        if (head.itemId == itemId) {
            head = head.next;
            return;
        }

        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }


    public void updateQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
    }

    /* ================= SEARCH ================= */

    public Item searchById(int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) return temp;
            temp = temp.next;
        }
        return null;
    }

    public Item searchByName(String itemName) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) return temp;
            temp = temp.next;
        }
        return null;
    }


    public double calculateTotalInventoryValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        return total;
    }


    public void sortByName(boolean ascending) {
        head = mergeSort(head, (a, b) ->
                ascending ? a.itemName.compareToIgnoreCase(b.itemName)
                          : b.itemName.compareToIgnoreCase(a.itemName));
    }

    public void sortByPrice(boolean ascending) {
        head = mergeSort(head, (a, b) ->
                ascending ? Double.compare(a.price, b.price)
                          : Double.compare(b.price, a.price));
    }

    private Item mergeSort(Item node, java.util.Comparator<Item> comparator) {
        if (node == null || node.next == null) return node;

        Item middle = getMiddle(node);
        Item nextOfMiddle = middle.next;
        middle.next = null;

        Item left = mergeSort(node, comparator);
        Item right = mergeSort(nextOfMiddle, comparator);

        return sortedMerge(left, right, comparator);
    }

    private Item sortedMerge(Item a, Item b, java.util.Comparator<Item> comparator) {
        if (a == null) return b;
        if (b == null) return a;

        Item result;
        if (comparator.compare(a, b) <= 0) {
            result = a;
            result.next = sortedMerge(a.next, b, comparator);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, comparator);
        }
        return result;
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;

        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public void display() {
        Item temp = head;
        while (temp != null) {
            System.out.println(
                temp.itemId + " | " +
                temp.itemName + " | Qty: " +
                temp.quantity + " | Price: " +
                temp.price
            );
            temp = temp.next;
        }
    }
}

