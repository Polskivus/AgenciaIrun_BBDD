package gestores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import objetos.Cliente;
import objetos.Hotel;

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

	/* EL SIGUIENTE */

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
	
	

}
