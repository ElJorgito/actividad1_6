package es.cifpcarlos3.actividad1_6.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Cancion {
    private int anio;
    private String titulo;
    private String artista;
    private String duracion;
    private boolean esEspanola;
}
