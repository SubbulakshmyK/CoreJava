package demos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*Given an array of elements and change the array in such a way that all the elements on 
the array are distinct. 
if you are replacing a value, then the replacing value should be great than the previous 
value and after modification 
sum of the elements should be as less as possible. 
Example: arr[1, 2, 3, 4, 5, 5, 5] and the result should be [1, 2, 3, 4, 5, 6, 7] 
example 2 [1, 2, 5, 7, 8, 8, 7] then the result should be [1, 2, 5, 7, 8, 9, 10] or 1, 2, 5, 7, 8, 10, 9]	
*/

/*Given a square matrix mat[][] of size N x N. The task is to rotate it by 
 * 90 degrees in anti-clockwise direction without using any extra space.
 * Testcase 1: Matrix is as below:
 * 
 */



public class Logicals {

	public static void main(String[] args) {

		/*
		 * 
		int findFreqArr[]= {1,2,3,4,2,6,4,6,7,8,7,9,34,34};
		findRepeats(findFreqArr);
		 * */
		 /*
		int[] stockPrices = {100, 80, 60, 70, 60, 75, 85};
		printArray(stockPrices);		  * 
  		int[] spanDtls=stockSpan(stockPrices); printArray(spanDtls);
		 */
		
		/* - convert matrix to 90/180 Degree
		int iMatrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
		int Matrix90[][] = convertMatrix90(iMatrix);
		int Matrix180[][] = convertMatrix180(iMatrix);
		System.out.println("====Matrix===>");
		print2DArray(iMatrix)
		System.out.println("====Rearranged 90 Matrix===>");
		print2DArray(Matrix90);
		System.out.println("====Rearranged 180 Matrix===>");
		print2DArray(Matrix180);
		*/
		int mainArray[]= {1,4,7,9,12,34,56};
		int subAray[]= {56,7,1};
		printArray(mainArray);
		printArray(subAray);
		System.out.println("is SubSet =>"+isSubSet(mainArray, subAray));
		
	}
	
	public static int[][] convertMatrix90(int iMatrix[][]) {
		
		int row=iMatrix.length;
		int col=iMatrix[row-1].length;
		int iMatrix2[][] = new int[col][row];
		for (int row1 = 0; row1 < row; row1++) {
			for (int col1 = 0; col1 < iMatrix[row1].length; col1++) {
				iMatrix2[--col][row1] = iMatrix[row1][col1];
			}
			col=iMatrix[row-1].length;
		}
		return iMatrix2;
	}
	
	public static int[][] convertMatrix180(int iMatrix[][]) {
		
		int row=iMatrix.length;
		int col=iMatrix[row-1].length;
		int iMatrix2[][] = new int[col][row];
		for (int row1 = 0; row1 < iMatrix.length; row1++) {
			for (int col1 = 0; col1 < iMatrix[row1].length; col1++) {
				iMatrix2[row-1][--col] = iMatrix[row1][col1];
			}
			row--;
			col=iMatrix[row1].length;
		}
		return iMatrix2;
	}
	
	public static void findRepeats(int[] findFreq) {	
		HashMap<Integer, Integer> freqElements= new HashMap<Integer, Integer>();
		int count=1;
		System.out.print("Array===>{");
		for(int i=0; i<findFreq.length; i++) {
			System.out.print(findFreq[i]+" ,");
			
			for(int j=i+1; j<findFreq.length; j++) {
				
				if( findFreq[i]== findFreq[j]) {
					count=2;
					if(freqElements.containsKey(findFreq[i])) {
						count = freqElements.get(findFreq[i])+1;
					}
					freqElements.put(findFreq[i], count);
				}
			}
			
		}
		System.out.println("}");
		System.out.println("Elements Frequency===>"+freqElements);
	}
	
	public static int[] stockSpan(int[] stockPrice) {
		int[] stockSpanDtls = new int[stockPrice.length];
		//int current, span=1, prevPeak =0, prevValue=0;
		stockSpanDtls[0]=1;
		for(int i=1; i<stockPrice.length; i++) {
			stockSpanDtls[i]=1;
			for(int j=i-1; j>0; j--) {
				if(stockPrice[j]<=stockPrice[i])
					++stockSpanDtls[i];
			}
		}
		return stockSpanDtls;
	}
	public static void print2DArray(int[][] arrPrint) {
		for(int row=0; row < arrPrint.length; row++ ) {		
			for(int col=0 ; col<arrPrint[row].length; col++) {
				System.out.print(arrPrint[row][col]+"  ");
			}
			System.out.println("");
		}
	}
	public static void printArray(int[] arrPrint) {
		for(int row=0; row < arrPrint.length; row++ ) {		
			System.out.print(arrPrint[row]+"  ");
		}
		System.out.println("");
	}
	
	public static boolean isSubSet(int[] mainArray, int[] subArray) {
		boolean subset=false;
		for(int si=0; si<subArray.length; si++) {
			for(int mi=0; mi<mainArray.length; mi++) {
				if(subArray[si] == mainArray[mi]) {
					subset =true;
					break;
				}
				else
					subset=false;
			}
		}
		return subset;
	}
}
