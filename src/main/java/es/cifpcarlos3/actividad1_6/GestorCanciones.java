package es.cifpcarlos3.actividad1_6;


import es.cifpcarlos3.actividad1_6.vo.Cancion;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.json.JsonMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GestorCanciones {
    public static void main(String[] args) {
        Path dir_base = Path.of("src","main","java","es","cifpcarlos3","actividad1_6");
        Path txt = dir_base.resolve("canciones.txt");
        Path json = dir_base.resolve("canciones.json");

        List<Cancion> lista = new ArrayList<>();
        int lineasLeidas = 0;
        int lineasIgnoradas = 0;

        try (var br = Files.newBufferedReader(txt, StandardCharsets.UTF_8)){
            String linea;
            while ((linea = br.readLine()) != null) {
                lineasLeidas++;

                String[] partes = linea.split(",");
                if (partes.length != 5) {
                    lineasIgnoradas++;
                    continue;
                }
                try {
                    int anio = Integer.parseInt(partes[0].trim());
                    String titulo = partes[1].trim();
                    String artista = partes[2].trim();
                    String duracion = partes[3].trim();
                    boolean esEspanola = Boolean.parseBoolean(partes[4].trim().toLowerCase());

                    Cancion cancion = new Cancion(anio, titulo, artista, duracion, esEspanola);
                    lista.add(cancion);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    lineasIgnoradas++;
                }

                JsonMapper mapper = JsonMapper.builder().enable(SerializationFeature.INDENT_OUTPUT).build();
                mapper.writeValue(json.toFile(), lista);
            }

            System.out.println("Leídas: " + lineasLeidas + " | Válidas: " + lista.size() + " | Ignoradas: " + lineasIgnoradas);
            System.out.println("JSON generado en: " + json.toAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + e.getMessage());
        }
    }
}