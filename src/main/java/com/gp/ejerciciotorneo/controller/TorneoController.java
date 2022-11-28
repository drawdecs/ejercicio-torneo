package com.gp.ejerciciotorneo.controller;

import com.gp.ejerciciotorneo.model.dto.TorneoDTO;
import com.gp.ejerciciotorneo.model.mapper.TorneoMapper;
import com.gp.ejerciciotorneo.model.vo.torneo.JugadorVO;
import com.gp.ejerciciotorneo.model.vo.torneo.TorneoRequestVO;
import com.gp.ejerciciotorneo.service.TorneoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@Tag(name="TORNEO",description = "Servicio de torneos de tenis")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/torneo")
public class TorneoController {

    @Autowired
    private TorneoService torneoService;

    @Autowired
    private TorneoMapper mapper;

    @Operation(summary = "simula un torneo", description = "recibe una lista de jugadores y devuelve el ganador",
            tags = "TORNEO")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JugadorVO save(@RequestBody TorneoRequestVO torneoRequestVO) {
        TorneoDTO dto = mapper.toDto(torneoRequestVO);
        torneoService.simularTorneo(dto);
        return new JugadorVO();
    }

}