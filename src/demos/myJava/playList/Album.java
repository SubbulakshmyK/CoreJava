/*
 * 
 * Using Inner class
 * */
package demos.myJava.playList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Album {
	private String name;
	private SongsList songslist ;
	
	class SongsList{
		private ArrayList<Song> tracks ;
		
		public SongsList() {
			this.tracks = new ArrayList<Song>();
		}
		public ArrayList<Song> getTracks() {
			return tracks;
		}
		public void setTracks(ArrayList<Song> tracks) {
			this.tracks = tracks;
		}
		
		public boolean addSongIC(Song song) {
			if(this.tracks.contains(song))
				return false;
			this.tracks.add(song);
			return true;
		}
		
		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public Album(String name) {
		this.name = name;
		this.songslist = new SongsList();
	}
	public void addSong(String name, float duration) {
		Song s1= new Song(name, duration);
		this.songslist.addSongIC(s1);
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
		if(songNo>0 && songNo <= this.songslist.tracks.size()) {
			Song song = this.songslist.tracks.get(songNo-1);
			boolean songFound = findSong(song, playList);
			if(songFound)
				System.out.println("Song already in PlayLsit...");
			else
				playList.add(song);	
		}
		else
			System.out.println("Invalid Entry...");

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
	public void removeFromPlayList(Song song, LinkedList<Song> playList) {
		boolean songFound = findSong(song, playList);
		if(songFound)
			playList.remove(song);	
		else
			System.out.println("Song already in PlayLsit...");
	}
	
	public Song getSong(String songName) {
		Song song =null;
		List<Song> songlist = this.songslist.tracks;
		for(Song checkSong : songlist) {
			if(songName.equals(checkSong.getName())) {
				song=checkSong;
				break;
			}
		}
		return song;
	}
}
