package com.gp.ejerciciotorneo.model.vo.torneo;

import com.gp.ejerciciotorneo.enumerator.TipoTorneoEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Data
public class TorneoResponseVO {

    @Schema(description = "Tipo", example = "MASCULINO", required = true)
    private TipoTorneoEnum tipo;

    @Schema(name = "Influencia de la suerte", example = "50",description ="establece el valor de influencia de la suerte",minimum = "0")
    @Positive(message = "solo se permiten valores positivos")
    @Min(message = "Valor minimo permitido: 0",value = 0L)
    @Max(message = "Valor maximo permitido: 100",value = 100L)
    private Double suerte;

    @Schema(name = "Nombre", example = "Torneo Relampago",description ="nombre para el torneo")
    private String nombre;

    @Schema(name = "Id",description ="identificador del torneo")
    private Integer idtorneo;

}
