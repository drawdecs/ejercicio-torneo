package com.gp.ejerciciotorneo.model.mapper.vodto;

import com.gp.ejerciciotorneo.enumerator.TipoTorneoEnum;
import com.gp.ejerciciotorneo.model.dto.TorneoDTO;
import com.gp.ejerciciotorneo.model.vo.torneo.JugadorVO;
import com.gp.ejerciciotorneo.model.vo.torneo.TorneoRequestVO;
import com.gp.ejerciciotorneo.model.vo.torneo.TorneoResponseVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {JugadorVO.class,TipoTorneoEnum.class,Double.class })
public interface TorneoMapperVODTO {
    TorneoResponseVO toVO(TorneoDTO source);
    TorneoDTO toDto(TorneoRequestVO target);
}
