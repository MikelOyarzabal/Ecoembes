package dto;

import entity.Camion;
import entity.Contenedor;

public class RutaDTO {
	private long id;
	private ContenedorDTO contenedor;
	private float distanciaTotal;
	private int duracionEstimada;//en segundos
	private CamionDTO camionAsignado;
	public RutaDTO() {
		super();
	}
	public RutaDTO(long id, ContenedorDTO contenedor, float distanciaTotal, int duracionEstimada, CamionDTO camionAsignado) {
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
	public ContenedorDTO getContenedor() {
		return contenedor;
	}
	public void setContenedor(ContenedorDTO contenedor) {
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
	public CamionDTO getCamionAsignado() {
		return camionAsignado;
	}
	public void setCamionAsignado(CamionDTO camionAsignado) {
		this.camionAsignado = camionAsignado;
	}
}
