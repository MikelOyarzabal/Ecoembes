package DS_06.Ecoembes;
/**
 * This code is based on solutions provided by ChatGPT 4o and 
 * adapted using GitHub Copilot. It has been thoroughly reviewed 
 * and validated to ensure correctness and that it is free of errors.
 */


import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dto.PlantaReciclajeDTO;
import dto.ContenedorDTO;
import service.ReciclajeService;

@Configuration
public class DataInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    @Bean
    CommandLineRunner initData(ReciclajeService reciclajeService) {
        return args -> {
            
            // Crear algunos contenedores
            ContenedorDTO contenedorVidrio = new ContenedorDTO(1L, "Contenedor Verde", "Vidrio", 500, 200);
            ContenedorDTO contenedorPlastico = new ContenedorDTO(2L, "Contenedor Amarillo", "Plástico", 600, 300);
            ContenedorDTO contenedorPapel = new ContenedorDTO(3L, "Contenedor Azul", "Papel y cartón", 700, 400);
            ContenedorDTO contenedorOrganico = new ContenedorDTO(4L, "Contenedor Marrón", "Orgánico", 800, 600);
            
            reciclajeService.addContenedor(contenedorVidrio);
            reciclajeService.addContenedor(contenedorPlastico);
            reciclajeService.addContenedor(contenedorPapel);
            reciclajeService.addContenedor(contenedorOrganico);

            logger.info("Contenedores creados y guardados correctamente.");

            // Crear plantas de reciclaje y asignarles contenedores
            ArrayList<ContenedorDTO> listaPlantaBilbao = new ArrayList<>();
            listaPlantaBilbao.add(contenedorVidrio);
            listaPlantaBilbao.add(contenedorPlastico);

            PlantaReciclajeDTO plantaBilbao = new PlantaReciclajeDTO(
                1L, 
                "Planta de Reciclaje de Bilbao", 
                1100, 
                500, 
                listaPlantaBilbao
            );

            ArrayList<ContenedorDTO> listaPlantaDonostia = new ArrayList<>();
            listaPlantaDonostia.add(contenedorPapel);
            listaPlantaDonostia.add(contenedorOrganico);

            PlantaReciclajeDTO plantaDonostia = new PlantaReciclajeDTO(
                2L, 
                "Planta de Reciclaje de Donostia", 
                1500, 
                700, 
                listaPlantaDonostia
            );

            reciclajeService.addPlanta(plantaBilbao);
            reciclajeService.addPlanta(plantaDonostia);

            logger.info("Plantas de reciclaje creadas y guardadas correctamente.");

        };
    }
}
