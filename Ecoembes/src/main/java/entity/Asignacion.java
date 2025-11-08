package entity;

import java.util.ArrayList;
import java.util.Date;

public class Asignacion {
	private ArrayList<Contenedor> contenedores;
	private long id_Planta;
	private Date fecha;
	private long id_Usuario;
	public Asignacion() {
		super();
	}
	public Asignacion(ArrayList<Contenedor> contenedores, long id_Planta, Date fecha, long id_Usuario) {
		super();
		this.contenedores = contenedores;
		this.id_Planta = id_Planta;
		this.fecha = fecha;
		this.id_Usuario = id_Usuario;
	}
	public ArrayList<Contenedor> getContenedores() {
		return contenedores;
	}
	public void setContenedores(ArrayList<Contenedor> contenedores) {
		this.contenedores = contenedores;
	}
	public long getId_Planta() {
		return id_Planta;
	}
	public void setId_Planta(long id_Planta) {
		this.id_Planta = id_Planta;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public long getId_Usuario() {
		return id_Usuario;
	}
	public void setId_Usuario(long id_Usuario) {
		this.id_Usuario = id_Usuario;
	}
	
}
