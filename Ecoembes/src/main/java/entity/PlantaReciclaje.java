package entity;

public class PlantaReciclaje {
	private long id;
	private String nombre;
	private int capacidad;
	private int capacidadDisponible;
	public PlantaReciclaje() {
		super();
	}
	public PlantaReciclaje(long id, String nombre, int capacidad, int capacidadDisponible) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.capacidadDisponible = capacidadDisponible;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public int getCapacidadDisponible() {
		return capacidadDisponible;
	}
	public void setCapacidadDisponible(int capacidadDisponible) {
		this.capacidadDisponible = capacidadDisponible;
	}
	

}
