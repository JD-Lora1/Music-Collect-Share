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
	* <b>pre #1:</b> The user array is initialized.<br>
	* <b>pre #2:</b> The sharedPool array is initialized.<br>
	* <b>pre #3:</b> The playlist array is initialized.<br>
	*/
	public Mcs(){				
		user = new User [MAX_USER];
		sharedPool = new Song [MAX_SONG];
		playlist = new Playlist [MAX_PLAYLIST];
	}
	/**
	* Create a new user.<br>
	* <b>pre #1:</b> The user array is initialized (is not null).<br>
	* @param userInfo used to create the user. userInfo != null.
	* @return a String that indicates if the user was created or not.
	*/
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
	/**
	* Add(create) a song.<br>
	* <b>pre #1:</b> The sharedPool array is initialized (is not null).<br>
	* @param songInfo . Song's info .Used to create the song. songInfo != null.
	* @param length . Song's length. Used to create the song. length != null.
	* @return a String that indicates if the song was added or not.
	*/
	public String addSongX(String[] songInfo, int[] length){
		String message="";
		boolean ctrl=false; //to evaluate if there is a null space in the song arraylist

		Genre genre = Genre.valueOf(songInfo[3].toUpperCase().replaceFirst(" ","_"));

		if(sharedPool[(sharedPool.length -1)]!=null){
			message = "  *Lo sentimos. Se ha alcanzado nuestro MAXIMO numero de CANCIONES*";
			ctrl=true;  //As the entire songs' arraylist is full, it is unnecessary to run the for
		}
		for(int i=0; i< sharedPool.length && !ctrl; i++){
			if(sharedPool[i]==null){
				sharedPool[i]= new Song(songInfo[0], songInfo[1], songInfo[2], genre, length);
				ctrl=true;
				message = "  *Se ha agregado la cancion*";
			}
		}
		return message;
	}
	/**
	* Create a private playlist.<br>
	* <b>pre #1:</b> The platlist array is initialized (is not null).<br>
	* @param tittle . Playlist name used to create the playlist. tittle != null.
	* @param owner . Usernmae used to create the song. owner != null.
	* @return a String that shows if the playlist was cretated or not(the playlist array is completely full or the user was not found).
	*/
	public String privatePlaylistX(String tittle, String owner){
		String message="";
		boolean ctrl=false;
		int[] arraylistUser=findUser(owner);

		if(arraylistUser[0]==1){
			if(playlist[(playlist.length -1)]!=null){
				message = "  *Lo sentimos. Se ha alcanzado nuestro MAXIMO numero de PLAYLIST*";
				ctrl=true;  //As the entire playlist's arraylist is full, it is unnecessary to run the for
			}
			for(int i=0; i<user.length && !ctrl; i++){
				if(playlist[i]==null){
					playlist[i]= new PrivatePlaylist(tittle, user[arraylistUser[1]]);
					ctrl=true;
					message = "Se ha creado la Playlist Privada";
				}
			}
		} else {
			message="Usuario No encontrado";
		}
		return message;
	}
	/**
	* Create a restricted playlist.<br>
	* <b>pre #1:</b> The platlist array is initialized (is not null).<br>
	* @param tittle . Playlist name used to create the playlist. tittle != null.
	* @param owner . Usernamee used to create the song. owner != null.
	* @return a String that shows if the playlist was cretated or not(the playlist array is completely full or the user was not found).
	*/
	public String restrictedPlaylistX(String tittle, String[] owner){
		String message="";
		boolean ctrl = false;
		int verifyUser = 0;
		int[] positions = new int[owner.length];

		int[] arraylistUser = new int[(owner.length *2)];

		int[] arrayControl = new int[2];

		for(int x=0; x<owner.length; x++){
			arrayControl = findUser(owner[x]);
			for(int y=0; y<2; y++){
				arraylistUser[(y+2*x)] = arrayControl[y] ;
			}
		}

		for(int j=0; j<owner.length; j++){
			if(arraylistUser[(2*j)+1]==1){
				System.out.println("Usuario"+(j+1)+" Encontrado");
				verifyUser+=1;
				positions[j]=arraylistUser[(2*j)+1];
			}else{
				System.out.println("Usuario"+(j+1)+" NO Encontrado");
				positions[j]=arraylistUser[(2*j)+1];
			}
		}
		if(verifyUser==owner.length){
			if(playlist[(playlist.length -1)]!=null){
				message = "  *Lo sentimos. Se ha alcanzado nuestro MAXIMO numero de PLAYLIST*";
				ctrl=true;  //As the entire playlist's arraylist is full, it is unnecessary to run the for
			}
			for(int i=0; i<user.length && !ctrl; i++){
				if(playlist[i]==null){
					User[] userx = new User[owner.length];
					for(int m=0; m<userx.length; m++){
						userx[m]=user[positions[m]];
					}
					playlist[i]= new RestrictedPlaylist(tittle, userx);
					ctrl=true;
					message = "Se ha creado la Playlist Restricted";
				}
			}
		}
		else{
			System.out.println("Algun usuario NO ha sido encontrado");
		}
		
		return message;
	}
	/**
	* Create a public playlist.<br>
	* <b>pre #1:</b> The platlist array is initialized (is not null).<br>
	* @param tittle . Playlist name used to create the playlist. tittle != null.
	* @param grade . grade used to create the song. owner != null.
	* @return a String that shows if the playlist was cretated or not(the playlist array is completely full or the user was not found).
	*/
	public String publicPlaylistX(String tittle, int grade){
		String message="";
		boolean ctrl=false;

		if(playlist[(playlist.length -1)]!=null){
			message = "  *Lo sentimos. Se ha alcanzado nuestro MAXIMO numero de PLAYLIST*";
			ctrl=true;  //As the entire playlist's arraylist is full, it is unnecessary to run the for
		}
		for(int i=0; i<user.length && !ctrl; i++){
			if(playlist[i]==null){
				playlist[i]= new PublicPlaylist(tittle, grade);
				ctrl=true;
				message = "Se ha creado la Playlist Publica";
			}
		}
		return message;
	}
	/**
	* Show user info.<br>
	* <b>pre #1:</b> The user array is initialized (is not null).<br>
	* @param name used to find the user and then the info of this user. name != null.
	* @return a String with the user's info.
	*/
	public String userInfo(String name){
		String message="Este usuario NO existe ";
		int[] info = findUser(name);
		message=user[info[1]].showInfo();
		return message;
	}
	/**
	* find a user by the name.<br>
	* <b>pre #1:</b> The user array is initialized (is not null).<br>
	* @param name used to find the user. name != null.
	* @return an int[] that in the [1] position contains the position of the user in the user array.
	*/
	public int[] findUser(String name){
		int[] ctrl= new int[2];
		ctrl[0] = 0;
		ctrl[1] = 0;
		for(int i=0; i<user.length && ctrl[0]==1; i++){
			if(user[i]!=null && name.equals(user[i].getUsername())){
				ctrl[0]=1;
				ctrl[1]=i;
			}
		}
		return ctrl;
	}

}