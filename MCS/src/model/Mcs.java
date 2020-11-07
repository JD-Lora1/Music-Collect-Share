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
	//create User
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
	//Add Song
	public String addSongX(String[] songInfo, int[] length){
		String message="";
		boolean ctrl=false;   //to evaluate if there is a null space in the song arraylist

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
	//create Private Playlist
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
	//create Restricted Playlist
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
	//create Public Playlist
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

	// Show user info
	public String userInfo(String name){
		String message="Este usuario NO existe ";
		int[] info = findUser(name);
		message=user[info[1]].showInfo();
		return message;
	}

	//Find User
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