package ui;
import java.util.Scanner;
import model.Mcs;

public class Main{
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args){

		int opt=-1;
		boolean ctrl= false;

		while(opt!=1 && opt!=2 && opt!=0 || !ctrl){
			System.out.println(
					"\nSeleccione una opcion:\n" +
					"(1) Agregar Piloto\n" +
					"(2) Calcular los promedios\n"+
					"(0) Salir" );

			System.out.print(": ");
			opt = sc.nextInt();
			sc.nextLine();
			System.out.println(" ");
			
			if(opt!=1 && opt!=2 && opt!=0){
				System.out.println("Digite una opcion valida"); }
		
			switch (opt){
				case 1:
					break;
				case 2:
					break;
				case 0:
					ctrl=true;
					break;
			}
		}
	}

	public static Mcs createMcs(){
		System.out.println("\nPorfavor ingrese:");
		System.out.print("Anio del Campeonato: ");
		int year = sc.nextInt();
		sc.nextLine();

		Mcs mcsX = new Mcs(year, races);
		return mcsX;
	}

}