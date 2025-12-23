// Write a program to find the frequency of characters in a string using the charAt() method and display the result


import java.util.*;

class CharacterFrequency{

    public static int[][] findCharacterFrequency(String text) {

        int[] freq = new int[256];

        for(int i = 0; i < text.length(); i++){
           char ch = text.charAt(i);
           freq[ch]++;
        }

        int uniqueCount = 0;
        for(int i = 0; i < text.length(); i++){
            if(freq[text.charAt(i)] != 0){
               uniqueCount++;
               freq[text.charAt(i)] = 0;
            }
        }

        for(int i = 0; i < text.length(); i++){
           char ch = text.charAt(i);
           freq[ch]++;
        }

        int[][] result = new int[uniqueCount][2];
        int index = 0;

        for(int i = 0; i < text.length(); i++){
            char ch = text.charAt(i);

            if(freq[ch] != -1){
               result[index][0] = ch;   
               result[index][1] = freq[ch];
               index++;
               freq[ch] = -1; 
            }
        }

        return result;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();

        int[][] frequency = findCharacterFrequency(text);

        System.out.println("Character Frequency:");
        for (int i = 0; i < frequency.length; i++) {
            System.out.println((char) frequency[i][0] + " : " + frequency[i][1]);
        }
    }
}
