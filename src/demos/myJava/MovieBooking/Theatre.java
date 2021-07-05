package demos.myJava.MovieBooking;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Theatre {
	private final String Name;
	private int noOfRows;
	private int seatsPerRow;
	private List<Seat> seats ;
	
	static final Comparator<Seat> PRICE_ORDER;
	static {
		PRICE_ORDER = new Comparator<Seat>() {

			@Override
			public int compare(Seat s1, Seat s2) {
				if(s1.price < s2.price)
					return -1;
				else if(s1.price > s2.price)
					return 1;
				else 
					return s1.seatName.compareToIgnoreCase(s2.seatName);
			}
		};
	}
	
	private class Seat implements Comparable<Seat>{
		private String seatName;
		private double price;
		private boolean booked=false;
		
		public Seat(String seatname, double price) {
			this.seatName = seatname;
			this.price = price;
		}
		
		public String getSeatName() {
			return seatName;
		}

		public void setSeatName(String seatName) {
			this.seatName = seatName;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public boolean isBooked() {
			return booked;
		}

		public void setBooked(boolean booked) {
			this.booked = booked;
		}

		@Override
		public String toString() {
			return seatName ;
		}
		@Override
		public int compareTo(Seat s) {
			return this.seatName.compareToIgnoreCase(s.seatName);
		}
		
		public boolean reserve() {
			this.booked=true;
			return this.booked;
		}
		
		public boolean cancel() {
			this.booked = false;
			return true;
		}
		
	}

	public int getNoOfRows() {
		return noOfRows;
	}
	public void setNoOfRows(int noOfRows) {
		this.noOfRows = noOfRows;
	}
	public List<Seat> getSeats() {
		return seats;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	public String getName() {
		return Name;
	}
	
	public int getSeatsPerRow() {
		return seatsPerRow;
	}
	public void setSeatsPerRow(int seatsPerRow) {
		this.seatsPerRow = seatsPerRow;
	}
	public Theatre(String name, int noOfRows, int seatsPerRow) {
		super();
		Name = name;
		this.noOfRows = noOfRows;
		this.seatsPerRow = seatsPerRow;
		this.seats = new LinkedList<Theatre.Seat>();
		addSeats(noOfRows, seatsPerRow);
		
	}
	private void addSeats(int rows, int seatsCount) {
		int lastRow='A'+rows-1;
		Seat seat=null;
		double price = 100.0;
		for(char row='A'; row<=lastRow; row++) {
			for(int s=1; s<=seatsCount; s++) {
				if(row <'D' )
					price = 120.0;
				else if(row>'H') {
					if(s<=4 || s>=9)
						price = 60.0;
					else
						price = 80.0;
				}
				else if(row <= 'H' && (s<4 || s>9))
					price=80.0;
				else
					price=100;
				seat = new Seat(row + String.format("%02d", s), price);
				this.seats.add(seat);
			}
		}
	}
	public void addSeat(String seatName, double price) {
		Seat s1= new Seat (seatName, price);
		this.seats.add(s1);
		
	}
	public boolean reserveSeat(String seatNum) {
		boolean booked=false;
		Seat reqSeat = new Seat(seatNum, 0);
		int index=Collections.binarySearch(this.seats, reqSeat, null);
		if(index >=0 && !this.seats.get(index).booked){
			System.out.println(seatNum + " is Reserved. Please proceed to pay...");
			return seats.get(index).reserve();
		}
		else {
			System.out.println(seatNum + " is not available to reserve. Try another seat.");
			return booked;
		}
	}


	public boolean cancelSeat(String seatNum) {
		boolean cancelled=false;
		Seat reqSeat = new Seat(seatNum, 0);
		int index=Collections.binarySearch(this.seats, reqSeat, null);;
		if(index >=0 && this.seats.get(index).booked){
			System.out.println(seatNum + " is cancelled");
			cancelled= seats.get(index).cancel();
		}
		else {
			System.out.println(seatNum + " is not available to cancel. Try another seat.");
		}
		return cancelled;
	}
	
	public int findSeat(String seatNum) {
		int low=0;
		int high = this.seats.size()-1;
		int mid=0, cmp=-1;
		Seat rSeat=null;
		while(low<=high) {
			mid=(low + high)/2;
			rSeat = this.seats.get(mid);
			cmp = rSeat.getSeatName().compareTo(seatNum);
			if(cmp<0) 
				low = mid+1;
			else if (cmp>0)
				high = mid-1;
			else
				return mid;
		}
		return -1;
	}
	
	@Override
	public String toString() {
		return "Theatre [Name=" + Name + ", noOfRows=" + noOfRows + ", seats= \n" 
				+ printSeats()  + "]";
	}
	
	public String printSeats() {
		String seats="", booked="";
		int i=0;
		//for(int i=0; i<this.seats.size(); i++) {
			for(Seat s : this.seats) {
				if(s.booked)
					booked="[B-";
				else
					booked ="[A-";
				seats= seats+"\t"+s+booked+s.price+"]";
				i++;
				if(i%this.seatsPerRow ==0)
					seats = seats+"\n";
			}
		//}
		return seats;
	}
	
	
}
