package com.gp.ejerciciotorneo.model.vo.torneo;

import com.gp.ejerciciotorneo.enumerator.TipoTorneoEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class JugadorVO {

    @Schema(description = "Nombre del Jugador",example = "Pedro")
    @NotBlank(message = "Campo Obligatorio")
    private String nombre;
    @Schema(description = "Sexo del Jugador",example = "MASCULINO")
    @NotBlank(message = "Campo Obligatorio")
    private TipoTorneoEnum sexo;
    @Schema(description = "nivel de habilidad del jugador",example = "15",required = true)
    @NotBlank(message = "Campo Obligatorio")
    private Double habilidad;
    @Schema(description = "Fuerza del Jugador",example = "40.2")
    private Double fuerza;
    @Schema(description = "Velocidad del Jugador",example = "26.3")
    private Double velocidaddesplazamiento;
    @Schema(description = "Tipo de Reaccion del Jugador")
    private Double tiemporeaccion;
}
