package com.gp.ejerciciotorneo;

import com.gp.ejerciciotorneo.enumerator.TipoTorneoEnum;
import com.gp.ejerciciotorneo.model.dto.JugadorDTO;
import com.gp.ejerciciotorneo.model.dto.TorneoDTO;
import com.gp.ejerciciotorneo.repository.torneo.JugadorRepository;
import com.gp.ejerciciotorneo.repository.torneo.TorneoRepository;
import com.gp.ejerciciotorneo.service.TorneoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TorneoServiceImplIntegrationTest {

    @Autowired
    private TorneoService torneoService;

    @MockBean
    private TorneoRepository torneoRepository;

    @MockBean
    private JugadorRepository jugadorRepository;

    @Test
    public void whenValid_thenGanadorNotNull() {
        TorneoDTO torneoDTO = new TorneoDTO();
        torneoDTO.setNombre("Torneo");
        torneoDTO.setTipo(TipoTorneoEnum.MASCULINO);
        List<JugadorDTO> listaJugadores = new ArrayList<>();
        JugadorDTO jugador1 = new JugadorDTO();
        jugador1.setNombre("Juan");
        jugador1.setFuerza(15.0);
        jugador1.setHabilidad(50.0);
        jugador1.setVelocidaddesplazamiento(5.0);
        jugador1.setSexo(TipoTorneoEnum.MASCULINO);
        JugadorDTO jugador2 = new JugadorDTO();
        jugador2.setNombre("Luis");
        jugador2.setFuerza(1.0);
        jugador2.setHabilidad(10.0);
        jugador2.setVelocidaddesplazamiento(1.0);
        jugador2.setSexo(TipoTorneoEnum.MASCULINO);
        JugadorDTO jugador3 = new JugadorDTO();
        jugador3.setNombre("Jose");
        jugador3.setFuerza(1.0);
        jugador3.setHabilidad(18.0);
        jugador3.setVelocidaddesplazamiento(1.0);
        jugador3.setSexo(TipoTorneoEnum.MASCULINO);
        JugadorDTO jugador4 = new JugadorDTO();
        jugador4.setNombre("Manuel");
        jugador4.setFuerza(1.0);
        jugador4.setHabilidad(18.0);
        jugador4.setVelocidaddesplazamiento(30.0);
        jugador4.setSexo(TipoTorneoEnum.MASCULINO);
        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        listaJugadores.add(jugador3);
        listaJugadores.add(jugador4);
        torneoDTO.setJugadores(listaJugadores);

        JugadorDTO ganador = torneoService.simularTorneo(torneoDTO);

        assertNotNull(ganador);
    }

    @Test
    public void whenNumeroJugadoresNotValid_thenThrows() {
        TorneoDTO torneoDTO = new TorneoDTO();
        torneoDTO.setNombre("Torneo");
        torneoDTO.setTipo(TipoTorneoEnum.MASCULINO);
        List<JugadorDTO> listaJugadores = new ArrayList<>();
        JugadorDTO jugador1 = new JugadorDTO();
        jugador1.setNombre("Juan");
        jugador1.setFuerza(15.0);
        jugador1.setHabilidad(50.0);
        jugador1.setVelocidaddesplazamiento(5.0);
        jugador1.setSexo(TipoTorneoEnum.MASCULINO);
        listaJugadores.add(jugador1);
        torneoDTO.setJugadores(listaJugadores);
        Assertions.assertThrows(ValidationException.class,()->torneoService.simularTorneo(torneoDTO));

    }

    @Test
    public void whenTipoJugadorNotValid_thenThrow() {
        TorneoDTO torneoDTO = new TorneoDTO();
        torneoDTO.setNombre("Torneo");
        torneoDTO.setTipo(TipoTorneoEnum.MASCULINO);
        List<JugadorDTO> listaJugadores = new ArrayList<>();
        JugadorDTO jugador1 = new JugadorDTO();
        jugador1.setNombre("Juan");
        jugador1.setFuerza(15.0);
        jugador1.setHabilidad(50.0);
        jugador1.setVelocidaddesplazamiento(5.0);
        jugador1.setSexo(TipoTorneoEnum.MASCULINO);
        JugadorDTO jugador2 = new JugadorDTO();
        jugador2.setNombre("Luis");
        jugador2.setFuerza(1.0);
        jugador2.setHabilidad(10.0);
        jugador2.setVelocidaddesplazamiento(1.0);
        jugador2.setSexo(TipoTorneoEnum.FEMENINO);
        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        torneoDTO.setJugadores(listaJugadores);
        Assertions.assertThrows(ValidationException.class,()->torneoService.simularTorneo(torneoDTO));

    }
}
