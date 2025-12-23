// Write a program to find vowels and consonants in a string and display the count of  Vowels and Consonants in the string

import java.util.*;

public class VowelConsonantCount{

    static String checkChar(char ch){

        if (ch >= 'A' && ch <= 'Z'){
            ch = (char) (ch + 32);
        }

        if (ch >= 'a' && ch <= 'z') {

            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
               return "Vowel";
            }else{
               return "Consonant";
            }
        }

        return "Not a Letter";
    }

    static int[] findVowelsConsonants(String text){

        int vowelCount = 0;
        int consonantCount = 0;

        for(int i = 0; i < text.length(); i++){

            char ch = text.charAt(i);
            String result = checkChar(ch);

            if (result.equals("Vowel"))
                vowelCount++;
            else if (result.equals("Consonant"))
                consonantCount++;
        }

        return new int[] {vowelCount, consonantCount};
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text:");
        String text = sc.nextLine();

        int[] count = findVowelsConsonants(text);

        System.out.println("\nVowel count: " + count[0]);
        System.out.println("Consonant count: " + count[1]);
    }
}
