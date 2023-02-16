package menu;

import java.util.ArrayList;

import objetos.Cliente;
import objetos.Habitacion;
import objetos.Hotel;
import objetos.Reserva;

public class Visor {
	public static void mostrar(String s) {
		System.out.println(s);
	}
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
	public static void mostrarArrayHabitaciones(ArrayList<Habitacion>Habitaciones) {

		for (Habitacion habitacion : Habitaciones) {
			System.out.println(habitacion);
		}
	}
	public static void mostrarArrayReservas(ArrayList<Reserva>Reservas) {

		for (Reserva Reserva : Reservas) {
			System.out.println(Reserva);
		}
	}

}
