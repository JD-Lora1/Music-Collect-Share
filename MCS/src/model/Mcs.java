package model;
public class Mcs{

	//Attributes
	private static final int MAX_USER = 10;
	public static final int MAX_SONG = 30; //For the class Playlist too
	private static final int MAX_PLAYLIST = 20;
	
	//Relationship
	User user [];			
	Song sharedPool [];		
	Playlist playlist [];	

	//Constructor
	/**
	* Create a new mcs.<br>
	*/
	public Mcs(){				
		user = new User [MAX_USER];
		sharedPool = new Song [MAX_SONG];
		playlist = new Playlist [MAX_PLAYLIST];
	}

	public String createUserX(String[] userInfo){
		String message="";
		boolean ctrl=false;

		if(user[(user.length -1)]!=null){
			message = "  *Lo sentimos. Se ha alcanzado nuestro MAXIMO numero de USUARIOS*";
			ctrl=true;  //As the entire users' arraylist is full, it is unnecessary to run the for
		}
		for(int i=0; i<user.length && !ctrl; i++){
			if(user[i]==null){
				user[i]= new User(userInfo[0], userInfo[1], userInfo[2]);
				ctrl=true;
				message = "  *Se ha creado el usuario*";
			}
		}
		return message;
	}

	public String addSongX(String[] songInfo){
		String message="";
		boolean ctrl=false;   //to evaluate if there is a null space in the song arraylist

		Genre genre = Genre.valueOf(songInfo[3].toUpperCase().replaceFirst(" ","_"));

		if(sharedPool[(sharedPool.length -1)]!=null){
			message = "  *Lo sentimos. Se ha alcanzado nuestro MAXIMO numero de CANCIONES*";
			ctrl=true;  //As the entire songs' arraylist is full, it is unnecessary to run the for
		}
		for(int i=0; i< sharedPool.length && !ctrl; i++){
			if(sharedPool[i]==null){
				sharedPool[i]= new Song(songInfo[0], songInfo[1], songInfo[2], genre);
				ctrl=true;
				message = "  *Se ha agregado la cancion*";
			}
		}
		return message;
	}

	/*public String createPlaylistX(String name){
		String message="";
		boolean ctrl=false;

		if(user[(user.length -1)]!=null){
			message = "  *Lo sentimos. Se ha alcanzado nuestro MAXIMO numero de PLAYLIST*";
			ctrl=true;  //As the entire playlist's arraylist is full, it is unnecessary to run the for
		}
		for(int i=0; i<user.length && !ctrl; i++){
			if(user[i]==null){
				user[i]= new User(userInfo[0], userInfo[1], userInfo[2]);
				ctrl=true;
				message = "Se ha creado el usuario";
			}
		}
		return message;
	}*/
}