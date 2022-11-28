package com.gp.ejerciciotorneo.service;

import com.gp.ejerciciotorneo.model.dto.JugadorDTO;
import com.gp.ejerciciotorneo.model.dto.TorneoDTO;

public interface TorneoService  {
    JugadorDTO simularTorneo(TorneoDTO torneoDTO);
}
