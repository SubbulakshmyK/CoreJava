package demos.myJava.MovieBooking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Booking {
	
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] arg) {
		Theatre t1 = new Theatre("PVR", 10, 12);

		
		t1.reserveSeat("A04");
		t1.reserveSeat("B04");
//		t1.addSeat("A00", 10.0);
//		t1.addSeat("Z00", 10.0);
//		t1.addSeat("B00", 10.0);
//		t1.addSeat("AA0", 120.0);
		
		//Collections.sort(t1.getSeats(), Theatre.PRICE_ORDER);
		System.out.println(t1);
		
		bookTicket(t1);
		
		
		 //Change Theatre.Seat class as public to the below code to work
		/*
		 * List<Theatre.Seat> seatSCopy = new ArrayList<>(t1.getSeats());
		 * List<Theatre.Seat> seatDCopy = new ArrayList<>(t1.getSeats().size());
		 * System.out.println("======printing seatDCopy size==========="+seatDCopy.size(
		 * )); System.out.println("======printing t1.getSeats().size()==========="+t1.
		 * getSeats().size()); //Collections.copy(seatDCopy, t1.getSeats());
		 * printSeats(seatSCopy, t1.getSeatsPerRow()); Collections.shuffle(seatSCopy);
		 * //Collections.reverse(seatCopy);
		 * System.out.println("======printing Original===========");
		 * printSeats(t1.getSeats(), t1.getSeatsPerRow());
		 * System.out.println("======printing Shallow copy===========");
		 * printSeats(seatSCopy, t1.getSeatsPerRow());
		 * System.out.println("======printing Deep copy===========");
		 * printSeats(seatDCopy, t1.getSeatsPerRow());
		 */	 	
		
	}

	public static void bookTicket(Theatre t1) {

		String seatNum="";
		int option=0;
		while(true) {
			System.out.println("Welcome... Please select the option "
					+ " 1: Book Seat"
					+ " 2: Cancel Seat"
					+ " 3: Print Seat"
					+ " 4: Quiit");
			option = sc.nextInt();
			sc.nextLine();			
			switch(option) {
			case 1:
					System.out.println("Enter Seat number for booking: ");
					seatNum = sc.nextLine();
					t1.reserveSeat(seatNum);
					break;
			case 2:
					System.out.println("Enter Seat number for Cancel: ");
					seatNum = sc.nextLine();
					t1.cancelSeat(seatNum);
					break;
			case 3:
					System.out.println("\n"+ t1.printSeats());
					break;
			case 4: 
			default:
					System.out.println("Thank you.. ");
					return;
			}
		}
	}
	
	 //Change Theatre.Seat class as public to the below code to work
	/*
	 * public static void printSeats(List<Theatre.Seat> list, int seatsPerRow) { int
	 * i=0; for(Theatre.Seat s : list) { if(s.isBooked())
	 * System.out.print(s.getSeatName()+"[B]\t"); else
	 * System.out.print(s.getSeatName()+"[A]\t"); i++; if(i%seatsPerRow ==0)
	 * System.out.println(); } }
	 */
	  
	  
	  
	 
}
