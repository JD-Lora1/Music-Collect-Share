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
			message = "  *Lo sentimos. Se ha alcanzado nuestro MAXIMO numero de usuarios*";
			ctrl=true;  //As everything is full, it is unnecessary to run the for
		}
		for(int i=0; i<user.length && !ctrl; i++){
			if(user[i]==null){
				user[i]= new User(userInfo[0], userInfo[1], userInfo[2]);
				ctrl=true;
				message = "Se ha creado el usuario";
			}
		}

		return message;
	}
}