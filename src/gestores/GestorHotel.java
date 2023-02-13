package gestores;

import java.util.Scanner;

import menu.Menu;

public class GestorHotel {

	/**
	 * @param sc
	 */

	public static void run(Scanner sc) {

		GestorDDBB gestorDDBB = new GestorDDBB();
		
		int opcHotel;
		
		do {
			
			Menu.menuHoteles();
			
			opcHotel = Integer.parseInt(sc.nextLine());
			
			while(opcHotel < Menu.SALIR || opcHotel > Menu.VISUALIZAR_HOTEL) {
				
				System.out.println("!Error¡ Introduce un valor valido");

				Menu.menuClientes();

				opcHotel = Integer.parseInt(sc.nextLine());
				
			};
			
			switch (opcHotel) {
			case Menu.INSERTAR_HOTEL:
				
				break;

			case Menu.ELIMINAR_HOTEL:
				
				break;
				
			case Menu.MODIFICAR_HOTEL:
				
				break;
			
			case Menu.VISUALIZAR_HOTEL:
				
				break;
			
			case Menu.SALIR:
				break;
			}
			
			
		}while(opcHotel != Menu.SALIR);
		
	}

}
