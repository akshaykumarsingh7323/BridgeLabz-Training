package com.linkedlist.doublylinkedlist.undoredofunctionality;

public class UseTextEditor {
    public static void main(String[] args) {

        TextEditorHistory editor = new TextEditorHistory(10);

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.addState("Hello World! Welcome");

        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();

        editor.addState("Hello World! Welcome to Java");
        editor.displayCurrentState();

        editor.redo(); 
    }
}
