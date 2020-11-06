package model;

public class PrivatePlaylist extends Playlist{

	//Atributes
	private String owner;

	public PrivatePlaylist(String name, String owner){
		super(name);
		this.owner = owner;
	}
}