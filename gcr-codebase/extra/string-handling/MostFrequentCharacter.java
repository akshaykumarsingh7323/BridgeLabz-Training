// Write a Java program to find the most frequent character in a string.

import java.util.*;

public class MostFrequentCharacter{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        int[] freq = new int[256];
        for(int i = 0; i < str.length(); i++){
           char ch = str.charAt(i);
           freq[ch]++;
        }

        char mostFrequent = ' ';
        int maxCount = 0;

        for(int i = 0; i < str.length(); i++){
           char ch = str.charAt(i);

            if(freq[ch] > maxCount){
                maxCount = freq[ch];
                mostFrequent = ch;
            }
        }

        System.out.println("Most Frequent Character: '" + mostFrequent + "'");
    }
}
