package DS_06.Ecoembes.external;

import DS_06.Ecoembes.entity.Contenedor;

public interface IPlantaReciclajeGateway {
    int consultarCapacidadDisponible(long plantaId);
    boolean enviarContenedor(long plantaId, Contenedor contenedor);
    String obtenerEstado(long plantaId);
}