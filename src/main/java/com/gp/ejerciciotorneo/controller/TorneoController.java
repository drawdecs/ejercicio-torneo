package com.gp.ejerciciotorneo.controller;

import com.gp.ejerciciotorneo.enumerator.TipoTorneoEnum;
import com.gp.ejerciciotorneo.model.dto.TorneoDTO;
import com.gp.ejerciciotorneo.model.mapper.vodto.JugadorMapperVODTO;
import com.gp.ejerciciotorneo.model.mapper.vodto.TorneoMapperVODTO;
import com.gp.ejerciciotorneo.model.vo.torneo.JugadorVO;
import com.gp.ejerciciotorneo.model.vo.torneo.TorneoRequestVO;
import com.gp.ejerciciotorneo.model.vo.torneo.TorneoResponseVO;
import com.gp.ejerciciotorneo.service.TorneoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@Tag(name="TORNEO",description = "Servicio de torneos de tenis")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/torneo")
public class TorneoController {

    @Autowired
    private TorneoService torneoService;

    @Autowired
    private TorneoMapperVODTO mapper;

    @Autowired
    private JugadorMapperVODTO jugadorMapper;

    @Operation(summary = "simula un torneo", description = "recibe una lista de jugadores y devuelve el ganador",
            tags = "TORNEO")
    @PostMapping("/simular")
    @ResponseStatus(HttpStatus.CREATED)
    public JugadorVO save(@Valid @RequestBody TorneoRequestVO torneoRequestVO) {
        TorneoDTO dto = mapper.toDto(torneoRequestVO);
        return jugadorMapper.toVO(torneoService.simularTorneo(dto));
    }

    @Operation(summary = "devuelve lista de torneos", description = "lista de torneos",
            tags = "TORNEO",parameters = {@Parameter(name = "tipo",required = false,example = "FEMENINO")})
    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<TorneoResponseVO> listar(@RequestParam(required = false) TipoTorneoEnum tipo) {
        return torneoService.listar(tipo).stream().map(mapper::toVO).collect(Collectors.toList());
    }

    @Operation(summary = "Torneo por Id", description = "devuelve torneo por Id",
            tags = "TORNEO")
    @GetMapping("/{idtorneo}")
    @ResponseStatus(HttpStatus.CREATED)
    public TorneoResponseVO obtenerTorneo(@PathVariable Long idtorneo) {
        return mapper.toVO(torneoService.obtener(idtorneo.intValue()));
    }

}