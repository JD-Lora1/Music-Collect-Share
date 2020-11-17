package model;

public class PrivatePlaylist extends Playlist{

	//Atributes
	private User owner;
	
	//Constructor
	/**
	* Create a new playlist.<br>
	* <b>pre #1:</b> owner is initialized.<br>
	* @param name . name != null.
	* @param owner . owner != null.
	*/
	public PrivatePlaylist(String name, User owner){
		super(name);
		this.owner = owner;
	}
}