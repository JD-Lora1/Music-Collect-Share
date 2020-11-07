package ui;
import java.util.Scanner;
import model.Mcs;

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
					"(2) C\n"+
					"(0) Salir" );

			System.out.print(": ");
			opt = sc.nextInt();
			sc.nextLine();
			System.out.println(" ");
			
			if(opt!=1 && opt!=2 && opt!=0){
				System.out.println("Digite una opcion valida"); }
		
			switch (opt){
				case 1: System.out.println(createUser());
					break;
				case 2:
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

}