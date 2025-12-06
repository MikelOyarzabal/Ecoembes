package com.plassb.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plassb.dto.CapacidadResponse;
import com.plassb.dto.RecepcionContenedorRequest;
import com.plassb.dto.RecepcionContenedorResponse;
import com.plassb.model.Planta;
import com.plassb.repository.PlantaRepository;

@Service
@Transactional
public class PlantaReciclajeService {
    
    private final PlantaRepository plantaRepository;
    
    public PlantaReciclajeService(PlantaRepository plantaRepository) {
        this.plantaRepository = plantaRepository;
        inicializarDatos();
    }
    
    private void inicializarDatos() {
        // Si no hay plantas, crear algunas por defecto
        if (plantaRepository.count() == 0) {
            // Ahora con tipos primitivos int
            Planta planta1 = new Planta("Planta PlasSB Principal", 40000, 40000);
            plantaRepository.save(planta1);
            
            Planta planta2 = new Planta("Planta PlasSB Norte", 20000, 20000);
            plantaRepository.save(planta2);
            
            System.out.println("=== Datos iniciales creados para PlasSB ===");
            System.out.println("Planta 1: " + planta1.getNombre() + ", capacidad: " + planta1.getCapacidadTotal());
            System.out.println("Planta 2: " + planta2.getNombre() + ", capacidad: " + planta2.getCapacidadTotal());
        }
    }
    
    public CapacidadResponse consultarCapacidadDisponible(long plantaId) {
        Optional<Planta> plantaOpt = plantaRepository.findById(plantaId);
        
        if (plantaOpt.isPresent()) {
            Planta planta = plantaOpt.get();
            String estado = determinarEstado(planta);
            
            return new CapacidadResponse(
                planta.getCapacidadDisponible(),
                planta.getCapacidadTotal(),
                estado
            );
        } else {
            return new CapacidadResponse(0, 0, "PLANTA_NO_ENCONTRADA");
        }
    }
    
    public RecepcionContenedorResponse recibirContenedor(long plantaId, RecepcionContenedorRequest request) {
        Optional<Planta> plantaOpt = plantaRepository.findById(plantaId);
        
        if (plantaOpt.isEmpty()) {
            return new RecepcionContenedorResponse(false, "Planta no encontrada", 0);
        }
        
        Planta planta = plantaOpt.get();
        
        // Calcular capacidad ocupada
        int capacidadOcupada = (int) Math.ceil(request.getCapacidad());
        
        // Verificar si hay capacidad suficiente
        if (planta.getCapacidadDisponible() >= capacidadOcupada) {
            // Reducir capacidad disponible
            boolean reducido = planta.reducirCapacidad(capacidadOcupada);
            if (reducido) {
                plantaRepository.save(planta);
                
                System.out.println("Contenedor recibido en planta " + plantaId + 
                                 " (ID: " + request.getId() + 
                                 ", capacidad: " + capacidadOcupada + ")");
                System.out.println("Capacidad restante: " + planta.getCapacidadDisponible());
                
                return new RecepcionContenedorResponse(
                    true, 
                    "Contenedor recibido exitosamente", 
                    planta.getCapacidadDisponible()
                );
            } else {
                return new RecepcionContenedorResponse(
                    false, 
                    "Error al reducir capacidad", 
                    planta.getCapacidadDisponible()
                );
            }
        } else {
            return new RecepcionContenedorResponse(
                false, 
                "Capacidad insuficiente en la planta", 
                planta.getCapacidadDisponible()
            );
        }
    }
    
    public String obtenerEstado(long plantaId) {
        Optional<Planta> plantaOpt = plantaRepository.findById(plantaId);
        
        if (plantaOpt.isPresent()) {
            Planta planta = plantaOpt.get();
            return determinarEstado(planta);
        } else {
            return "NO_ENCONTRADA";
        }
    }
    
    private String determinarEstado(Planta planta) {
        if (planta.getCapacidadDisponible() <= 0) {
            return "SIN_CAPACIDAD";
        }
        
        int porcentaje = (int) ((planta.getCapacidadDisponible() * 100.0) / planta.getCapacidadTotal());
        
        if (porcentaje >= 75) {
            return "OPERATIVA_ALTA_CAPACIDAD";
        } else if (porcentaje >= 50) {
            return "OPERATIVA_CAPACIDAD_MEDIA";
        } else if (porcentaje >= 25) {
            return "OPERATIVA_BAJA_CAPACIDAD";
        } else {
            return "OPERATIVA_CAPACIDAD_CRITICA";
        }
    }
    
    // Método para resetear capacidad
    public void resetearCapacidad(long plantaId) {
        Optional<Planta> plantaOpt = plantaRepository.findById(plantaId);
        if (plantaOpt.isPresent()) {
            Planta planta = plantaOpt.get();
            planta.setCapacidadDisponible(planta.getCapacidadTotal());
            plantaRepository.save(planta);
            System.out.println("Capacidad reseteada para planta " + plantaId);
        }
    }
}