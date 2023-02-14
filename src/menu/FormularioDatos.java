package menu;

import java.util.Scanner;

import objetos.Cliente;
import objetos.Hotel;

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

}
