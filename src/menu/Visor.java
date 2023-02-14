package menu;

import java.util.ArrayList;

import objetos.Cliente;
import objetos.Hotel;

public class Visor {

	public static void mostrarArrayClientes(ArrayList<Cliente> clientes) {

		for (Cliente cliente : clientes) {

			System.out.println(cliente);

		}

	}

	public static void mostrarArrayHoteles(ArrayList<Hotel> hoteles) {

		for (Hotel hotel : hoteles) {

			System.out.println(hotel);
		}
	}

}
