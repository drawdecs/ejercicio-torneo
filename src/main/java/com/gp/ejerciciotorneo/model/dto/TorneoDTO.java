package com.gp.ejerciciotorneo.model.dto;

import com.gp.ejerciciotorneo.enumerator.TipoTorneoEnum;
import com.gp.ejerciciotorneo.model.vo.torneo.JugadorVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class TorneoDTO {

    private TipoTorneoEnum tipo;

    private List<JugadorDTO> jugadores;


}
