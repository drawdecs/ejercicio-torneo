package com.gp.ejerciciotorneo.model.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.gp.ejerciciotorneo.enumerator.TipoTorneoEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class JugadorDTO {
    private TipoTorneoEnum sexo;
    private String nombre;
    private Double habilidad;
    private Double fuerza;
    private Double velocidaddesplazamiento;
    private Double tiemporeaccion;
}
