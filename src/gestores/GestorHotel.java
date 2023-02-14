package gestores;

import java.util.Scanner;

import menu.FormularioDatos;
import menu.Menu;
import objetos.Hotel;

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

			while (opcHotel < Menu.SALIR || opcHotel > Menu.VISUALIZAR_HOTEL) {

				System.out.println("!Error¡ Introduce un valor valido");

				Menu.menuClientes();

				opcHotel = Integer.parseInt(sc.nextLine());

			}
			
	
		

			switch (opcHotel) {
			case Menu.INSERTAR_HOTEL:

				Hotel hotel = new Hotel();

				gestorDDBB.abrirConexion();
				hotel = FormularioDatos.insertarHotel(sc);
				gestorDDBB.insertarHotel(hotel);
				gestorDDBB.cerrarConexion();

				System.out.println("----------HOTEL AÑADIDO----------");

				break;

			case Menu.ELIMINAR_HOTEL:

				int id;

				gestorDDBB.abrirConexion();
				id = FormularioDatos.pedirIDHotelEliminar(sc);
				gestorDDBB.eliminarHotel(id);
				gestorDDBB.cerrarConexion();

				System.out.println("----------HOTEL ELIMINADO----------");

				break;

			case Menu.MODIFICAR_HOTEL:

				Hotel hotel_mod = new Hotel();
				
				gestorDDBB.abrirConexion();
				hotel_mod = FormularioDatos.modificarHotel(hotel_mod, sc);
				gestorDDBB.
				
				break;

			case Menu.VISUALIZAR_HOTEL:

				break;

			case Menu.SALIR:
				break;
			}

		} while (opcHotel != Menu.SALIR);

	}

}
