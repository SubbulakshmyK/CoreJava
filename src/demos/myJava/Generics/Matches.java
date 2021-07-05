package demos.myJava.generics;

public class Matches {
	
	public static void main(String[] arg) {
		Team<BaseballPlayer> TN_BB = new Team<>("TN Baseball");
		Team<BaseballPlayer> KL_BB = new Team<>("Kerala Baseball");
		Team<FootballPlayer> TN_FB = new Team<>("TN Football");
		Team<FootballPlayer> KL_FB = new Team<>("Kerala Football");
		
		TN_BB.addPlayer("Karthik");
		TN_BB.addPlayer("Rakul");
		TN_BB.addPlayer("Arjun");
		KL_BB.addPlayer("Guna");
		KL_BB.addPlayer("Harish");
		KL_BB.addPlayer("Paul");
		KL_BB.addPlayer("Vijay");
		TN_FB.addPlayer("Sanju");
		TN_FB.addPlayer("Farnandas");
		TN_FB.addPlayer("Isai");
		TN_FB.addPlayer("Balu");
		KL_FB.addPlayer("Ravi");
		KL_FB.addPlayer("Roy");
		KL_FB.addPlayer("Toy");
		
		
		TN_BB.matchResult(KL_BB, 5, 3);
		TN_BB.matchResult(KL_BB, 5, 2);
		TN_FB.matchResult(KL_FB, 6, 3);
		TN_FB.matchResult(KL_FB, 7, 3);
		System.out.println("The team "+TN_BB.getName()+" rating is "+TN_BB.rating());
		System.out.println("The team "+TN_FB.getName()+" rating is "+TN_FB.rating());
		System.out.println("The team "+KL_BB.getName()+" rating is "+KL_BB.rating());
		System.out.println("The team "+KL_FB.getName()+" rating is "+KL_FB.rating());
	}

}
