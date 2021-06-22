package demos.myJava;

public class SpeedConverter {
	
	public static void main(String[] arg) {
		printCovertion(-54.89);
		
	}
	
	public static int toMilesPerHr(double km) {
		int milesPerHr=0;
		double milesConv = 1.609d;//, miles=0;
		if(km<0)
			return -1;
		else {
			milesPerHr = (int) Math.round(km / milesConv);
		}
		return milesPerHr;
	}
	
	public static void printCovertion(double km) {
		
		if(km <0)
			System.out.println("Invalid Value");
		else
			System.out.println(km+ " km/h = "+toMilesPerHr(km)+" mi/h");
	}

}
