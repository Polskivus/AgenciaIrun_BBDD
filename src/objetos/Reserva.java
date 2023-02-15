package objetos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reserva {
	public int id;
	public int id_habitacion;
	public String dni;
	public Date desde;
	public Date hasta;
	public String pattern = "yyyy-MM-dd";
	public SimpleDateFormat simpleDateFormat;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_habitacion() {
		return id_habitacion;
	}

	public void setId_habitacion(int id_habitacion) {
		this.id_habitacion = id_habitacion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public java.sql.Date getDesde() {
		return (java.sql.Date) desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public Date getHasta() {
		return hasta;
	}

	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	

	public SimpleDateFormat getSimpleDateFormat() {
		return simpleDateFormat;
	}

	public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
		this.simpleDateFormat = simpleDateFormat;
	}

	public String toString() {
		return "Reserva [id=" + id + ", id_habitacion=" + id_habitacion + ", dni=" + dni + ", desde=" + desde
				+ ", hasta=" + hasta + "]";
	}

}
