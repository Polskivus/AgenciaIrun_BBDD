package menu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

		System.out.println("Introduce tu DNI");
		cliente.setDni(sc.nextLine());

		System.out.println("Introduce tu nombre");
		cliente.setNombre(sc.nextLine());

		System.out.println("Introduce tu apellido");
		cliente.setApellido(sc.nextLine());

		System.out.println("Introduce tu direccion");
		cliente.setDireccion(sc.nextLine());

		System.out.println("Introduce tu localidad");
		cliente.setLocalidad(sc.nextLine());

		return cliente;
	}

	public static String pedirDNIClienteEliminar(Scanner sc) {

		String DNICliente;

		System.out.println("Introduce el DNI que quieres eliminar");
		DNICliente = sc.nextLine();

		return DNICliente;

	}

	public static String pedirDNIClienteModificar(Scanner sc) {

		String DNICliente;

		System.out.println("Introduce el DNI que quieres modificar");
		DNICliente = sc.nextLine();

		return DNICliente;

	}

	public static Cliente modCliente(Cliente cliente, Scanner sc) {

		cliente.setDni(pedirDNIClienteModificar(sc));

		System.out.println("Introduce el nombre modificado");
		cliente.setNombre(sc.nextLine());

		System.out.println("Introduce el apellido modificado");
		cliente.setApellido(sc.nextLine());

		System.out.println("Introduce la nueva direccion");
		cliente.setDireccion(sc.nextLine());

		System.out.println("Introduce la nueva poblacion");
		cliente.setLocalidad(sc.nextLine());

		return cliente;
	}

	public static Hotel insertarHotel(Scanner sc) {

		Hotel hotel = new Hotel();

		System.out.println("Introduce el CIF del hotel nuevo");
		hotel.setCif(sc.nextLine());

		System.out.println("Introduce el nombre del hotel");
		hotel.setNombre(sc.nextLine());

		System.out.println("Introduce el nombre del gerente");
		hotel.setGerente(sc.nextLine());

		System.out.println("Introduce el numero de estrellas");
		hotel.setEstrellas(Integer.parseInt(sc.nextLine()));

		System.out.println("Introduce el nombre de la compañia");
		hotel.setCompania(sc.nextLine());

		return hotel;
	}

	public static int pedirIDHotelEliminar(Scanner sc) {

		int id_hotel;

		System.out.println("Introduce el id que quieres eliminar");
		id_hotel = Integer.parseInt(sc.nextLine());

		return id_hotel;

	}

	public static int pedirIDHotelModificar(Scanner sc) {

		int id_hotel;

		System.out.println("Introduce el id que quieres modificar");
		id_hotel = Integer.parseInt(sc.nextLine());

		return id_hotel;

	}

	public static Hotel modificarHotel(Hotel hotel, Scanner sc) {

		Hotel hotel_mod = new Hotel();

		hotel_mod.setId(pedirIDHotelModificar(sc));

		System.out.println("Introduce el CIF del hotel modificado");
		hotel.setCif(sc.nextLine());

		System.out.println("Introduce el nombre del modificado");
		hotel.setNombre(sc.nextLine());

		System.out.println("Introduce el nombre del gerente nuevo");
		hotel.setGerente(sc.nextLine());

		System.out.println("Introduce el numero de estrellas nuevas");
		hotel.setEstrellas(Integer.parseInt(sc.nextLine()));

		System.out.println("Introduce el nombre de la compañia nueva");
		hotel.setCompania(sc.nextLine());

		return hotel_mod;
	}
	// habitacion

	public static Habitacion pedirHabitacion(Scanner sc) {
		Habitacion habitacion = new Habitacion();

		System.out.println("Introduce la ID de la nueva abitacion:");
		habitacion.setId(Integer.parseInt(sc.nextLine()));

		System.out.println("Introduce la ID del HOTEL de la nueva abitacion:");
		habitacion.setId_hotel(Integer.parseInt(sc.nextLine()));

		System.out.println("Introduce el Numero de la nueva abitacion:");
		habitacion.setNumero(sc.nextLine());

		System.out.println("Introduce la Descripcion de la nueva abitacion:");
		habitacion.setDescripcion(sc.nextLine());

		System.out.println("Introduce la Precio de la nueva abitacion:");
		habitacion.setPrecio(Double.parseDouble(sc.nextLine()));
		return habitacion;

	}

	public static int pedirIDHabitacion(Scanner sc) {

		int id;

		System.out.println("Introduce el id ");
		id = Integer.parseInt(sc.nextLine());

		return id;

	}

	public static Habitacion modHabitacion(Habitacion habitacion, Scanner sc) {
		System.out.println("Introduce el id que quieres modificar");
		habitacion.setId(Integer.parseInt(sc.nextLine()));

		System.out.println("Introduce el id del hotel alque pertenecela abitacion que quieres modificar");
		habitacion.setId_hotel(Integer.parseInt(sc.nextLine()));

		System.out.println("Introduce el nombre modificado");
		habitacion.setNumero(sc.nextLine());

		System.out.println("Introduce la Descripcion modificado");
		habitacion.setDescripcion(sc.nextLine());

		System.out.println("Introduce el nuevo Precio");
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

					System.out.println("El DNI introducido esta dentro del sistema");

					bien_o_mal = true;
				}

			}

			while (bien_o_mal == false) {

				System.out.println("No se encontro el DNI expecificado");

				System.out.println("Introducir de nuevo o salir?");

				System.out.println(Menu.INSERTAR_RESERVAS+".- De nuevo");
				System.out.println(Menu.SALIR + ".- Salir");

				opcInsertReserva = Integer.parseInt(sc.nextLine());

				switch (opcInsertReserva) {
				case Menu.INSERTAR_RESERVAS:

					System.out.println("Introduce el nuevo dni:");
					dniReserva = sc.nextLine();

					break;

				case Menu.SALIR:

					System.out.println("Hasta luego");

					sales = true;
					bien_o_mal = true;

					break;
				}

			}

		} while (bien_o_mal == false);

		if (sales == false) {

			System.out.println("Introduce el ID del habitacion.");
			reserva.setId_habitacion(Integer.parseInt(sc.nextLine()));

			reserva.setDni(dniReserva);

			
			try {
				System.out.println("Cuando reservas?");
				reserva.setDesde(reserva.simpleDateFormat.parse(sc.nextLine()));
				
				System.out.printf("Hasta cuando?");
				reserva.setHasta(reserva.simpleDateFormat.parse(sc.nextLine()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			

		}

		return reserva;

	}

}
