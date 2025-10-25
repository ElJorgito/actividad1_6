package es.cifpcarlos3.actividad1_6;


import es.cifpcarlos3.actividad1_6.vo.Cancion;
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
    }
}