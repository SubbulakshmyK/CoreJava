package demos.myJava.playList;

import java.util.ArrayList;

public class Album {
	private String name;
	private ArrayList<Song> tracks = new ArrayList<Song>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Song> getTracks() {
		return tracks;
	}
	public void setTracks(ArrayList<Song> tracks) {
		this.tracks = tracks;
	}
	public Album(String name, ArrayList<Song> tracks) {
		super();
		this.name = name;
		this.tracks = tracks;
	}

}
