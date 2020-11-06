package model;

public class RestrictedPlaylist extends Playlist{

	//Atributes
	private User[] owner = new User[5];

	public RestrictedPlaylist(String name, User[] owner){
		super(name);
		for(int i=0; i<owner.length ;i++){
			this.owner[i] = owner[i];
		}
		
	}
}