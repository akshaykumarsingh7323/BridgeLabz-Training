package com.undoredofunctionality;

import java.util.Scanner;

public class UseTextEditor {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

        TextEditor editor = new TextEditor();
        System.out.println("Enter how much text you want to add : ");
        int num  =  sc.nextInt();
        
        System.out.println("Enter text: ");
        for (int i = 0; i < num; i++) {
        	editor.insert(sc.next()+" ");
        }

        editor.display();

        editor.delete(5);
        editor.display();

        editor.undo();
        editor.display();

        editor.redo();
        editor.display();
    }
}
