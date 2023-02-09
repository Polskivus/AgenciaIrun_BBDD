package menu;

import java.util.ArrayList;

import objetos.Cliente;

public class Visor {

	public static void mostrarArrayClientes(ArrayList<Cliente> clientes) {

		for (Cliente cliente : clientes) {

			System.out.println(cliente);

		}

	}

}
