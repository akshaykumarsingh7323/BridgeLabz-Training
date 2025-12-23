import java.util.*;

class UniqueCharacters {

    public static int findLength(String text){
        int count = 0;
        try{
            while(true){
               text.charAt(count);
               count++;
            }
        } catch(IndexOutOfBoundsException e){
        }
        return count;
    }

    public static char[] findUniqueCharacters(String text){
        int length = findLength(text);

        char[] temp = new char[length];
        int uniqueCount = 0;

        for(int i = 0; i < length; i++){
            char current = text.charAt(i);
            boolean isUnique = true;

            for(int j = 0; j < i; j++) {
                if(current == text.charAt(j)){
                    isUnique = false;
                    break;
                }
            }

            if(isUnique){
                temp[uniqueCount] = current;
                uniqueCount++;
            }
        }

        char[] result = new char[uniqueCount];
        for(int i = 0; i < uniqueCount; i++){
            result[i] = temp[i];
        }

        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        char[] uniqueChars = findUniqueCharacters(text);

        System.out.println("Unique characters are:");
        for (int i = 0; i < uniqueChars.length; i++) {
            System.out.print(uniqueChars[i] + " ");
        }
    }
}
