package model;

public class PublicPlaylist extends Playlist{

	//Atributes
	private int grade; //1-5

	//Constructor
	/**
	* Create a new playlist.<br>
	* <b>pre #1:</b> owner is initialized.<br>
	* @param name . name != null.
	* @param grade . grade != null.
	*/
	public PublicPlaylist(String name, int grade){
		super(name);
		this.grade = grade;
	}
}