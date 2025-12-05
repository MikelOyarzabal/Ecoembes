package DS_06.Ecoembes.external;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import DS_06.Ecoembes.entity.Contenedor;
import DS_06.Ecoembes.external.IPlantaReciclajeGateway;

@Service
public class ContSocketGateway implements IPlantaReciclajeGateway {
    
    @Value("${planta.external.contsocket.host:localhost}")
    private String host;
    
    @Value("${planta.external.contsocket.port:9090}")
    private int port;
    
    private static final int SOCKET_TIMEOUT_MS = 5000;
    
    @Override
    public int consultarCapacidadDisponible(long plantaId) {
        try (Socket socket = new Socket(host, port)) {
            socket.setSoTimeout(SOCKET_TIMEOUT_MS);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            
            // Enviar comando
            String comando = "CONSULTAR_CAPACIDAD:" + plantaId;
            out.writeUTF(comando);
            out.flush();
            
            // Leer respuesta
            String respuesta = in.readUTF();
            if (respuesta.startsWith("CAPACIDAD:")) {
                return Integer.parseInt(respuesta.split(":")[1]);
            } else if (respuesta.startsWith("ERROR:")) {
                throw new RuntimeException("Error del servidor ContSocket: " + respuesta);
            } else {
                throw new RuntimeException("Respuesta inesperada del servidor: " + respuesta);
            }
            
        } catch (SocketTimeoutException e) {
            throw new RuntimeException("Timeout al conectar con ContSocket", e);
        } catch (Exception e) {
            throw new RuntimeException("Error en conexión socket: " + e.getMessage(), e);
        }
    }
    
    @Override
    public boolean enviarContenedor(long plantaId, Contenedor contenedor) {
        try (Socket socket = new Socket(host, port)) {
            socket.setSoTimeout(SOCKET_TIMEOUT_MS);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            
            // Construir mensaje
            String comando = String.format("ENVIAR_CONTENEDOR:%d:%d:%f:%s",
                plantaId, 
                contenedor.getId(),
                contenedor.getCapacidad(),
                contenedor.getNivelDeLlenado().name());
            
            out.writeUTF(comando);
            out.flush();
            
            String respuesta = in.readUTF();
            if (respuesta.equals("OK")) {
                return true;
            } else if (respuesta.startsWith("ERROR:")) {
                throw new RuntimeException("Error del servidor ContSocket: " + respuesta);
            } else {
                return false;
            }
            
        } catch (SocketTimeoutException e) {
            throw new RuntimeException("Timeout al conectar con ContSocket", e);
        } catch (Exception e) {
            throw new RuntimeException("Error enviando contenedor por socket: " + e.getMessage(), e);
        }
    }
    
    @Override
    public String obtenerEstado(long plantaId) {
        try (Socket socket = new Socket(host, port)) {
            socket.setSoTimeout(SOCKET_TIMEOUT_MS);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            
            // Enviar comando
            String comando = "CONSULTAR_ESTADO:" + plantaId;
            out.writeUTF(comando);
            out.flush();
            
            // Leer respuesta
            String respuesta = in.readUTF();
            if (respuesta.startsWith("ESTADO:")) {
                return respuesta.split(":")[1];
            } else {
                return "DESCONOCIDO";
            }
            
        } catch (Exception e) {
            return "ERROR_CONEXION";
        }
    }
}