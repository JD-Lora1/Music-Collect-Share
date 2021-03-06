package model;

public abstract class Playlist{

	//Attributes
	
	//Relationship
	public String name;
	public int [] length;
	public Genre[] genrePlaylist;

	//Constructor
	/**
	* Create a new playlist.<br>
	* <b>pre #1:</b> name is initialized.<br>
	* <b>pre #2:</b> The length array is initialized.<br>
	* <b>pre #3:</b> The genrePlaylist array is initialized.<br>
	* @param name . name != null.
	*/
	public Playlist(String name){
		this.name = name;
		length = new int[2];
		genrePlaylist = new Genre[Mcs.MAX_SONG];
	}
	/**
	* Show Playlist info.<br>
	**/
	public abstract String showInfo();
	/**
	* Get playlist name.<br>
	**/
	public abstract String getName();
}