package gestores;

import java.util.ArrayList;
import java.util.Scanner;

import menu.FormularioDatos;
import menu.Menu;
import menu.Visor;
import objetos.Reserva;

public class GestorReservas {

	public static void run(Scanner sc) {

		GestorDDBB gestorDDBB = new GestorDDBB();
		Visor Visor =new Visor();
		int opcReserva;

		do {

			Menu.menuReservas();

			opcReserva = Integer.parseInt(sc.nextLine());

			while (opcReserva < Menu.SALIR || opcReserva > Menu.VISUALIZAR_RESERVAS) {

				Visor.mostrar("!Error¡ Introduce un valor valido");

				Menu.menuReservas();

				opcReserva = Integer.parseInt(sc.nextLine());
			}

			switch (opcReserva) {
			case Menu.INSERTAR_RESERVAS:

			
				gestorDDBB.abrirConexion();
				gestorDDBB.insertarReserva(FormularioDatos.insertarReserva(sc, gestorDDBB.devolverDNI()));
				gestorDDBB.cerrarConexion();

				break;

			case Menu.ELIMINAR_RESERVAS:

				gestorDDBB.abrirConexion();
				gestorDDBB.eliminarReserva(FormularioDatos.insertarReserva(sc, gestorDDBB.devolverDNI()).getId());
				gestorDDBB.cerrarConexion();

				break;

			case Menu.MODIFICAR_RESERVAS:

				gestorDDBB.abrirConexion();
				gestorDDBB.modificarReserva(FormularioDatos.pedirReservaModificar(sc,gestorDDBB.selectReserva(FormularioDatos.pedirId(sc))));
				gestorDDBB.cerrarConexion();

				break;

			case Menu.VISUALIZAR_RESERVAS:

				gestorDDBB.abrirConexion();
				Visor.mostrarArrayReservas(gestorDDBB.mostrarReservas());
				gestorDDBB.cerrarConexion();

				break;

			case Menu.SALIR:
				System.out.println("--------------VOLVIENDO------------------");
				break;
			}

		} while (opcReserva != Menu.SALIR);

	}

}
