/*
 School Bus Attendance System 
 Track 10 students' presence.
  Use for-each loop on names.
  Ask "Present or Absent?"
  Print total present and absent counts.
*/

import java.util.*;

// create class to check presence of student
public class BusAttendance{
    public static void main(String args []){

	Scanner sc = new Scanner(System.in);
	String name [] = {"Akshay", "Avinash", "Ram", "Shyam", "Deepanshu", "Priyanshu", "Pankaj", "Pranay", "Akash", "Amit"};
	char status [] = new char [name.length];
	int present = 0;
	int absent = 0;

	System.out.println("\nEnter \"P\" for present and \"A\" for absent");
	
	// checking status for presence
	for(int i = 0; i < name.length; i++){
	   System.out.println("\nIs " + name[i] + " Present or Absent ? ");
	   char ch = sc.next().trim().toLowerCase().charAt(0);

	   while(!(ch == 'p') && !(ch == 'a')){
		System.out.println("Invalid Choice!!!!, Please enter Present or Absent only: ");
                ch = sc.next().trim().toLowerCase().charAt(0);
           }
		 
	   if(ch == 'p'){
	      status[i] = ch;
	      present++;
	   }else{
	      status[i] = ch;
	      absent++;
	   }
	}

	System.out.println("\n------Attendence Summary------\n");
	for(int i = 0; i < 10; i++){
	    if(status[i] == 'p'){
	        System.out.println(name[i] + " -> Present");	
	    }else{
		System.out.println(name[i] + " -> Absent");
	    }
	}  

	System.out.println("\nTotal Present: " + present);
	System.out.println("\nTotal Absent: " + absent); 
    }
}