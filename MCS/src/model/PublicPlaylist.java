package model;

public class PublicPlaylist extends Playlist{

	//Atributes
	private int grade; 

	public PublicPlaylist(String name, int grade){
		super(name);
		this.grade = grade;
	}
}