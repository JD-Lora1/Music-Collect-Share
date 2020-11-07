package model;

public class Song{

	//Atributes
	private String tittle;
	private String artistName;
	private String releaseDate;
	private Genre genre;
	private int[] length = new int[2];

	//Constructor
	public Song(String tittle, String artistName, String releaseDate, Genre genre, int[] length){
		this.tittle = tittle;
		this.artistName = artistName;
		this.releaseDate = releaseDate;
		this.genre = genre;
		this.length = length; 
	}

}