package gestores;

import java.util.ArrayList;
import java.util.Scanner;

import menu.FormularioDatos;
import menu.Menu;
import menu.Visor;
import objetos.Cliente;

public class GestorCliente {

	/**
	 * @param sc
	 */
	public static void run(Scanner sc) {

		GestorDDBB gestorDDBB = new GestorDDBB();

		int opcCliente;

		do {

			Menu.menuClientes();

			opcCliente = Integer.parseInt(sc.nextLine());

			while (opcCliente < Menu.SALIR || opcCliente > Menu.VISUALIZAR_CLIENTE) {

				System.out.println("!Error¡ Introduce un valor valido");

				Menu.menuClientes();

				opcCliente = Integer.parseInt(sc.nextLine());
			}

			switch (opcCliente) {
			case Menu.INSERTAR_CLIENTE:

				Cliente cliente = new Cliente();

				gestorDDBB.abrirConexion();
				cliente = FormularioDatos.pedirNuevoCliente(sc);
				gestorDDBB.insertarClientes(cliente);
				gestorDDBB.cerrarConexion();

				System.out.println("----------USUARIO AÑADIDO----------");

				break;

			case Menu.ELIMINAR_CLIENTE:

				String DNI;

				gestorDDBB.abrirConexion();
				DNI = FormularioDatos.pedirDNIClienteEliminar(sc);
				gestorDDBB.eliminarCliente(DNI);
				gestorDDBB.cerrarConexion();

				System.out.println("----------USUARIO ELIMINADO----------");

				break;

			case Menu.MODIFICAR_CLIENTE:

				Cliente cliente_mod = new Cliente();

				gestorDDBB.abrirConexion();
				cliente_mod = FormularioDatos.modCliente(cliente_mod, sc);
				gestorDDBB.modificarCliente(cliente_mod);
				gestorDDBB.cerrarConexion();

				break;

			case Menu.VISUALIZAR_CLIENTE:

				gestorDDBB.abrirConexion();
				ArrayList<Cliente> clientes = gestorDDBB.visualizarTodosClientes();
				Visor.mostrarArrayClientes(clientes);
				gestorDDBB.cerrarConexion();

				break;

			case Menu.SALIR:
				System.out.println("--------------VOLVIENDO------------------");
				break;
			}

		} while (opcCliente != Menu.SALIR);
	}
}
