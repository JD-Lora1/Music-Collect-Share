package ui;
import java.util.Scanner;
import model.Mcs;
import model.Genre;

public class Main{
	public static Scanner sc = new Scanner(System.in);

	//Relationship
	private static Mcs mcs = new Mcs();

	public static void main(String[] args){

		int opt=-1;
		boolean ctrl= false;

		System.out.println( "(((((((((((((((((((((((((((((((((((((((((((((((((\n" +
						    "((((((((((((((((/((((((((((((((((((((((((((((((((\n" +
							"(((/  .(((((((*  .((((((*        (((((/      /(((\n" +
							"(((/   .((((((.  .(((((   ,((((((((((*  .((((((((\n" +
							"(((/    /((((/   .((((/  ,(((((((((((.  /((((((((\n" +
							"(((/     ((((*   .((((*  ,(((((((((((/   ((((((((\n" +
							"(((/  *  *(((     ((((*  ,((((((((((((,  .(((((((\n" +
							"(((/  /.  ((*     ((((*  *(((((((((((((,   ((((((\n" +
							"(((/  //  ,(  .   ((((*  *((((((((((((((/   /((((\n" +
							"(((/  *(*  ,  (   ((((*  *((((((((((((((((   /(((\n" +
							"(((/  ,(/    ,(   /(((*  ,(((((((((((((((((   (((\n" +
							"(((/  .((    ((   /((((  .(((((((((((((((((.  /((\n" +
							"(((/  .((.  .((.  *((((,  *((((((((((((((((   /((\n" +
							"(((/  .((((((((.  *(((((   *((((/,/(((((((/   (((\n" +
							"(((/  .((((((((.  *((((((.        *((   .   .((((\n" +
							"(((((((((((((((/*/((((((((((///(((((((////(((((((\n" +
							"(((((((((((((((((((((((((((((((((((((((((((((((((\n" +
							"                ./(###((///((###(*                \n" +
							"            *#(,                   *((,           \n" +
							"         ,#/                           ((         \n" +
							"       .#*          .**/////*,.          ((       \n" +
							"      *(.      .//////////////////*       *#      \n" +
							"     .#,     *///////////////////////,     /(     \n" +
							"     /(    *///////////////////////////    .#.    \n" +
							"   ,/////,*/////////////////////////////,*////*.  \n" +
							"   /////////////////////////*,...,/////////////,  \n" +
							"   //////*,,,********,,.............,,,,,//////,  \n" +
							"   //////*.........//*........//*.......,//////,  \n" +
							"   //////*.........,,.........,,........,//////,  \n" +
							"   //////*..............................,//////,  \n" +
							"    *///*  ........,/.........**.......  .*///,   \n" +
							"             .......,/*.....,/*.......            \n" +
							"                ........,,,,.......               \n" +
							"                     .........                    \n" +
							"                                                \n" +     
							"*************************************************\n" );

		while(opt!=1 && opt!=2 && opt!=3 && opt!=4 && opt!=0 || !ctrl){
			System.out.println(
					"\nSeleccione una opcion:\n" +
					"(1) Crear Usuario\n" +
					"(2) Agregar cancion\n"+
					"(3) Crear playlist\n"+
					"(4) Mostrar la informacion del usuario\n"+
					"(0) Salir" );

			System.out.print(": ");
			opt = sc.nextInt();
			sc.nextLine();
			
			if(opt!=1 && opt!=2 && opt!=3 && opt!=4 && opt!=0){
				System.out.println("Digite una opcion valida"); }
		
			switch (opt){
				case 1: System.out.println(createUser());
					break;
				case 2: System.out.println(addSong());
					break;
				case 3: System.out.println(createPlaylist());
					break;
				case 4: System.out.println(showUserInfo());
					break;
				case 0: System.out.println("   *Fin*");
					ctrl=true;
					break;
			}
		}
	}

	// Create User
	public static String createUser(){

		System.out.println("\nPorfavor ingrese:");
		System.out.print("Nombre de usuario: ");
		String username = sc.nextLine();
		System.out.print("Password: ");
		String password = sc.nextLine();
		System.out.print("Edad: ");
		String age = sc.nextLine();

		String[] userInfo = {username, password, age};

		String message = mcs.createUserX(userInfo);
		return message;
	}
	//Add Song
	public static String addSong(){

		System.out.println("\nPorfavor ingrese:");
		System.out.print("Nombre de la cancion: ");
		String songName = sc.nextLine();
		System.out.print("Nombre del artista: ");
		String artistName = sc.nextLine();
		System.out.print("Fecha de publicacion: ");
		String releaseDate = sc.nextLine();

		System.out.println("Duracion [Minutos y luego segundos]");
		int[] length= new int[2];
		System.out.print("Minutos: ");
		length[0]= sc.nextInt();
		sc.nextLine();
		System.out.print("Segundos: ");
		length[1]= sc.nextInt();
		sc.nextLine();

		if(length[1]>=60){
			length[0]+=((length[1] - length[1]%60)/60);
			length[1]=length[1]%60;
		}
		if(length[1]<10)
			System.out.println("-> "+length[0]+":0"+length[1]);
		else
			System.out.println("-> "+length[0]+":"+length[1]);

		String sGenre="";
		boolean ctrlGen=false; // to evaluate the genre
		System.out.println("Genero de la cancion:");
		System.out.println("Mayuscula o Minuscula, y se puede poner espacios o '_'");

		while(!ctrlGen){

			for(int i=0; i<Genre.values().length; i++){
				System.out.println(" *"+Genre.values()[i].toString());
			}
			System.out.print("  ");
			sGenre= sc.nextLine();

			for(int j=0; j<Genre.values().length && !ctrlGen; j++){
				if(sGenre.toUpperCase().replaceFirst(" ","_").equals(Genre.values()[j].toString())){
					ctrlGen=true;
				}
			}

			if(!ctrlGen){
				System.out.println("\nEste genero No esta en nuestra base, digite alguno de la lista: \n");
			}
		}

		String[] sSongInfo = {songName, artistName, releaseDate, sGenre};
		String message = mcs.addSongX(sSongInfo, length);
		return message;
	}
	//Create Playlist
	public static String createPlaylist(){
		System.out.println("\nPorfavor ingrese:");
		System.out.print("Titulo de la playlist: ");
		String tittle = sc.nextLine();
		System.out.println("Que tipo de playlist es:");

		String message ="";
		int opt=-1;
		boolean ctrl = false;

		while(opt!=1 && opt!=2 && opt!=3){
			System.out.println(
					"\nSeleccione una opcion:\n" +
					"(1) Privada\n" +
					"(2) Publica\n"+
					"(3) Restringida\n");

			System.out.print(": ");
			opt = sc.nextInt();
			sc.nextLine();
			
			if(opt!=1 && opt!=2 && opt!=3){
				System.out.println("Digite una opcion valida"); }
		
			switch (opt){
				case 1: message=privatePlaylist(tittle);
					break;
				case 2: message= publicPlaylist(tittle);
					break;
				case 3: message= restrictedPlaylist(tittle);
					break;
			}
		}
		return message;
	}
	//Private Playlist
	public static String privatePlaylist(String name){
		String messageX="";
		System.out.println("Username del propietario:");
		String owner= sc.nextLine();
		messageX= mcs.privatePlaylistX(name, owner);
		return messageX;
	}
	//Public Playlist
	public static String publicPlaylist(String name){
		String messageX="";
		System.out.println("Calificacion de la playlist (1-5)");
		int x = sc.nextInt();
		while(x>5 || x<1){
			x = sc.nextInt();
			sc.nextLine();
			if(x>5 || x<1){
				System.out.println("Calificacion entre 1 y 5");
			}
		}
		messageX= mcs.publicPlaylistX(name, x);
		return messageX;
	}

	//Restricted Playlist
	public static String restrictedPlaylist(String name){
		String messageX="";
		System.out.println("Cuantos propietarios tiene la playlist? (Max 5)");
		int x = 6;
		while(x>5 || x<1){
			x = sc.nextInt();
			sc.nextLine();
			if(x>5 || x<1){
				System.out.println("Digita un numero entre 1 y 5");
			}
		}
		String[] owner = new String[x];
		System.out.println("Digita el o los nombres de usuario: ");
		for(int i=0; i< owner.length; i++){
			owner[i]= sc.nextLine();
		}
		
		messageX= mcs.restrictedPlaylistX(name, owner);
		return messageX;
	}

	//show User's Info
	public static String showUserInfo(){
		String name="";
		System.out.println("Para mostrar la informacion digite:");
		System.out.println("Nombre de usuario");
		name=sc.nextLine();

		String message= mcs.userInfo(name);
		return message;
	}

}