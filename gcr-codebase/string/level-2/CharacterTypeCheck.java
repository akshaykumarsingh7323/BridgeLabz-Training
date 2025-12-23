import java.util.*;

// Write a program to find vowels and consonants in a string and display the character type - Vowel, Consonant, or Not a Letter


public class CharacterTypeCheck{

    static String checkCharType(char ch){

        if(ch >= 'A' && ch <= 'Z'){
            ch = (char) (ch + 32);
        }

        if(ch >= 'a' && ch <= 'z'){

            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                return "Vowel";
            }else{
                return "Consonant";
            }
        }

        return "Not a Letter";
    }

    static String[][] findCharTypes(String text){

        String[][] result = new String[text.length()][2];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharType(ch);
        }

        return result;
    }

    static void displayTable(String[][] arr){

        System.out.println("\nCharacter\tType");
        System.out.println("------------------------");

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i][0] + "\t\t" + arr[i][1]);
        }
    }

    public static void main(String[] args){

        Scanner kb = new Scanner(System.in);

        System.out.println("Enter text:");
        String text = kb.nextLine();

        String[][] result = findCharTypes(text);
        displayTable(result);
    }
}
