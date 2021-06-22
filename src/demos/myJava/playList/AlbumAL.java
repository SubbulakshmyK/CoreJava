package demos.myJava.playList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class AlbumAL {
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
	
	public AlbumAL(String name) {
		super();
		this.name = name;
	}
	public AlbumAL(String name, ArrayList<Song> tracks) {
		super();
		this.name = name;
		this.tracks = tracks;
	}
	public void addSong(String name, float duration) {
		Song s1= new Song(name, duration);
		this.tracks.add(s1);
	}
	
	public void addToPlayList(String songName, LinkedList<Song> playList) {
		Song song = getSong(songName);
		boolean songFound = findSong(song, playList);
		if(songFound)
			System.out.println("Song already in PlayLsit...");
		else
			playList.add(song);
	}
	public void addToPlayList(int songNo, LinkedList<Song> playList) {
		if(songNo>0 && songNo <= this.tracks.size()) {
			Song song = this.tracks.get(songNo-1);
			boolean songFound = findSong(song, playList);
			if(songFound)
				System.out.println("Song already in PlayLsit...");
			else
				playList.add(song);	
		}
		else
			System.out.println("Invalid Entry...");

	}	
	public void removeFromPlayList(Song song, LinkedList<Song> playList) {
		boolean songFound = findSong(song, playList);
		if(songFound)
			playList.remove(song);	
		else
			System.out.println("Song already in PlayLsit...");
	}
	
	public boolean findSong(Song song, LinkedList<Song> playList) {
		if(playList.isEmpty()) {
			return false;
		}
		else {
			ListIterator<Song> litr = playList.listIterator();
			while(litr.hasNext()) {
				if(song.getName().equals(litr.next().getName())) {
					return true;
				}
			}
			return false;
		}
	}
	
	public Song getSong(String songName) {
		Song song =null;
		if(this.tracks.isEmpty()) {
			return new Song();
		}
		else {
			ListIterator<Song> litr = this.tracks.listIterator();
			while(litr.hasNext()) {
				song = litr.next();
				if(songName.equals(song.getName())) {
					return song;
				}
			}
		}
		return song;
	}
}
