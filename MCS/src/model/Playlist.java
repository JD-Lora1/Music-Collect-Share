package model;

public abstract class Playlist{

	//Attributes
	
	//Relationship
	private String name;
	private int [] length;
	private Genre[] genrePlaylist; 

	//Constructor 
	public Playlist(String name){
		this.name = name;
		length = new int[2];
		genrePlaylist = new Genre[Mcs.MAX_SONG];
	}

}