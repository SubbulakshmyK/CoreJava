package demos.myJava.playList;

public class Song {
	private String name;
	private float duration;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getDuration() {
		return duration;
	}
	public void setDuration(float duration) {
		this.duration = duration;
	}
	public Song(String name, float duration) {
		super();
		this.name = name;
		this.duration = duration;
	}
	
}
