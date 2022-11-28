package com.gp.ejerciciotorneo.model.mapper;

import com.gp.ejerciciotorneo.model.dto.TorneoDTO;
import com.gp.ejerciciotorneo.model.vo.torneo.TorneoRequestVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TorneoMapper {

    TorneoDTO toDto(TorneoRequestVO vo);
}
