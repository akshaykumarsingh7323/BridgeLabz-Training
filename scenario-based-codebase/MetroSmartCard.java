import java.util.*;

public class MetroSmartCard{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        double balance = 200;
        char choice;

        System.out.println("Initial Smart Card Balance: Rs " + balance);

        while(balance > 0){

            System.out.print("\nEnter distance travelled (in km): ");
            int distance = sc.nextInt();

            double fare = (distance <= 5) ? 20 : (distance <= 15) ? 40 : 60;

            if(fare <= balance){
               balance = balance - fare;
               System.out.println("Fare deducted: Rs " + fare);
               System.out.println("Remaining balance: Rs " + balance);
            }else{
               System.out.println("Insufficient balance!");
               break;
            }

            if(balance <= 0){
               System.out.println("Balance exhausted. Please recharge!");
               break;
            }

            System.out.print("Do you want to continue? (y/n): ");
            choice = sc.next().charAt(0);

            if(choice == 'n' || choice == 'N'){
                break;
            }
        }

        System.out.println("\nThank you for using Delhi Metro");
    }
}
