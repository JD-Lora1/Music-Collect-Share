package model;

public class Song{

	//Atributes
	private String tittle;
	private String artistName;
	private String releaseDate;
	private Genre genre;
	private int[] length = new int[2];

	//Constructor
	/**
	* Create a new playlist.<br>
	* <b>pre #1:</b> tittle is initialized.<br>
	* <b>pre #2:</b> artistName is initialized.<br>
	* <b>pre #3:</b> releaseData is initialized.<br>
	* <b>pre #4:</b> genre is initialized.<br>
	* <b>pre #5:</b> The length array is initialized.<br>
	* @param tittle . name != null.
	* @param artistName . name != null.
	* @param releaseDate . name != null.
	* @param genre . name != null.
	* @param length . name != null.
	*/
	public Song(String tittle, String artistName, String releaseDate, Genre genre, int[] length){
		this.tittle = tittle;
		this.artistName = artistName;
		this.releaseDate = releaseDate;
		this.genre = genre;
		this.length = length; 
	}

}