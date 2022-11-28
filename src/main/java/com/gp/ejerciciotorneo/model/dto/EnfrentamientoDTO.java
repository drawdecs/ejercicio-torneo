package com.gp.ejerciciotorneo.model.dto;

import com.gp.ejerciciotorneo.model.domain.Torneo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class EnfrentamientoDTO {

    private Integer idenfrentamiento;

    private Torneo idtorneo;

    private Integer ganador;

    private JugadorDTO idjugadoruno;

    private JugadorDTO idjugadordos;

}
