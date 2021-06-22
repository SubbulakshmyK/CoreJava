package demos.myJava;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysSample {
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] arg) {
		
		System.out.println("Enter the number of integers: ");
		int numInts = scanner.nextInt();
		int minNum = finMin(getIntegers(numInts));
		System.out.println("Minumum value = "+minNum);
		
	}
	
	public static int[] getIntegers(int count) {
		System.out.println("Enter "+count+" integer values");
		int[] enteredValues = new int[count];
		for(int i=0; i<count; i++) {
			enteredValues[i]= scanner.nextInt();
		}
		System.out.println("Entered values = "+Arrays.toString(enteredValues));
		return enteredValues;
	}
	
	public static int finMin(int[] intValues) {
		int minValue=intValues[0];
		for(int i=1; i<intValues.length; i++) {
			if(minValue>intValues[i])
				minValue = intValues[i];
		}
		return minValue;
	}
}
