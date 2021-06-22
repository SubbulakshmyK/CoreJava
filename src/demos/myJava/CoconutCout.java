package demos.myJava;

public class CoconutCout {

	public static void main(String[] arg) {
		//int coconuts =0;
		for(int i=1; i<1000; i++) {
			if(i%2==1 && i%3==1 && i%4==1 && i%5==1 && i%6==1 && i%7==0) {
				System.out.println("Coconut count = "+i);
				//break;
				
			}
			
		}
	}
}
