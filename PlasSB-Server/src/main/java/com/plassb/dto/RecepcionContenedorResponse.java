package com.plassb.dto;

public class RecepcionContenedorResponse {
    private boolean aceptado;
    private String mensaje;
    private int capacidadDisponibleRestante;  // Cambiado de Integer a int
    
    // Constructores con int
    public RecepcionContenedorResponse() {}
    
    public RecepcionContenedorResponse(boolean aceptado, String mensaje, int capacidadDisponibleRestante) {
        this.aceptado = aceptado;
        this.mensaje = mensaje;
        this.capacidadDisponibleRestante = capacidadDisponibleRestante;
    }
    
    // Getters y Setters con int
    public boolean isAceptado() {
        return aceptado;
    }
    
    public void setAceptado(boolean aceptado) {
        this.aceptado = aceptado;
    }
    
    public String getMensaje() {
        return mensaje;
    }
    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public int getCapacidadDisponibleRestante() {
        return capacidadDisponibleRestante;
    }
    
    public void setCapacidadDisponibleRestante(int capacidadDisponibleRestante) {
        this.capacidadDisponibleRestante = capacidadDisponibleRestante;
    }
}