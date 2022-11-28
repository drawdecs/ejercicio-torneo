package com.gp.ejerciciotorneo.model.mapper.dtoentity;

import com.gp.ejerciciotorneo.model.domain.Jugador;
import com.gp.ejerciciotorneo.model.dto.JugadorDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {Double.class })
public interface JugadorMapper {
    Jugador toEntity(JugadorDTO dto);

    JugadorDTO toDto(Jugador dto);
}
