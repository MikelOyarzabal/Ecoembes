package entity;

import dto.CamionDTO;
import dto.ContenedorDTO;

public class Ruta {
	private long id;
	private Contenedor contenedor;
	private float distanciaTotal;
	private int duracionEstimada;//en segundos
	private Camion camionAsignado;
	public Ruta() {
		super();
	}
	public Ruta(long id, Contenedor contenedor, float distanciaTotal, int duracionEstimada, Camion camionAsignado) {
		super();
		this.id = id;
		this.contenedor = contenedor;
		this.distanciaTotal = distanciaTotal;
		this.duracionEstimada = duracionEstimada;
		this.camionAsignado = camionAsignado;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Contenedor getContenedor() {
		return contenedor;
	}
	public void setContenedor(Contenedor contenedor) {
		this.contenedor = contenedor;
	}
	public float getDistanciaTotal() {
		return distanciaTotal;
	}
	public void setDistanciaTotal(float distanciaTotal) {
		this.distanciaTotal = distanciaTotal;
	}
	public int getDuracionEstimada() {
		return duracionEstimada;
	}
	public void setDuracionEstimada(int duracionEstimada) {
		this.duracionEstimada = duracionEstimada;
	}
	public Camion getCamionAsignado() {
		return camionAsignado;
	}
	public void setCamionAsignado(Camion camionAsignado) {
		this.camionAsignado = camionAsignado;
	}
	
	
	
}
