package model;

public class Song{

	//Atributes
	private String title;
	private String artistName;
	private String releaseDate;
	private Genre genre;
	private int[] length = new int[2];

	//Constructor
	/**
	* Create a new playlist.<br>
	* <b>pre #1:</b> title is initialized.<br>
	* <b>pre #2:</b> artistName is initialized.<br>
	* <b>pre #3:</b> releaseData is initialized.<br>
	* <b>pre #4:</b> genre is initialized.<br>
	* <b>pre #5:</b> The length array is initialized.<br>
	* @param title . title != null.
	* @param artistName . artistName != null.
	* @param releaseDate . releaaseData != null.
	* @param genre . genre != null.
	* @param length . length != null.
	*/
	public Song(String title, String artistName, String releaseDate, Genre genre, int[] length){
		this.title = title;
		this.artistName = artistName;
		this.releaseDate = releaseDate;
		this.genre = genre;
		this.length = length; 
	}
	//Gets
	/**
	* Get title .<br>
	* @return a String with the song's name.
	*/
	public String getTitle(){
		return title;
	}
	/**
	* Show song's info .<br>
	* <b>pre #1:</b> title is initialized (is not null).<br>
	* <b>pre #2:</b> artistName is initialized (is not null).<br>
	* <b>pre #3:</b> the length array is initialized (is not null).<br>
	* <b>pre #2:</b> genre is initialized (is not null).<br>
	* @return a String with song's information.
	*/
	public String showInfo(){
		String message;
		message= "*************  Song **************\n"+
				"**  Title: "+title+"\n"+
				"**  Artist: "+artistName+"\n"+
				"**  Duration: "+length[0]+":"+length[1]+"\n"+
				"**  Genre: "+genre.toString()+"\n"+
				"***********************************\n";
		return message;
	}	
}