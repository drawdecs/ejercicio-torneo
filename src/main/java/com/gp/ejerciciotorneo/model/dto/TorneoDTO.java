package com.gp.ejerciciotorneo.model.dto;

import com.gp.ejerciciotorneo.enumerator.TipoTorneoEnum;
import com.gp.ejerciciotorneo.model.vo.torneo.JugadorVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class TorneoDTO {

    private List<JugadorDTO> jugadores;
    private TipoTorneoEnum tipo;
    private Double suerte;
    private String nombre;
    private Integer idtorneo;

}
