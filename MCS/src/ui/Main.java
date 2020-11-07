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

		while(opt!=1 && opt!=2 && opt!=0 || !ctrl){
			System.out.println(
					"\nSeleccione una opcion:\n" +
					"(1) Crear Usuario\n" +
					"(2) aniadir cancion\n"+
					"(0) Salir" );

			System.out.print(": ");
			opt = sc.nextInt();
			sc.nextLine();
			
			if(opt!=1 && opt!=2 && opt!=0){
				System.out.println("Digite una opcion valida"); }
		
			switch (opt){
				case 1: System.out.println(createUser());
					break;
				case 2: System.out.println(addSong());
					break;
				case 0: System.out.println("   *Fin*");
					ctrl=true;
					break;
			}
		}
	}

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

	/*public static String createPlaylist(){

		String tittle, String artistName, String releaseDate, String genre

		System.out.println("\nPorfavor ingrese:");
		System.out.print("Nombre de la playlist: ");
		String playlistName = sc.nextLine();

		mcs.createPlaylistX()
	}*/

	public static String addSong(){

		System.out.println("\nPorfavor ingrese:");
		System.out.print("Nombre de la cancion: ");
		String songName = sc.nextLine();
		System.out.print("Nombre del artista: ");
		String artistName = sc.nextLine();
		System.out.print("Fecha de publicacion: ");
		String releaseDate = sc.nextLine();

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

		String[] songInfo = {songName, artistName, releaseDate, sGenre};
		String message = mcs.addSongX(songInfo);
		return message;
	}

}