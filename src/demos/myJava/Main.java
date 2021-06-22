package demos.myJava;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
	public static Scanner scanner= new Scanner(System.in);

	public static void main(String[] arg) {
//		BankAccount Suhacc = new BankAccount();
//		System.out.println("Account Detail: "+Suhacc);
//		Suhacc.withdraw(500);
//		Suhacc.deposit(200);
//		Suhacc.withdraw(600);
//		System.out.println("Final Account Detail: "+Suhacc);
		int[] inputArray = getIntegers(5);
		printArray(inputArray);
		printArray(sortedArray(inputArray));
		
	}
	public static int[] getIntegers(int size) {
		System.out.println("Enter "+ size+ " integer values :");
		int[] inputValues = new int[size];
		for(int i=0;i<size; i++) {
			inputValues[i]= scanner.nextInt();
		}
		return inputValues;
	}
	
	public static void printArray(int[] intArray) {
//		Stream<Integer> str= (Stream<Integer>) Arrays.asList(intArray);
//		str.forEach(System.out::println);
		for(int i=0;i<intArray.length; i++) {
			System.out.println("["+i+"]= "+intArray[i]);
		}		
	}
	public static int[] sortedArray(int[] intArray) {
		int[] sortedArray= Arrays.copyOf(intArray, intArray.length);
		Arrays.sort(sortedArray);
		return sortedArray;
	}
}
