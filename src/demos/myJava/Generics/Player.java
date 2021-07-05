package demos.myJava.generics;

public class Player {
	private String name;
	private int age;
	private int matchPlayed;
	private int yearFrom;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMatchPlayed() {
		return matchPlayed;
	}
	public void setMatchPlayed(int matchPlayed) {
		this.matchPlayed = matchPlayed;
	}
	public int getYearFrom() {
		return yearFrom;
	}
	public void setYearFrom(int yearFrom) {
		this.yearFrom = yearFrom;
	}
	public Player(String name, int age, int matchPlayed, int yearFrom) {
		this.name = name;
		this.age = age;
		this.matchPlayed = matchPlayed;
		this.yearFrom = yearFrom;
	}
	public Player(String name) {
		this.name = name;
	}
}
