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
	/**
	* Create a new playlist.<br>
	* <b>pre #1:</b> name is initialized in the super class.<br>
	*/
	public String getName(){
		return super.name;
	}
	/**
	* Show playlist info .<br>
	* <b>pre #1:</b> name is initialized (is not null) in the super class.<br>
	* <b>pre #2:</b> the length array is initialized (is not null) in the super class.<br>
	* <b>pre #3:</b> genrePlaylist is initialized (is not null) in the super class.<br>
	* <b>pre #3:</b> owner is initialized (is not null).<br>
	* @return a String with playlist's information.
	*/
	public String showInfo(){
		String message;
		message= "*************  User **************\n"+
				"**  Title: "+super.name+"\n"+
				"**  Duration: "+super.length[0]+":"+super.length[1]+"\n"+
				"**  Category: "+super.genrePlaylist.toString()+"\n"+
				"**  Owner: "+owner+"\n"+
				"***********************************\n";
		return message;
	}
}