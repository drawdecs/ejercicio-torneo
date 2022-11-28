package com.gp.ejerciciotorneo.model.dto;

import com.gp.ejerciciotorneo.enumerator.TipoTorneoEnum;
import lombok.Data;

import java.util.List;

@Data
public class TorneoDTO {

    private List<JugadorDTO> jugadores;
    private TipoTorneoEnum tipo;
    private Double suerte;
    private String nombre;
    private Integer idtorneo;

}
