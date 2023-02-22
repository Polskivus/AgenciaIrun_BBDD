package main;

import java.util.ArrayList;
import java.util.Scanner;

import gestores.GestorDDBB;
import menu.Visor;
import objetos.Habitacion;
import objetos.Hotel;

public class main2 {

	public static void main(String[] args) {
		GestorDDBB gestorDDBB = new GestorDDBB();
		Visor.mostrar("dame un hotel\n");
		Scanner scan = new Scanner(System.in);
		String nombreHotel = scan.nextLine();
		ArrayList<Hotel> hoteles = gestorDDBB.mostrarArrayHotel();
		for (Hotel hotel : hoteles) {
			if (hotel.getNombre() == nombreHotel) {
				gestorDDBB.abrirConexion();
				ArrayList<Habitacion> habitacion = gestorDDBB.mostrarArrayHabitaciones();
				for (Habitacion habitacion2 : habitacion) {
					if (habitacion2.getId_hotel() == hotel.getId()) {
						Visor.mostrar(habitacion2.toString());
					}
				}
			}
		}
		scan.close();
	}
}