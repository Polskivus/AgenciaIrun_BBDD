package menu;

public class Menu {

	public static final int SALIR = 0;
	/* MENU PRINCIPAL */
	public static final int GESTION_CLIENTES = 1;
	public static final int GESTION_HABITACIONES = 2;
	public static final int GESTION_HOTELES = 3;
	public static final int GESTION_RESERVAS = 4;
	/* MENU CLIENTES */
	public static final int INSERTAR_CLIENTE = 1;
	public static final int ELIMINAR_CLIENTE = 2;
	public static final int MODIFICAR_CLIENTE = 3;
	public static final int VISUALIZAR_CLIENTE = 4;
	/* MENU HOTELES */
	public static final int INSERTAR_HOTEL = 1;
	public static final int ELIMINAR_HOTEL = 2;
	public static final int MODIFICAR_HOTEL = 3;
	public static final int VISUALIZAR_HOTEL = 4;
	/* MENU HABITACIONES */
	public static final int VISUALIZAR_HABITACION = 1;
	public static final int ELIMINAR_HABITACIONES = 2;
	public static final int MODIFICAR_HABITCION = 3;
	public static final int INSERTAR_HABITACION = 4;
	/* MENU RESERVAS */
	public static final int INSERTAR_RESERVAS = 1;
	public static final int ELIMINAR_RESERVAS = 2;
	public static final int MODIFICAR_RESERVAS = 3;
	public static final int VISUALIZAR_RESERVAS = 4;

	public static void menuPrincipal() {
		System.out.println("---------------------------------");
		System.out.println(GESTION_CLIENTES + ".- Gestionar clientes");
		System.out.println(GESTION_HABITACIONES + ".- Gestion habitaciones");
		System.out.println(GESTION_HOTELES + ".- Gestion hoteles");
		System.out.println(GESTION_RESERVAS + ".- Gestion reserva");
		System.out.println(SALIR + ".- Salir");
		System.out.println("---------------------------------");
	}

	public static void menuClientes() {
		System.out.println("---------------------------------");
		System.out.println(INSERTAR_CLIENTE + ".- Añadir cliente");
		System.out.println(ELIMINAR_CLIENTE + ".- Eliminar cliete");
		System.out.println(MODIFICAR_CLIENTE + ".- Modificar cliente");
		System.out.println(VISUALIZAR_CLIENTE + ".- Visualizar clientela");
		System.out.println(SALIR + ".- Volver al principal");
		System.out.println("---------------------------------");
	}

	public static void menuHabitaciones() {
		System.out.println("---------------------------------");
		System.out.println(VISUALIZAR_HABITACION + ".- Visualizar habitaciones(disponibles?)");
		System.out.println(ELIMINAR_HABITACIONES + ".- Eliminar habitaciones");
		System.out.println(MODIFICAR_HABITCION + ".- Modificar habitacion");
		System.out.println(INSERTAR_HABITACION + ".- Añadir habitacion");
		System.out.println(SALIR + ".- Volver al principal");
		System.out.println("---------------------------------");
	}

	public static void menuHoteles() {
		System.out.println("---------------------------------");
		System.out.println(INSERTAR_HOTEL + ".- Añadir hotel");
		System.out.println(ELIMINAR_HOTEL + ".- Eliminar hotel");
		System.out.println(MODIFICAR_HOTEL + ".- Modificar hotel");
		System.out.println(VISUALIZAR_HOTEL + ".- Visualizar hoteles");
		System.out.println(SALIR + ".- Volver al principal");
		System.out.println("---------------------------------");
	}

	public static void menuReservas() {
		System.out.println("---------------------------------");
		System.out.println(VISUALIZAR_RESERVAS + ".- Visualizar reservas");
		System.out.println(ELIMINAR_RESERVAS + ".- Eliminar reserva");
		System.out.println(MODIFICAR_RESERVAS + ".- Modificar reserva");
		System.out.println(INSERTAR_RESERVAS + ".- Insertar reserva");
		System.out.println(SALIR + ".- Volver al principal");
		System.out.println("---------------------------------");
	}

}
