package com.plassb.dto;

import java.util.Date;

public class RecepcionContenedorRequest {
    private long id;                   // Cambiado de Long a long
    private int codigoPostal;          // Cambiado de Integer a int
    private float capacidad;           // Cambiado de Float a float
    private String nivelLlenado;
    private Date fechaVaciado;
    
    // Constructores con tipos primitivos
    public RecepcionContenedorRequest() {}
    
    public RecepcionContenedorRequest(long id, int codigoPostal, float capacidad, 
                                     String nivelLlenado, Date fechaVaciado) {
        this.id = id;
        this.codigoPostal = codigoPostal;
        this.capacidad = capacidad;
        this.nivelLlenado = nivelLlenado;
        this.fechaVaciado = fechaVaciado;
    }
    
    // Getters y Setters con tipos primitivos
    public long getId() {
        return id;
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
    
    public String getNivelLlenado() {
        return nivelLlenado;
    }
    
    public void setNivelLlenado(String nivelLlenado) {
        this.nivelLlenado = nivelLlenado;
    }
    
    public Date getFechaVaciado() {
        return fechaVaciado;
    }
    
    public void setFechaVaciado(Date fechaVaciado) {
        this.fechaVaciado = fechaVaciado;
    }
}