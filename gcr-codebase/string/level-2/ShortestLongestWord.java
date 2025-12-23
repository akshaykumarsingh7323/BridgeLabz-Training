// Write a program to split the text into words and find the shortest and longest strings in a given text

import java.util.*;

public class ShortestLongestWord{

    static int findLength(String text){
        int count = 0;
        try{
            while (true) {
                text.charAt(count);
                count++;
            }
        }catch (Exception e) {//*
        }
        return count;
    }

    static String[] splitText(String text){

        int len = findLength(text);
        int wordCount = 1;

        for(int i = 0; i < len; i++){
            if (text.charAt(i) == ' ')
                wordCount++;
        }

        int[] spaceIndex = new int[wordCount + 1];
        spaceIndex[0] = -1;
        spaceIndex[wordCount] = len;

        int idx = 1;
        for(int i = 0; i < len; i++){
            if (text.charAt(i) == ' ')
                spaceIndex[idx++] = i;
        }

        String[] words = new String[wordCount];

        for(int i = 0; i < wordCount; i++){
            String w = "";
            for(int j = spaceIndex[i] + 1; j < spaceIndex[i + 1]; j++){
                w = w + text.charAt(j);
            }
            words[i] = w;
        }

        return words;
    }

    static String[][] createWordLengthArray(String[] words){

        String[][] arr = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            arr[i][0] = words[i];
            arr[i][1] = String.valueOf(findLength(words[i]));
        }

        return arr;
    }

    static int[] findShortestLongest(String[][] arr){

        int min = Integer.parseInt(arr[0][1]);
        int max = Integer.parseInt(arr[0][1]);
        int minIndex = 0;
        int maxIndex = 0;

        for(int i = 1; i < arr.length; i++){
            int len = Integer.parseInt(arr[i][1]);

            if(len < min){
                min = len;
                minIndex = i;
            }

            if(len > max){
                max = len;
                maxIndex = i;
            }
        }

        return new int[] { minIndex, maxIndex };
    }

    public static void main(String[] args){

        Scanner kb = new Scanner(System.in);

        System.out.println("Enter complete text:");
        String text = kb.nextLine();

        String[] words = splitText(text);
        String[][] wordLength = createWordLengthArray(words);
        int[] result = findShortestLongest(wordLength);

        System.out.println("\nWord\tLength");
        System.out.println("----------------");

        for(int i = 0; i < wordLength.length; i++){
            System.out.println(wordLength[i][0] + "\t" + wordLength[i][1]);
        }

        System.out.println("\nShortest word: " + wordLength[result[0]][0]);
        System.out.println("Longest word: " + wordLength[result[1]][0]);
    }
}
