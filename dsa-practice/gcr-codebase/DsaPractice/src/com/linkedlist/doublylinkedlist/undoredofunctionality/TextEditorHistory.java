package com.linkedlist.doublylinkedlist.undoredofunctionality;

class TextEditorHistory {
    private TextState head;
    private TextState tail;
    private TextState current;

    private int maxSize;
    private int size;

    public TextEditorHistory(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
    }


    public void addState(String content) {

        TextState newState = new TextState(content);

        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
            size = calculateSize();
        }

        if (head == null) {
            head = tail = current = newState;
            size = 1;
            return;
        }

        tail.next = newState;
        newState.prev = tail;
        tail = newState;
        current = newState;
        size++;

        if (size > maxSize) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }


    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("No more undo available.");
        }
    }


    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("No more redo available.");
        }
    }


    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.content);
        } else {
            System.out.println("Editor is empty.");
        }
    }


    private int calculateSize() {
        int count = 0;
        TextState temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
