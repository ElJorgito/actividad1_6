package es.cifpcarlos3.actividad1_6;


import es.cifpcarlos3.actividad1_6.vo.Cancion;

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


            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + e.getMessage());
        }
    }
}