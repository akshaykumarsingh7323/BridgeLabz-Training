import java.util.Scanner;
public class MaximumOfThree {

    private static int[] takeInput(){
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[3];

        System.out.print("Enter first number : ");
        numbers[0] = sc.nextInt();

        System.out.print("Enter second number : ");
        numbers[1] = sc.nextInt();

        System.out.print("Enter third number : ");
        numbers[2] = sc.nextInt();
        return numbers;
    }

    private static int findMaximum(int[] nums){
        int max = nums[0];

        if(nums[1] > max){
            max = nums[1];
        }

        if(nums[2] > max){
            max = nums[2];
        }
        return max;
    }

    public static void main(String[] args){
        int[] numbers = takeInput();
        int max = findMaximum(numbers);

        System.out.println("Maximum number is : " + max);
    }
}