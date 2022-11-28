package com.gp.ejerciciotorneo.model.vo.torneo;

import com.gp.ejerciciotorneo.enumerator.TipoTorneoEnum;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Data
public class TorneoRequestVO {

    @Schema(description = "Tipo", example = "MASCULINO", required = true)
    private TipoTorneoEnum tipo;

    @Schema(description = "Lista de jugadores participantes", required = true)
    @NotEmpty(message = "la lista debe contener jugadores")
    private List<JugadorVO> jugadores;


}
