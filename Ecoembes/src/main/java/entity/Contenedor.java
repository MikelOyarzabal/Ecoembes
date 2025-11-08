package entity;

public class Contenedor {
	private long id;
	private String ubicacion;
	private float capacidad;
	private Llenado nivelDeLlenado;
	
	public Contenedor(long id, String ubicacion, float capacidad, Llenado nivelDeLlenado) {
		super();
		this.id = id;
		this.ubicacion = ubicacion;
		this.capacidad = capacidad;
		this.nivelDeLlenado = nivelDeLlenado;
	}
	
	public Contenedor() {
		super();
	}
	public Llenado getEstadoContenedor() {
		return this.nivelDeLlenado;
		
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public float getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(float capacidad) {
		this.capacidad = capacidad;
	}
	public Llenado getNivelDeLlenado() {
		return nivelDeLlenado;
	}
	public void setNivelDeLlenado(Llenado nivelDeLlenado) {
		this.nivelDeLlenado = nivelDeLlenado;
	}
	
}
