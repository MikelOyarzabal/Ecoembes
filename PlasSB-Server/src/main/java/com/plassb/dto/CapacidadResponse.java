package com.plassb.dto;

public class CapacidadResponse {
    private int capacidadDisponible;  // Cambiado de Integer a int
    private int capacidadTotal;       // Cambiado de Integer a int
    private String estado;
    
    // Constructores con int
    public CapacidadResponse() {}
    
    public CapacidadResponse(int capacidadDisponible, int capacidadTotal, String estado) {
        this.capacidadDisponible = capacidadDisponible;
        this.capacidadTotal = capacidadTotal;
        this.estado = estado;
    }
    
    // Getters y Setters con int
    public int getCapacidadDisponible() {
        return capacidadDisponible;
    }
    
    public void setCapacidadDisponible(int capacidadDisponible) {
        this.capacidadDisponible = capacidadDisponible;
    }
    
    public int getCapacidadTotal() {
        return capacidadTotal;
    }
    
    public void setCapacidadTotal(int capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
}