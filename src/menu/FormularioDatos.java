package menu;

import java.util.Scanner;

import objetos.Cliente;

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

}
