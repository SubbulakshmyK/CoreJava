package demos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.IntStream;


public class CollectionsByte {
	
	public static void main(String args[]) {
		//List subtraction
		 
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(13);
		list1.add(13);
		list1.add(4);
		list1.add(4);
		
		list2.add(1);
		list2.add(2);
		list2.add(13);
		list2.add(4);
		

		//BiConsumer< Integer, List<Integer>> bc =(i, list)-> list.remove(list1.indexOf(i));
		
		//Stream<Integer> matchStream = list1.stream();//.allMatch(i->list2.contains(i));
		System.out.println("List 1 ===>"+list1+"& list2===>"+list2);
		list2.stream().forEach(i->list1.remove(list1.indexOf(i)));
		//list2.stream().forEach(bc.accept(i, list1));
		System.out.println("List 1 remaining===>"+list1);
		
	}
	
	List<Integer> sumOfIndex(List<Integer> numlist, int target){
		return numlist;
	}

	

}
