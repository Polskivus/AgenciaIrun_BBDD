package gestores;

import java.util.Scanner;

import menu.Menu;

public class GestorAgencia {

	Scanner sc = new Scanner(System.in);

	public void run() throws ClassNotFoundException {

		int opc;

		do {
			Menu.menuPrincipal();

			opc = Integer.parseInt(sc.nextLine());

			while (opc < Menu.SALIR || opc > Menu.GESTION_RESERVAS) {

				System.out.println("!Error¡ Introduce un valor valido");

				Menu.menuPrincipal();

				opc = Integer.parseInt(sc.nextLine());
			}

			switch (opc) {
			case Menu.GESTION_CLIENTES:

				GestorCliente.run(sc);

				break;

			case Menu.GESTION_HABITACIONES:

				
				
				break;

			case Menu.GESTION_HOTELES:

				GestorHotel.run(sc);
				
				break;

			case Menu.GESTION_RESERVAS:

				break;
			case Menu.SALIR:
				break;
			}

		} while (opc != 0);
	}
}
