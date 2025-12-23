// Write a Java program to remove all occurrences of a specific character from a string

import java.util.*;

public class RemoveCharacter{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String str = sc.nextLine();

        System.out.print("Enter the character to remove: ");
        char removeChar = sc.next().charAt(0);

        String result = "";

        for(int i = 0; i < str.length(); i++){
           char ch = str.charAt(i);

            if(ch != removeChar){
                result += ch;
            }
        }

        System.out.println("Modified String: \"" + result + "\"");
    }
}
