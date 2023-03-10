package gestores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import conexion.Conexion;
import objetos.Cliente;
import objetos.Habitacion;
import objetos.Hotel;
import objetos.Reserva;

public class GestorDDBB extends Conexion {
//clientes
	public void insertarClientes(Cliente cliente) {
		try {
			PreparedStatement preparedSt;

			preparedSt = cn.prepareStatement(
					"INSERT INTO clientes(dni, nombre, apellidos, direccion, localidad) VALUES (?,?,?,?,?)");

			preparedSt.setString(1, cliente.getDni());
			preparedSt.setString(2, cliente.getNombre());
			preparedSt.setString(3, cliente.getApellido());
			preparedSt.setString(4, cliente.getDireccion());
			preparedSt.setString(5, cliente.getLocalidad());

			preparedSt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eliminarCliente(String DNI) {

		String EliminarCliente = "DELETE FROM clientes WHERE dni= ?";

		try {

			PreparedStatement stDeleteCliente = super.cn.prepareStatement(EliminarCliente);
			stDeleteCliente.setString(1, DNI);

			stDeleteCliente.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void modificarCliente(Cliente cliente) {

		String modificarCliente = "UPDATE clientes SET nombre = ?, apellidos = ?, direccion = ?, localidad = ? WHERE dni = ?";

		try {

			PreparedStatement stmodificarCliente = super.cn.prepareStatement(modificarCliente);

			stmodificarCliente.setString(1, cliente.getNombre());
			stmodificarCliente.setString(2, cliente.getApellido());
			stmodificarCliente.setString(3, cliente.getDireccion());
			stmodificarCliente.setString(4, cliente.getDireccion());
			stmodificarCliente.setString(5, cliente.getDni());

			stmodificarCliente.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Cliente> visualizarTodosClientes() {

		String selectVisualizarClientes = "SELECT * FROM clientes";

		ArrayList<Cliente> clientes = new ArrayList<Cliente>();

		try {

			PreparedStatement stgetClientes = super.cn.prepareStatement(selectVisualizarClientes);
			ResultSet resultSet = stgetClientes.executeQuery(selectVisualizarClientes);

			while (resultSet.next()) {

				Cliente cliente = new Cliente();

				cliente.setDni(resultSet.getString("dni"));
				cliente.setNombre(resultSet.getString("nombre"));
				cliente.setApellido(resultSet.getString("apellidos"));
				cliente.setDireccion(resultSet.getString("direccion"));
				cliente.setLocalidad(resultSet.getString("localidad"));

				clientes.add(cliente);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return clientes;
	}
//hoteles
	public void insertarHotel(Hotel hotel) {

		String insertarHotel = "INSERT INTO hoteles (cif, nombre, gerente, estrellas, compania) VALUES(?,?,?,?,?)";

		try {

			PreparedStatement insertHotel = super.cn.prepareStatement(insertarHotel);

			insertHotel.setString(1, hotel.getCif());
			insertHotel.setString(2, hotel.getNombre());
			insertHotel.setString(3, hotel.getGerente());
			insertHotel.setInt(4, hotel.getEstrellas());
			insertHotel.setString(5, hotel.getCompania());

			insertHotel.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	

	public void eliminarHotel(int id) {

		String elimiarHotel = "DELETE FROM hoteles WHERE id= ?";

		try {

			PreparedStatement deleteHotel = super.cn.prepareStatement(elimiarHotel);

			deleteHotel.setInt(1, id);

			deleteHotel.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void modificarHotel(Hotel hotel) {

		String modificarHotel = "UPDATE hoteles SET cif = ?, nombre = ?, gerente = ?, estrellas = ?, compania = ?  WHERE id= ?";

		try {

			PreparedStatement modHotel = super.cn.prepareStatement(modificarHotel);

			modHotel.setString(1, hotel.getCif());
			modHotel.setString(2, hotel.getNombre());
			modHotel.setString(3, hotel.getGerente());
			modHotel.setInt(4, hotel.getEstrellas());
			modHotel.setString(5, hotel.getCompania());

			modHotel.setInt(6, hotel.getId());

			modHotel.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Hotel> mostrarArrayHotel() {

		String selectHoteles = "SELECT * FROM hoteles";

		ArrayList<Hotel> hoteles = new ArrayList<Hotel>();

		try {

			PreparedStatement mostrarHoteles = super.cn.prepareStatement(selectHoteles);
			ResultSet resultSet = mostrarHoteles.executeQuery(selectHoteles);

			while (resultSet.next()) {

				Hotel hotel = new Hotel();

				hotel.setId(resultSet.getInt("id"));
				hotel.setCif(resultSet.getString("cif"));
				hotel.setNombre(resultSet.getString("nombre"));
				hotel.setGerente(resultSet.getString("gerente"));
				hotel.setEstrellas(resultSet.getInt("estrellas"));
				hotel.setCompania(resultSet.getString("compania"));

				hoteles.add(hotel);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return hoteles;
	}
//reserva
	public ArrayList<String> devolverDNI() {

		ArrayList<String> dnis = new ArrayList<>();
		String cogerDni = "SELECT (dni) FROM clientes";

		try {

			PreparedStatement cogerDNIS = super.cn.prepareStatement(cogerDni);
			ResultSet resultSet = cogerDNIS.executeQuery(cogerDni);

			while (resultSet.next()) {

				dnis.add(resultSet.getString("dni"));
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dnis;
	}
	

	public void insertarReserva(Reserva reserva) {
		
		String insertareserva = "INSERT INTO reservas VALUES (id_habitacion, dni, desde, hasta)";
		try {

			PreparedStatement insertreserva = super.cn.prepareStatement(insertareserva);

			insertreserva.setInt(1,reserva.getId());
			insertreserva.setInt(2, reserva.getId_habitacion());
			insertreserva.setString(3, reserva.getDni());
			insertreserva.setString(4, reserva.getStringDesde());
			insertreserva.setString(5, reserva.getStringHasta());

			insertreserva.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eliminarReserva(int id) {
		String elimiarHotel = "DELETE FROM reserva WHERE id= ?";

		try {

			PreparedStatement deleteHotel = super.cn.prepareStatement(elimiarHotel);

			deleteHotel.setInt(1, id);

			deleteHotel.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Reserva selectReserva (int id) {
		String selectReservas = "SELECT * FROM Reserva";
		Reserva Reserva = new Reserva();
		PreparedStatement mostrarReservas;
		try {
			mostrarReservas = super.cn.prepareStatement(selectReservas);
			ResultSet resultSet = mostrarReservas.executeQuery(selectReservas);
		
		Reserva.setId(resultSet.getInt("id"));
		Reserva.setId_habitacion(resultSet.getInt("id_habitacion"));
		Reserva.setDni(resultSet.getString("dni"));
		Reserva.setDesde(resultSet.getDate("desde"));
		Reserva.setHasta(resultSet.getDate("hasta"));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	public void modificarReserva(Reserva reserva) {
		String modificarCliente = "UPDATE reservas SET  Id_habitacion = ?, Dni = ?, Desde = ?, Hasta =? WHERE Id = ?";
		
		try {
			
			PreparedStatement updateReserva = super.cn.prepareStatement(modificarCliente);
			
			
			
			updateReserva.setInt(1, reserva.getId_habitacion());
			updateReserva.setString(2, reserva.getDni());
			updateReserva.setString(3, reserva.getStringDesde());
			updateReserva.setString(4, reserva.getStringHasta());
			updateReserva.setInt(5,reserva.getId());
		
			updateReserva.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Reserva> mostrarReservas() {
		
		
		String selectHoteles = "SELECT * FROM hoteles";
		
		ArrayList<Reserva> Reservas = new ArrayList<Reserva>();
		
		try {
			
			PreparedStatement mostrarHoteles = super.cn.prepareStatement(selectHoteles);
			ResultSet resultSet = mostrarHoteles.executeQuery(selectHoteles);
			
			while (resultSet.next()) {
				
				Reserva Reserva = new Reserva();
				
				
				
				Reserva.setId(resultSet.getInt("id"));
				Reserva.setId_habitacion(resultSet.getInt("id_habitacion"));
				Reserva.setDni(resultSet.getString("dni"));
				Reserva.setDesde(resultSet.getDate("desde"));
				Reserva.setHasta(resultSet.getDate("hasta"));
				
				Reservas.add(Reserva);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Reservas;
	}
	//habitacion
	public ArrayList<Habitacion> mostrarArrayHabitaciones(){

		String selectHabitaciones = "SELECT * FROM Habitaciones";

		ArrayList<Habitacion> Habitaciones = new ArrayList<Habitacion>();

		try {

			PreparedStatement mostrarHabitacion = super.cn.prepareStatement(selectHabitaciones);
			ResultSet resultSet = mostrarHabitacion.executeQuery(selectHabitaciones);

			while (resultSet.next()) {

				Habitacion Habitacion = new Habitacion();
				
				
				Habitacion.setId(resultSet.getInt("id"));
				Habitacion.setId_hotel(resultSet.getInt("id_hotel"));
				Habitacion.setNumero(resultSet.getString("numero"));
				Habitacion.setDescripcion(resultSet.getString("descripcion"));
				Habitacion.setPrecio(resultSet.getDouble("precio"));
				

				Habitaciones.add(Habitacion);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return Habitaciones;
	}
	public void eliminarHabitacion(int id) {

		String EliminarHabitacion = "DELETE FROM Habitaciones WHERE id= ?";

		try {

			PreparedStatement stDeleteHabitacion = super.cn.prepareStatement(EliminarHabitacion);
			stDeleteHabitacion.setInt(1, id);

			stDeleteHabitacion.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void modificarHabitacion(Habitacion Habitacion) {

		String modificarCliente = "UPDATE clientes SET  Id_hotel = ?, Numero = ?, Descripcion = ?, Precio =? WHERE Id = ?";

		try {

			PreparedStatement stmodificarHabitacion = super.cn.prepareStatement(modificarCliente);

			
			stmodificarHabitacion.setInt(1, Habitacion.getId_hotel());
			stmodificarHabitacion.setString(2, Habitacion.getNumero());
			stmodificarHabitacion.setString(3, Habitacion.getDescripcion());
			stmodificarHabitacion.setDouble(4, Habitacion.getPrecio());
			stmodificarHabitacion.setInt(5, Habitacion.getId());
			stmodificarHabitacion.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void insertarHabitacion(Habitacion Habitacion) {

		String insertarHabitacion = "INSERT INTO Habitaciones ( Id_hotel, Numero, Descripcion, Precio) VALUES(?,?,?,?)";

		try {

			PreparedStatement insertHabitacion = super.cn.prepareStatement(insertarHabitacion);

			insertHabitacion.setInt(1, Habitacion.getId_hotel());
			insertHabitacion.setString(2, Habitacion.getNumero());
			insertHabitacion.setString(3, Habitacion.getDescripcion());
			insertHabitacion.setDouble(4, Habitacion.getPrecio());
			insertHabitacion.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

		
	



}
