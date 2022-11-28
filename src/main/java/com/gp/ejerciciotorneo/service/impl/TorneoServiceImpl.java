package com.gp.ejerciciotorneo.service.impl;

import com.gp.ejerciciotorneo.model.dto.JugadorDTO;
import com.gp.ejerciciotorneo.model.dto.TorneoDTO;
import com.gp.ejerciciotorneo.model.repository.torneo.TorneoRepository;
import com.gp.ejerciciotorneo.service.TorneoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

import static com.gp.ejerciciotorneo.util.NumeroUtils.esPotenciaDeDos;

@Service
public class TorneoServiceImpl implements TorneoService {

    @Autowired
    private TorneoRepository torneoRepository;

    @Override
    public JugadorDTO simularTorneo(TorneoDTO torneoDTO) {
        validateTorneo(torneoDTO);

        return null;
    }

    private void validateTorneo(TorneoDTO torneoDTO){
        if (!esPotenciaDeDos(torneoDTO.getJugadores().size())){
            throw new ValidationException("El numero de Jugadores debe ser potencia de 2");
        }
        if(!torneoDTO.getJugadores().stream().allMatch(o -> o.getSexo().equals(torneoDTO.getTipo()))){
            throw new ValidationException("Todos los jugadores deben coincidir con el tipo de Torneo");
        }
    }
}
