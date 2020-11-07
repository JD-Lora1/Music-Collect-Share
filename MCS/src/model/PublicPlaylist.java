package model;

public class PublicPlaylist extends Playlist{

	//Atributes
	private int grade; //1-5

	public PublicPlaylist(String name, int grade){
		super(name);
		this.grade = grade;
	}
}