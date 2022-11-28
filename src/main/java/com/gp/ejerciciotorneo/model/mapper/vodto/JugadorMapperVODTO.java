package com.gp.ejerciciotorneo.model.mapper.vodto;

import com.gp.ejerciciotorneo.model.dto.JugadorDTO;
import com.gp.ejerciciotorneo.model.vo.torneo.JugadorVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {JugadorMapperVODTO.class,Double.class })
public interface JugadorMapperVODTO {
    JugadorVO toVO(JugadorDTO dto);

    JugadorDTO toDto(JugadorVO dto);
}
