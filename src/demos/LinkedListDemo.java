package demos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListDemo {
	public static void main(String[] arg) {
		
		LinkedList<String> cities = new LinkedList<String>();
		
		addInOrder(cities, "Sydney");
		addInOrder(cities, "Brisbane");
		addInOrder(cities, "Adilaide");
		addInOrder(cities, "Perth");
		addInOrder(cities, "Melbourne");
		addInOrder(cities, "Canbrra");
		addInOrder(cities, "Darwin");
		prinList(cities);
		
	}

	private static boolean addInOrder(LinkedList<String> llist, String newEntry) {
		//boolean inserted=false;
		ListIterator<String> li = llist.listIterator();
		int comparison=0;
		while(li.hasNext()) {
			comparison = li.next().compareTo(newEntry);
			if(comparison==0) {
				System.out.println("City already added.");
				return false;
			}
			else if(comparison>0) {
				li.previous();
				li.add(newEntry);
				return true;
			}
		}
		li.add(newEntry);
		return true;
	}
	
	private static void prinList(LinkedList<String> llist) {
		Iterator<String> itr = llist.iterator();
		while(itr.hasNext())
			System.out.println("Visiting City ==> "+itr.next());
	}
}
