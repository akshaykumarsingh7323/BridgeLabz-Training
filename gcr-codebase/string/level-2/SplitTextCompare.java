import java.util.*;

// writing a program to split a text by built-in methid and user define method and compare them

public class SplitTextCompare{

    static int findLength(String text){
        int count = 0;
        try {
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
        int idx = 1;
        spaceIndex[0] = -1;
        spaceIndex[wordCount] = len;

        for(int i = 0; i < len; i++){
            if(text.charAt(i) == ' '){
                spaceIndex[idx++] = i;
            }
        }

        String[] words = new String[wordCount];

        for(int i = 0; i < wordCount; i++){
            String word = "";
            for(int j = spaceIndex[i] + 1; j < spaceIndex[i + 1]; j++){
                word = word + text.charAt(j);
            }
            words[i] = word;
        }

        return words;
    }

    static boolean compareArrays(String[] a, String[] b){

        if(a.length != b.length)
            return false;

        for(int i = 0; i < a.length; i++){
            if(!a[i].equals(b[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args){

        Scanner kb = new Scanner(System.in);

        System.out.println("Enter complete text:");
        String text = kb.nextLine();

        String[] userWords = splitText(text);
        String[] builtInWords = text.split(" ");

        boolean result = compareArrays(userWords, builtInWords);

        System.out.println("\nWords using user method:");
        for(String w : userWords){
            System.out.println(w);
        }

        System.out.println("\nWords using split():");
        for(String w : builtInWords){
            System.out.println(w);
        }

        System.out.println("\nAre both results same? " + result);
    }
}
