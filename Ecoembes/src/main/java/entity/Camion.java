package entity;

import java.util.ArrayList;

public class Camion {
	private long id;
	private int matricula;
	private int capacidad;
	private boolean estado;
	private ArrayList<Ruta> rutasAsignadas;
	private int duracion;//en segundos
	public Camion() {
		super();
	}
	public Camion(long id, int matricula, int capacidad, boolean estado, ArrayList<Ruta> rutasAsignadas, int duracion) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.capacidad = capacidad;
		this.estado = estado;
		this.rutasAsignadas = new ArrayList<Ruta>();
		this.duracion = duracion;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public ArrayList<Ruta> getRutasAsignadas() {
		return rutasAsignadas;
	}
	public void setRutasAsignadas(ArrayList<Ruta> rutasAsignadas) {
		this.rutasAsignadas = rutasAsignadas;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	

}
