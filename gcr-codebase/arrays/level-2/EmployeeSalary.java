import java.util.*;
public class EmployeeSalary{
    public static void main(String args []){

	Scanner kb = new Scanner(System.in);

	double totalOldSalary = 0;
	double totalBonus = 0;
	double totalNewSalary = 0;

	double salary [] = new double [10];
	System.out.println("Enter salary of 10 employee: ");
	for(int i = 0; i<salary.length; i++){
              double sal = kb.nextDouble();
	      if(sal < 0){
	         System.out.println("Invalid number!, use to enter again");
		 i--;
	       }else{
		 salary[i] = sal;
		 totalOldSalary = totalOldSalary + sal;
	       }    
	}

	double services [] = new double [10];
	System.out.println("Enter years of services of employee: ");
	for(int i = 0; i<services.length; i++){
	    double ser = kb.nextDouble();
	    if(ser < 0){
	       System.out.println("Invalid service years!, use to enter again");
		i--;
	     }else{
	       services[i] = ser;
	     }
	}

	double bonusAmount [] = new double [10];
	for(int i = 0; i<salary.length; i++){
            if(services[i] >= 5){
	       bonusAmount[i] = salary[i] * 5 / 100 ;
		totalBonus = totalBonus + bonusAmount[i];
	    }else{
	       bonusAmount[i] = salary[i] * 2 / 100;
	         totalBonus = totalBonus + bonusAmount[i];
	    }
	}

	double newSalary [] = new double [10];
	for(int i = 0; i<services.length; i++){
	    newSalary[i] = salary[i] + bonusAmount[i];
	}

	System.out.println("Total old salary is: "+ totalOldSalary);
	System.out.println("Total bonus is: "+ totalBonus);

	System.out.println("New Salary of each employee: ");
	
	for(int i = 0; i<services.length; i++){
	    System.out.println(newSalary[i]);
	}

	
    }
}