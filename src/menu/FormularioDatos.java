package menu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import gestores.GestorDDBB;
import objetos.Cliente;
import objetos.Habitacion;
import objetos.Hotel;
import objetos.Reserva;

public class FormularioDatos {

	public static Cliente pedirNuevoCliente(Scanner sc) {

		Cliente cliente = new Cliente();
		Visor.mostrar("Introduce tu DNI");
		cliente.setDni(sc.nextLine());

		Visor.mostrar("Introduce tu nombre");
		cliente.setNombre(sc.nextLine());

		Visor.mostrar("Introduce tu apellido");
		cliente.setApellido(sc.nextLine());

		Visor.mostrar("Introduce tu direccion");
		cliente.setDireccion(sc.nextLine());

		Visor.mostrar("Introduce tu localidad");
		cliente.setLocalidad(sc.nextLine());

		return cliente;
	}

	public static String pedirDNIClienteEliminar(Scanner sc) {

		String DNICliente;

		Visor.mostrar("Introduce el DNI que quieres eliminar");
		DNICliente = sc.nextLine();

		return DNICliente;

	}

	public static String pedirDNIClienteModificar(Scanner sc) {

		String DNICliente;

		Visor.mostrar("Introduce el DNI que quieres modificar");
		DNICliente = sc.nextLine();

		return DNICliente;

	}

	public static Cliente modCliente(Cliente cliente, Scanner sc) {

		cliente.setDni(pedirDNIClienteModificar(sc));

		Visor.mostrar("Introduce el nombre modificado");
		cliente.setNombre(sc.nextLine());

		Visor.mostrar("Introduce el apellido modificado");
		cliente.setApellido(sc.nextLine());

		Visor.mostrar("Introduce la nueva direccion");
		cliente.setDireccion(sc.nextLine());

		Visor.mostrar("Introduce la nueva poblacion");
		cliente.setLocalidad(sc.nextLine());

		return cliente;
	}

	public static Hotel insertarHotel(Scanner sc) {

		Hotel hotel = new Hotel();

		Visor.mostrar("Introduce el CIF del hotel nuevo");
		hotel.setCif(sc.nextLine());

		Visor.mostrar("Introduce el nombre del hotel");
		hotel.setNombre(sc.nextLine());

		Visor.mostrar("Introduce el nombre del gerente");
		hotel.setGerente(sc.nextLine());

		Visor.mostrar("Introduce el numero de estrellas");
		hotel.setEstrellas(Integer.parseInt(sc.nextLine()));

		Visor.mostrar("Introduce el nombre de la compañia");
		hotel.setCompania(sc.nextLine());

		return hotel;
	}

	public static int pedirIDHotelEliminar(Scanner sc) {

		int id_hotel;

		Visor.mostrar("Introduce el id que quieres eliminar");
		id_hotel = Integer.parseInt(sc.nextLine());

		return id_hotel;

	}

	public static int pedirIDHotelModificar(Scanner sc) {

		int id_hotel;

		Visor.mostrar("Introduce el id que quieres modificar");
		id_hotel = Integer.parseInt(sc.nextLine());

		return id_hotel;

	}

	public static Hotel modificarHotel(Hotel hotel, Scanner sc) {

		Hotel hotel_mod = new Hotel();

		hotel_mod.setId(pedirIDHotelModificar(sc));

		Visor.mostrar("Introduce el CIF del hotel modificado");
		hotel.setCif(sc.nextLine());

		Visor.mostrar("Introduce el nombre del modificado");
		hotel.setNombre(sc.nextLine());

		Visor.mostrar("Introduce el nombre del gerente nuevo");
		hotel.setGerente(sc.nextLine());

		Visor.mostrar("Introduce el numero de estrellas nuevas");
		hotel.setEstrellas(Integer.parseInt(sc.nextLine()));

		Visor.mostrar("Introduce el nombre de la compañia nueva");
		hotel.setCompania(sc.nextLine());

		return hotel_mod;
	}
	// habitacion

	public static Habitacion pedirHabitacion(Scanner sc) {
		Habitacion habitacion = new Habitacion();

		Visor.mostrar("Introduce la ID de la nueva abitacion:");
		habitacion.setId(Integer.parseInt(sc.nextLine()));

		Visor.mostrar("Introduce la ID del HOTEL de la nueva abitacion:");
		habitacion.setId_hotel(Integer.parseInt(sc.nextLine()));

		Visor.mostrar("Introduce el Numero de la nueva abitacion:");
		habitacion.setNumero(sc.nextLine());

		Visor.mostrar("Introduce la Descripcion de la nueva abitacion:");
		habitacion.setDescripcion(sc.nextLine());

		Visor.mostrar("Introduce la Precio de la nueva abitacion:");
		habitacion.setPrecio(Double.parseDouble(sc.nextLine()));
		return habitacion;

	}

	public static int pedirIDHabitacion(Scanner sc) {

		int id;

		Visor.mostrar("Introduce el id ");
		id = Integer.parseInt(sc.nextLine());

		return id;

	}

	public static Habitacion modHabitacion(Habitacion habitacion, Scanner sc) {
		Visor.mostrar("Introduce el id que quieres modificar");
		habitacion.setId(Integer.parseInt(sc.nextLine()));

		Visor.mostrar("Introduce el id del hotel alque pertenecela abitacion que quieres modificar");
		habitacion.setId_hotel(Integer.parseInt(sc.nextLine()));

		Visor.mostrar("Introduce el nombre modificado");
		habitacion.setNumero(sc.nextLine());

		Visor.mostrar("Introduce la Descripcion modificado");
		habitacion.setDescripcion(sc.nextLine());

		Visor.mostrar("Introduce el nuevo Precio");
		habitacion.setPrecio(Double.parseDouble(sc.nextLine()));

		return habitacion;
	}

	public static Reserva insertarReserva(Scanner sc, ArrayList<String> dnis) {

		boolean bien_o_mal = false;
		boolean sales = false;

		int opcInsertReserva;

		Reserva reserva = new Reserva();

		System.out.println("Introduce el DNI del tomador de la reserva");
		String dniReserva = sc.nextLine();

		do {

			for (String dni : dnis) {

				if (dniReserva.equals(dni)) {

					Visor.mostrar("El DNI introducido esta dentro del sistema");

					bien_o_mal = true;
				}

			}

			while (bien_o_mal == false) {

				Visor.mostrar("No se encontro el DNI expecificado");

				Visor.mostrar("Introducir de nuevo o salir?");

				Visor.mostrar(Menu.INSERTAR_RESERVAS+".- De nuevo");
				Visor.mostrar(Menu.SALIR + ".- Salir");

				opcInsertReserva = Integer.parseInt(sc.nextLine());

				switch (opcInsertReserva) {
				case Menu.INSERTAR_RESERVAS:

					Visor.mostrar("Introduce el nuevo dni:");
					dniReserva = sc.nextLine();

					break;

				case Menu.SALIR:

					Visor.mostrar("Hasta luego");

					sales = true;
					bien_o_mal = true;

					break;
				}

			}

		} while (bien_o_mal == false);

		if (sales == false) {

			Visor.mostrar("Introduce el ID de habitacion.");
			reserva.setId_habitacion(Integer.parseInt(sc.nextLine()));

			reserva.setDni(dniReserva);

			
			try {
				Visor.mostrar("Cuando reservas?");
				reserva.setDesde(reserva.simpleDateFormat.parse(sc.nextLine()));
				
				Visor.mostrar("Hasta cuando?");
				reserva.setHasta(reserva.simpleDateFormat.parse(sc.nextLine()));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			

		}

		return reserva;

	}

	public static int pedirId(Scanner sc) {
		Visor.mostrar(" dame el id:");
		int id = Integer.parseInt(sc.nextLine());
		return id;
	}

	public static Reserva pedirReservaModificar(Scanner sc, Reserva reserva) {
		Visor.mostrar("Introduce el nuevo ID de habitacion.");
		reserva.setId_habitacion(Integer.parseInt(sc.nextLine()));
		
		Visor.mostrar("Introduce el nuevo dni de cliente");
		reserva.setDni(sc.nextLine());
	
		try {
			Visor.mostrar("Cuando reservas?");
			reserva.setDesde(reserva.simpleDateFormat.parse(sc.nextLine()));
			
			Visor.mostrar("Hasta cuando?");
			reserva.setHasta(reserva.simpleDateFormat.parse(sc.nextLine()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return reserva;
	}

}
