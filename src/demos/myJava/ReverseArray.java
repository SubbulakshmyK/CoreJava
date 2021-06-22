package demos.myJava;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] arg) {
		
		System.out.println("Enter the number of integers: ");
		int numInts = scanner.nextInt();
		int[] intArray = getIntegers(numInts);		
		System.out.println("Entered values = "+Arrays.toString(intArray));
		int[] reversedArray = reverseArray(intArray);
		System.out.println("Reversed values = "+Arrays.toString(reversedArray));
		reverseArrayEff(intArray);

	}

	public static int[] getIntegers(int count) {
		System.out.println("Enter "+count+" integer values");
		int[] enteredValues = new int[count];
		for(int i=0; i<count; i++) {
			enteredValues[i]= scanner.nextInt();
		}
		return enteredValues;
	}
	public static int[] reverseArray(int[] array) {
		int count =array.length;
		int[] reversedArray = new int[count];
		int rindex=count;
		for(int i=0; i<count; i++) {
			reversedArray[--rindex]= array[i];
		}
		return reversedArray;
	}
	public static int[] reverseArrayEff(int[] array) {
		int maxIndex =array.length-1;
		int halfLength =array.length/2;
		int temp=0;
		for(int i=0; i<halfLength; i++) {
			temp =array[i];
			array[i] = array[maxIndex-i];
			array[maxIndex-i]= temp;
		}
		System.out.println("Reversed Effecient values = "+Arrays.toString(array));
		return array;
	}
}
