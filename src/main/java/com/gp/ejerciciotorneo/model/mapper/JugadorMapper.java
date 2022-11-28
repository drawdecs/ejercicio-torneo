package com.gp.ejerciciotorneo.model.mapper;

import com.gp.ejerciciotorneo.model.dto.JugadorDTO;
import com.gp.ejerciciotorneo.model.dto.TorneoDTO;
import com.gp.ejerciciotorneo.model.vo.torneo.JugadorVO;
import com.gp.ejerciciotorneo.model.vo.torneo.TorneoRequestVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {JugadorMapper.class})
public interface JugadorMapper {
    JugadorVO toEntity(JugadorDTO dto);
}
