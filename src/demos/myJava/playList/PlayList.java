package demos.myJava.playList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class PlayList {
	private static ArrayList<AlbumAL> albums = new ArrayList<AlbumAL>();
	
	public static void main(String[] arg) {
		
		AlbumAL rythm = new AlbumAL("Rythm");
		rythm.addSong("Kaatrey En Vaasal...", (float) 3.5);
		rythm.addSong("Nathiye Nathiye...", (float) 4.15);
		rythm.addSong("Nilame poru nilame...", (float) 4.05);
		rythm.addSong("Anbe idhu ...(Sky)", (float) 4.2);
		rythm.addSong("Ayyo Pathikichu ...(Fire)", (float) 3.59);

		AlbumAL ko = new AlbumAL("Ko");
		ko.addSong("Ennamo Etho...", (float) 4.57);
		ko.addSong("Ven Paniye...", (float) 3.55);
		ko.addSong("Amali Thumali...", (float) 4.12);
		ko.addSong("Gala Gala ...", (float) 4.23);
		ko.addSong("Aga naga...", (float) 3.34);
		
		AlbumAL Asuran = new AlbumAL("Asuran");
		Asuran.addSong("Elluvaya pookaliye...", (float) 3.5);
		Asuran.addSong("Kathari Poovazhagi...", (float) 4.15);
		Asuran.addSong("Polladha Boomi...", (float) 4.05);
		Asuran.addSong("Kannazhagu Rathiname ...", (float) 4.2);
		Asuran.addSong("The Blood Bath...", (float) 3.9);
		
		AlbumAL master = new AlbumAL("master");
		master.addSong("Vathi Coming...", (float) 3.5);
		master.addSong("Vathi Raid...", (float) 4.15);
		master.addSong("Kutty Story...", (float) 4.05);
		master.addSong("Andha kanna parthaakaa..", (float) 4.2);
		master.addSong("Polakattum para para...", (float) 3.9);
		
		AlbumAL karnan = new AlbumAL("karnan");
		karnan.addSong("Kanda vara sollunga...", (float) 3.5);
		karnan.addSong("Uttatheenga yappov...", (float) 4.15);
		karnan.addSong("Thattan thattan...", (float) 4.05);
		karnan.addSong("Manjanathi....", (float) 4.2);
		karnan.addSong("Karnan Theme...", (float) 3.9);
		
		albums.add(rythm);
		albums.add(karnan);
		albums.add(master);
		albums.add(Asuran);
		albums.add(ko);
		
		LinkedList<Song> playList = new LinkedList<Song>();
		albums.get(0).addToPlayList(1, playList);
		albums.get(1).addToPlayList(1, playList);
		albums.get(2).addToPlayList(1, playList);
		albums.get(3).addToPlayList(4, playList);
		albums.get(4).addToPlayList(2, playList);
		albums.get(3).addToPlayList(3, playList);
		
		play(playList);
		
		
	}
	public static void play(LinkedList<Song> playList) {
		Scanner sc = new Scanner(System.in);
		try {
			boolean quit = false, fwd = true;
			ListIterator<Song> litr = playList.listIterator();
			if(playList.size()==0) {
				System.out.println("Playlist is Empty....");
				return;
			}
			else {
				System.out.println("Now Playing....  "+litr.next().getName());
				printMenu();
			}
			while(!quit) {
				int action = sc.nextInt();
				sc.nextLine();
				
				switch(action){
				
					case 0:
							System.out.println("PlayList Completed...");
							quit = true;
							break;
					case 1:
							if(!fwd) {
								if(litr.hasNext()) {
									litr.next();
									fwd=true;
								}
							}
							if(litr.hasNext()) 
								System.out.println("Now Playing "+ litr.next().toString());
							else {
								System.out.println("We are in the End of PlayList ");
								fwd = false;
							}
							break;
					case 2:
							if(fwd) {
								if(litr.hasPrevious()) {
									litr.previous();
									fwd=false;
								}
							}
							if(litr.hasPrevious()) 
								System.out.println("Now Playing "+ litr.previous().toString());
							else {
								System.out.println("We are in the begining of PlayList ");
								fwd=true;
							}
							break;
					case 3:
							if(fwd) {
								if(litr.hasPrevious()) {
									System.out.println("Now Playing "+ litr.previous().toString());
									fwd = false;
								}
								else
									System.out.println("We are in the begining of PlayList ");
							}
							else {
								if(litr.hasNext()) {
									System.out.println("Now Playing "+ litr.next().toString());
									fwd=true;
								}
								else 
									System.out.println("We are in the End of PlayList ");
							}
								
							break;
					case 4:
							printList(playList);
							break;
					case 5:
							printMenu();
							break;
					case 6:
							if(playList.size()>0) {
								litr.remove();
								if(litr.hasNext())
									System.out.println("Now Playiing "+litr.next().toString());
								else if(litr.hasPrevious())
									System.out.println("Now Playiing "+litr.previous().toString());
								else
									System.out.println("PlayList is Empty");
							}
							break;
				}
			}
		}
		finally {
			sc.close();
		}
	}
	
	public static void printMenu() {
		System.out.println("Available Actions: \n"
							+ "Press 0 - to Quit \n"
							+ "Press 1 - to Play Next Song \n"
							+ "Press 2 - to Play Previous Song \n"
							+ "Press 3 - to Replay the current song \n"
							+ "Press 4 - to Print PlayList \n"
							+ "Press 5 - to Print available Actions \n"
							+ "Press 6 - to Remove current song from Playlist \n");
		
	}
	
	public static void printList(LinkedList<Song> playList) {
		ListIterator<Song> litr = playList.listIterator();
		System.out.println("===========PLayList=============");
		while(litr.hasNext()) {
			System.out.println(litr.next().toString());
		}
		System.out.println("===========******* PLayList END ******=========");
	}
}
