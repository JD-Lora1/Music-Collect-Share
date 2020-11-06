package model;

public abstract class Playlist{

	//Atributes
	private static final int MAX_SONGS = 30;
	
	private String name;
	private int [] length;
	private Genre[] genrePlaylist; 

	public Playlist(String name){
		this.name = name;
		length = new int[2];
		genrePlaylist = new Genre[MAX_SONGS];
	}

}