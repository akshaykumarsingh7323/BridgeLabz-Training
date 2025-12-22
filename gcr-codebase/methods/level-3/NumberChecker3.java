public class NumberChecker3{

    public static int countDigits(int number){
        int count = 0;
        while (number != 0){
            count++;
            number /= 10;
        }
        return count;
    }

    public static int[] getDigitsArray(int number){
        int count = countDigits(number);
        int[] digits = new int[count];

        for(int i = count - 1; i >= 0; i--){
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    public static int[] reverseArray(int[] digits){
        int[] reverse = new int[digits.length];
        int j = 0;

        for(int i = digits.length - 1; i >= 0; i--){
            reverse[j++] = digits[i];
        }
        return reverse;
    }

    public static boolean compareArrays(int[] arr1, int[] arr2){
        if(arr1.length != arr2.length){
            return false;
        }

        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int[] digits){
        int[] reversed = reverseArray(digits);
        return compareArrays(digits, reversed);
    }

    public static boolean isDuckNumber(int[] digits){
        for(int d : digits){
            if(d != 0){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){

        int number = 1221;
        System.out.println("Number: " + number);

        int[] digits = getDigitsArray(number);

        System.out.print("Digits Array: ");
        for(int d : digits){
            System.out.print(d + " ");
        }
        System.out.println();

        int[] reversedDigits = reverseArray(digits);
        System.out.print("Reversed Digits Array: ");

        for(int d : reversedDigits){
            System.out.print(d + " ");
        }
        System.out.println();

        System.out.println("Are Arrays Equal: " + compareArrays(digits, reversedDigits));
        System.out.println("Is Palindrome Number: " + isPalindrome(digits));
        System.out.println("Is Duck Number: " + isDuckNumber(digits));
    }
}
