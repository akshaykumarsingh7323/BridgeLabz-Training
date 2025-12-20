// Write a program to create a 2D Array and Copy the 2D Array into a single dimension array

import java.util.*;

public class MultiDimensionalArray{
    public static void main(String args []){

        Scanner kb = new Scanner(System.in);

	int rows = 4;
	int columns = 4;
	
	int arr [][] = new int [4][4];
	System.out.println("Enter numbers:");
	for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
	        arr[i][j] = kb.nextInt();
	    }
	}

	int brr [] = new int [4 * 4];
	int index = 0;
	for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
	        brr[index] = arr[i][j];
		index++;
	    }
	}

	for(int i = 0; i < brr.length; i++){
            System.out.print(brr[i] + " ");
	}
    }
}