// Write a program to find the frequency of characters in a string using unique characters and display the result

import java.util.*;

class CharacterFrequencyUsingUnique{

    public static char[] uniqueCharacters(String text){

        int length = text.length();
        char[] temp = new char[length];
        int count = 0;

        for(int i = 0; i < length; i++){
            char current = text.charAt(i);
            boolean isUnique = true;

            for(int j = 0; j < i; j++){
                if(current == text.charAt(j)){
                    isUnique = false;
                    break;
                }
            }

            if(isUnique){
                temp[count] = current;
                count++;
            }
        }

        char[] unique = new char[count];
        for(int i = 0; i < count; i++){
           unique[i] = temp[i];
        }

        return unique;
    }

    public static String[][] findFrequency(String text){

        int[] freq = new int[256]; 
        for(int i = 0; i < text.length(); i++){
           freq[text.charAt(i)]++;
        }

        char[] uniqueChars = uniqueCharacters(text);

        String[][] result = new String[uniqueChars.length][2];

        for(int i = 0; i < uniqueChars.length; i++){
           result[i][0] = String.valueOf(uniqueChars[i]); 
           result[i][1] = String.valueOf(freq[uniqueChars[i]]);
        }

        return result;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();

        String[][] frequency = findFrequency(text);

        System.out.println("Character Frequency:");
        for (int i = 0; i < frequency.length; i++){
            System.out.println(frequency[i][0] + " : " + frequency[i][1]);
        }
    }
}

