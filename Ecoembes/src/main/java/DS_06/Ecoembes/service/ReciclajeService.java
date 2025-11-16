
package DS_06.Ecoembes.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import DS_06.Ecoembes.entity.Contenedor;
import DS_06.Ecoembes.entity.Llenado;
import DS_06.Ecoembes.entity.PlantaReciclaje;
import DS_06.Ecoembes.entity.User;


@Service
public class ReciclajeService {

	// Simulating category and article repositories
	private static Map<Long, PlantaReciclaje> plantaReciclajeRepository = new HashMap<>();
	private static Map<Long, Contenedor> contenedorRepository = new HashMap<>();
	

	// Get all contenedores
	public List<Contenedor> getContenedores() {
		return contenedorRepository.values().stream().toList();
	}

	// Get all plantasReciclaje
	public List<PlantaReciclaje> getPlantasReciclaje() {
		return plantaReciclajeRepository.values().stream().toList();
	}
	public void asignarContenedorAPlanta(User usuario, long contenedorId, long plantaId) {
	    Contenedor contenedor = contenedorRepository.get(contenedorId);
	    if (contenedor == null) {
	        throw new RuntimeException("Contenedor no encontrado");
	    }

	    PlantaReciclaje planta = plantaReciclajeRepository.get(plantaId);
	    if (planta == null) {
	        throw new RuntimeException("Planta de reciclaje no encontrada");
	    }

	    // Verificar capacidad disponible
	    if (planta.getCapacidadDisponible() < contenedor.getOcupado()) {//si el espacio necesario para el contendor es mayor al disponible en la planta en la planta que entre
	        throw new RuntimeException("Capacidad insuficiente en la planta. Disponible: " + planta.getCapacidadDisponible() );
	    }

	    // Actualizar los campos de auditoría en el contenedor
	    contenedor.setUserAsignacion(usuario);
	    contenedor.setFechaAsignacion(System.currentTimeMillis());


	    // Asignar el contenedor a la planta (si no está ya asignado)
	    if (!planta.getListaContenedor().contains(contenedor)) {
	        planta.agregarContenedor(contenedor);
	    }

	    // Actualizar el contenedor en el repositorio
	    contenedorRepository.put(contenedorId, contenedor);
	    // Actualizar la planta en el repositorio
	    plantaReciclajeRepository.put(plantaId, planta);
	}

	// Get plantasReciclaje based on capacity
	public PlantaReciclaje getPlantasReciclajeByCapacity(int capacity) {
		for (PlantaReciclaje planta : plantaReciclajeRepository.values()) {
			if (planta.getCapacidad() == capacity) {
				return planta;
			}
		}
		throw new RuntimeException("Contenedor not found");
	}

	//Get el llenado de un contenedor por fecha
	public Llenado getLlenadoContenedorByDate(long contenedorId, long date) {
		Contenedor contenedor = contenedorRepository.get(contenedorId);
		if(contenedor.getFechaVaciado()==date) {
			return contenedor.getNivelDeLlenado();
		} else {
			throw new RuntimeException("No data for the given date");
		}
	}

	//Consulta del estado de los contenedores de una zona en una determinada fecha
	public List<Contenedor> getContenedoresByDateAndPostalCode(long date, int postalCode) {
		return contenedorRepository.values().stream()
				.filter(contenedor -> contenedor.getCodigoPostal() == postalCode && contenedor.getFechaVaciado() == date)
				.toList();
	}
	
	
	// Method to add a new Contenedor
	public void addContenedor(Contenedor contenedor) {
		if (contenedor != null) {
			contenedorRepository.put(contenedor.getId(), contenedor);
		}
	}
	// Methodo make contenedor
	public void makeContenedor(User user, long contenedorId, int codigoPostal, float capacidad) {
	    Contenedor contenedor = contenedorRepository.get(contenedorId);

	    if (contenedor != null) {
	        throw new RuntimeException("Contenedor already exists");
	    }
	    
	    // Aquí puedes agregar más validaciones y lanzar excepciones con los mensajes correspondientes
	    if (codigoPostal <= 0 || capacidad <= 0) {
	        throw new RuntimeException("Invalid parameters");
	    }

	    Contenedor cont = new Contenedor(contenedorId, codigoPostal, capacidad, Llenado.VERDE, System.currentTimeMillis());
	    contenedorRepository.put(cont.getId(), cont);
	}

	// Method to add a new PlantaReciclaje
	public void addPlantaReciclaje(PlantaReciclaje planta) {
		if (planta != null) {
			plantaReciclajeRepository.put(planta.getId(), planta);
		}
	}
}