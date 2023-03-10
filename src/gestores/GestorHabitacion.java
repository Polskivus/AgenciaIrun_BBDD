package gestores;

import java.util.ArrayList;
import java.util.Scanner;
import menu.FormularioDatos;
import menu.Menu;
import menu.Visor;
import objetos.Habitacion;
import objetos.Hotel;


public class GestorHabitacion {
//destor del menu de habitaciones 
	
	public static void run(Scanner sc) {
		GestorDDBB gestorDDBB = new GestorDDBB();
		int opcHabitacion;
		do {
			Menu.menuHabitaciones();
			opcHabitacion = Integer.parseInt(sc.nextLine());
		
			switch (opcHabitacion) {
			case Menu.VISUALIZAR_HABITACION:
				gestorDDBB.abrirConexion();
				ArrayList<Habitacion> habitacion = gestorDDBB.mostrarArrayHabitaciones();
				Visor.mostrarArrayHabitaciones(habitacion);
				gestorDDBB.cerrarConexion();
				Visor.mostrar("---------HABITACIONES EN SISTEMA---------");
				break;
			case Menu.ELIMINAR_HABITACIONES:
				gestorDDBB.abrirConexion();
				int id = FormularioDatos.pedirIDHabitacion(sc);
				gestorDDBB.eliminarHabitacion(id);
				gestorDDBB.cerrarConexion();
				break;
			case Menu.MODIFICAR_HABITCION:
				Habitacion Habitacion = new Habitacion();

				gestorDDBB.abrirConexion();
				
				gestorDDBB.modificarHabitacion(FormularioDatos.modHabitacion(Habitacion, sc));
				gestorDDBB.cerrarConexion();
				Visor.mostrar("----------HABITACION MODIFICADOA----------");
				break;
			case Menu.INSERTAR_HABITACION:

				gestorDDBB.abrirConexion();
				gestorDDBB.insertarHabitacion(FormularioDatos.pedirHabitacion(sc));
				gestorDDBB.cerrarConexion();
				Visor.mostrar("----------HABITACION AÑADIDA----------");
				break;
			case Menu.SALIR:
				Visor.mostrar("--------------VOLVIENDO------------------");
				break;
			default:
				Visor.mostrar("opcion no disponible prueve otra");
				break;
			}
		} while (opcHabitacion != Menu.SALIR);
	}


}
