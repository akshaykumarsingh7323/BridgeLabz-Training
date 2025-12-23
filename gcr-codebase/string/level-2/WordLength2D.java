// Write a program to split the text into words and return the words along with their lengths in a 2D array

import java.util.*;

public class WordLength2D{

    static int findLength(String text){
        int count = 0;
        try{
            while (true){
                text.charAt(count);
                count++;
            }
        }catch (Exception e){
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

        String[][] result = new String[words.length][2];

        for(int i = 0; i < words.length; i++){
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }

        return result;
    }

    public static void main(String[] args){

        Scanner kb = new Scanner(System.in);

        System.out.println("Enter complete text:");
        String text = kb.nextLine();

        String[] words = splitText(text);
        String[][] wordLength = createWordLengthArray(words);

        System.out.println("\nWord\tLength");
        System.out.println("---------------");

        for(int i = 0; i < wordLength.length; i++){
            int len = Integer.parseInt(wordLength[i][1]);
            System.out.println(wordLength[i][0] + "\t" + len);
        }
    }
}
