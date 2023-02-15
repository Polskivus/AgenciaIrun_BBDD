package gestores;

import java.util.ArrayList;
import java.util.Scanner;

import menu.FormularioDatos;
import menu.Menu;
import objetos.Reserva;

public class GestorReservas {

	public static void run(Scanner sc) {

		GestorDDBB gestorDDBB = new GestorDDBB();

		int opcReserva;

		do {

			Menu.menuReservas();

			opcReserva = Integer.parseInt(sc.nextLine());

			while (opcReserva < Menu.SALIR || opcReserva > Menu.VISUALIZAR_RESERVAS) {

				System.out.println("!Error¡ Introduce un valor valido");

				Menu.menuReservas();

				opcReserva = Integer.parseInt(sc.nextLine());
			}

			switch (opcReserva) {
			case Menu.INSERTAR_RESERVAS:

				ArrayList<String> dnis = new ArrayList<>();

				Reserva reserva = new Reserva();

				gestorDDBB.abrirConexion();
				dnis = gestorDDBB.devolverDNI();
				reserva = FormularioDatos.insertarReserva(sc, dnis);

				gestorDDBB.cerrarConexion();

				break;

			case Menu.ELIMINAR_RESERVAS:

				gestorDDBB.abrirConexion();

				gestorDDBB.cerrarConexion();

				break;

			case Menu.MODIFICAR_RESERVAS:

				gestorDDBB.abrirConexion();

				gestorDDBB.cerrarConexion();

				break;

			case Menu.VISUALIZAR_RESERVAS:

				gestorDDBB.abrirConexion();

				gestorDDBB.cerrarConexion();

				break;

			case Menu.SALIR:
				System.out.println("--------------VOLVIENDO------------------");
				break;
			}

		} while (opcReserva != Menu.SALIR);

	}

}
