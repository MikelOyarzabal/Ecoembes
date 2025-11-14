package DS_06.Ecoembes.entity;

public class Contenedor {
	private long id;
	private int codigoPostal;
	private float capacidad;
	private Llenado nivelDeLlenado;
	private long fechaVaciado;
	private User userAsignacion;
	private long fechaAsignacion;
	public Contenedor() {
		super();
		this.nivelDeLlenado=Llenado.VERDE;
	}
	public Contenedor(long id, int codigoPostal, float capacidad, Llenado nivelDeLlenado, long fechaVaciado) {
		super();
		this.id = id;
		this.codigoPostal = codigoPostal;
		this.capacidad = capacidad;
		this.nivelDeLlenado = nivelDeLlenado;
		this.fechaVaciado = fechaVaciado;
	}
	public long getId() {
		return id;
	}
	
	public User getUserAsignacion() {
		return userAsignacion;
	}
	public void setUserAsignacion(User userAsignacion) {
		this.userAsignacion = userAsignacion;
	}
	public long getFechaAsignacion() {
		return fechaAsignacion;
	}
	public void setFechaAsignacion(long fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
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
	public long getFechaVaciado() {
		return fechaVaciado;
	}
	public void setFechaVaciado(long fechaVaciado) {
		this.fechaVaciado = fechaVaciado;
	}
	public int getOcupado() {
		return (int) (this.getCapacidad() * (100 - nivelDeLlenado.getValor()) / 100.0f);
	}
	
	
	
}
