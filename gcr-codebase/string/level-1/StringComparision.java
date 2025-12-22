import java.util.*;


// writing program to compare two string 
public class StringComparision{
   
    static boolean compareUsingCharAt(String str1, String str2){
	if(str1.length() != str2.length()) return false;
        
	for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)) return false;
	}
	return true;
    }

    static boolean compareUsingEquals(String str1, String str2){
	if(str1.equals(str2)) return true;
        else return false;	
    }
    public static void main(String args []){

	Scanner kb = new Scanner(System.in);

        System.out.println("Enter first String:");
        String str1 = kb.next();

	System.out.println("Enter second String:");
        String str2 = kb.next();

	boolean result1 = compareUsingCharAt(str1, str2);
        boolean result2 = compareUsingEquals(str1, str2);

	if(result1 == result2){
	   System.out.println("Both comparision are same"); 
	}else{
	   System.out.println("Both comparision are different");
	}	
    }
}




