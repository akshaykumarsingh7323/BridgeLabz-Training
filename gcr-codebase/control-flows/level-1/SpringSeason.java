// This class will check whether the given month and day fall in spring season or not

public class SpringSeason{
    public static void main(String args []){
	
	// It take input through command line argument and check Display the spring season or not 

	int month = Integer.parseInt(args[0]);

	int day = Integer.parseInt(args[1]);

	if(month == 3 && day >= 20) || (month == 4) || (month == 5) || (month == 6 && day <=20){

	    System.out.println("Its a spring season"); 

        } else{

	    System.out.println("Not a spring season");

	}
    }
}