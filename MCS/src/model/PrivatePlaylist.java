package model;

public class PrivatePlaylist extends Playlist{

	//Atributes
	private User owner;

	public PrivatePlaylist(String name, User owner){
		super(name);
		this.owner = owner;
	}
}