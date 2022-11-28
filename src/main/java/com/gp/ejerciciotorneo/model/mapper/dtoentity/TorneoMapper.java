package com.gp.ejerciciotorneo.model.mapper.dtoentity;

import com.gp.ejerciciotorneo.enumerator.TipoTorneoEnum;
import com.gp.ejerciciotorneo.model.domain.Torneo;
import com.gp.ejerciciotorneo.model.dto.JugadorDTO;
import com.gp.ejerciciotorneo.model.dto.TorneoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {JugadorDTO.class,TipoTorneoEnum.class,Double.class,Torneo.class,TorneoDTO.class })
public interface TorneoMapper {
    Torneo toEntity(TorneoDTO source);
    TorneoDTO toDto(Torneo target);
}
