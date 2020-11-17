package model;

public class RestrictedPlaylist extends Playlist{

	//Atributes
	private User[] owner = new User[5];

	//Constructor
	/**
	* Create a new playlist.<br>
	* <b>pre #1:</b> owner is initialized.<br>
	* @param name . name != null.
	* @param owner . owner != null.
	*/
	public RestrictedPlaylist(String name, User[] owner){
		super(name);
		for(int i=0; i<owner.length ;i++){
			this.owner[i] = owner[i];
		}
		
	}
}