package demos.myJava.generics;

import java.util.ArrayList;
import java.util.List;

public class Team<T extends Player> implements Comparable<Team <T>> {
	
	private String name;
	private int played;
	private int won;
	private int lost;
	private int tied;
	
	private List<T> players;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlayed() {
		return played;
	}

	public void setPlayed(int played) {
		this.played = played;
	}

	public int getWon() {
		return won;
	}

	public void setWon(int won) {
		this.won = won;
	}

	public int getLost() {
		return lost;
	}

	public void setLost(int lost) {
		this.lost = lost;
	}

	public int getTied() {
		return tied;
	}

	public void setTied(int tied) {
		this.tied = tied;
	}

	@Override
	public int compareTo(Team <T> t) {
		return (this.rating() > t.rating() ? -1 :(this.rating() < t.rating())? 1:0);
	}

	public Team(String name) {
		this.name = name;
		this.played = 0;
		this.won = 0;
		this.lost = 0;
		this.tied = 0;
		this.players = new ArrayList<>();
	}

	public Team() {
		this.name = "";
		this.played = 0;
		this.won = 0;
		this.lost = 0;
		this.tied = 0;
		this.players = new ArrayList<>();
	}
	
	public boolean addPlayer(T player) {
		
		if(this.players.size()==0 || this.players.contains(player)) {
			this.players.add(player);
			return true;
		}
		else {
			System.out.println("Player already in the team");
			return false;
		}
	}
	@SuppressWarnings("unchecked")
	public boolean addPlayer(String name) {
		T player = (T) new Player(name);
		if(this.players.size()==0 || this.players.contains(player)) {
			this.players.add(player);
			return true;
		}
		else {
			System.out.println("Player already in the team");
			return false;
		}
	}	
	public void matchResult(Team<T> opponent, int score, int oppscore) {
		System.out.println(this.getName());
		String msg ="";
		if(score == oppscore) {
			this.tied++;
			msg = " Tied ";
		}
		else if (score < oppscore) {
			this.lost++;
			msg = " Lost ";
		}
		else {
			this.won++;
			msg = " Won ";
		}
		this.played++;
		if(opponent != null) {
			System.out.println(this.getName()+msg + " the match with "+opponent.getName());
			opponent.matchResult(null, oppscore, score);
		}
	}
	
	public int rating() {
		int rating=0;
		if(this.won >0)
			rating = (this.won/this.played) *2 + this.tied;
		return rating;
	}
}
