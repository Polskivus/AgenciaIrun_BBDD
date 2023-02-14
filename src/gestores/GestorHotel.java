package gestores;

import java.util.ArrayList;
import java.util.Scanner;

import menu.FormularioDatos;
import menu.Menu;
import menu.Visor;
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
				gestorDDBB.modificarHotel(hotel_mod);
				gestorDDBB.cerrarConexion();

				System.out.println("----------HOTEL MODIFICADO----------");

				break;

			case Menu.VISUALIZAR_HOTEL:

				gestorDDBB.abrirConexion();
				ArrayList<Hotel> hoteles = gestorDDBB.mostrarArrayHotel();
				Visor.mostrarArrayHoteles(hoteles);
				gestorDDBB.cerrarConexion();

				System.out.println("---------HOTELES EN SISTEMA---------");

				break;

			case Menu.SALIR:

				System.out.println("--------------VOLVIENDO------------------");

				break;
			}

		} while (opcHotel != Menu.SALIR);

	}

}
