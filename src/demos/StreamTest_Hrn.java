package demos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;




public class StreamTest_Hrn {
	
	//--- 31/08/2021--
	//Harmon 1 --> int[] numbers={12,4,0,1,5,13,5,4,0,12,6,15,7,14}; // Using Java 8 Streams perform the below operations 
	// 1. Find the unique elements from the Array 
	// 2. Sort the unique elements in descending order 
	// 3. Save the top 3 values to a List<Integer> from the sorted values
	
	/*Harmon  2-> Given an array nums, write a function to move all 0’s to the end of it while maintaining 
	the relative order of the non-zero elements. For example, given nums = [0, 1, 0, 12, 3], after calling your 
	function, nums should be [1, 12, 3, 0, 0].*/
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(0, 1, 0, 12, 3);
		Stream<Integer> strm1 = list.stream();
		List<Integer> uniq1 = strm1.distinct().collect(Collectors.toList());
		System.out.println("===uniq1===>"+uniq1);
		uniq1 = uniq1.stream().sorted((i,j)->(i<j?1:-1)).collect(Collectors.toList());
		System.out.println("===uniq1 Desc===>"+uniq1);
		uniq1.stream().limit(3).forEach(System.out::println);
		List<Integer> list1 = Arrays.asList(0, 1, 0, 12, 3);
		list1= rearrange(list1);
		System.out.println("===list1===>"+list1);
		
	}
	
	public static List<Integer> rearrange(List<Integer> list1){
		List<Integer> list2 = new ArrayList<Integer>( list1);
		for(int i : list1 ) {
			if(i==0 ) {
				list2.remove(list2.indexOf((i)));
				list2.add(i);
			}
		
		}
		return list2;
	}

}
