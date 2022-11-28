package com.gp.ejerciciotorneo.model.dto;

import com.gp.ejerciciotorneo.enumerator.TipoTorneoEnum;
import lombok.Data;

@Data
public class JugadorDTO {
    private TipoTorneoEnum sexo;
    private String nombre;
    private Double habilidad;
    private Double fuerza;
    private Double velocidaddesplazamiento;
    private Double tiemporeaccion;
}
