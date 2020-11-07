package model;

public class Song{

	//Atributes
	private String tittle;
	private String artistName;
	private String releaseDate;
	private int[] length;
	private String genre;

	//Constructor
	public Song(String tittle, String artistName, String releaseDate, String genre){
		this.tittle = tittle;
		this.artistName = artistName;
		this.releaseDate = releaseDate;
		length = new int[2]; 
		this.genre = genre;
	}

}