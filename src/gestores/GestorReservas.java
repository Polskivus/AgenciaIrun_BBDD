package gestores;

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

				Reserva reserva = new Reserva();
				
				gestorDDBB.abrirConexion();
				reserva = FormularioDatos.
				gestorDDBB.cerrarConexion();
				
				break;

			case Menu.ELIMINAR_RESERVAS:

				break;

			case Menu.MODIFICAR_RESERVAS:

				break;

			case Menu.VISUALIZAR_RESERVAS:

				break;

			case Menu.SALIR:
				System.out.println("--------------VOLVIENDO------------------");
				break;
			}

		} while (opcReserva != Menu.SALIR);

	}

}
