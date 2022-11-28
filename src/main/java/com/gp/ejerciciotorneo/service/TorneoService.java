package com.gp.ejerciciotorneo.service;

import com.gp.ejerciciotorneo.enumerator.TipoTorneoEnum;
import com.gp.ejerciciotorneo.model.dto.JugadorDTO;
import com.gp.ejerciciotorneo.model.dto.TorneoDTO;

import java.util.List;

public interface TorneoService  {
    JugadorDTO simularTorneo(TorneoDTO torneoDTO);
    List<TorneoDTO> listar(TipoTorneoEnum tipo);
    TorneoDTO obtener(Integer idtorneo);
}
