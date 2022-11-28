package com.gp.ejerciciotorneo;

import com.gp.ejerciciotorneo.enumerator.TipoTorneoEnum;
import com.gp.ejerciciotorneo.model.domain.Jugador;
import com.gp.ejerciciotorneo.model.domain.Torneo;
import com.gp.ejerciciotorneo.model.dto.JugadorDTO;
import com.gp.ejerciciotorneo.model.dto.TorneoDTO;
import com.gp.ejerciciotorneo.repository.torneo.JugadorRepository;
import com.gp.ejerciciotorneo.repository.torneo.TorneoRepository;
import com.gp.ejerciciotorneo.service.TorneoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TorneoServiceImplIntegrationTest {

    @Autowired
    private TorneoService torneoService;

    @MockBean
    private TorneoRepository torneoRepository;

    @MockBean
    private JugadorRepository jugadorRepository;

    /*@BeforeAll
    public void setUp() {

        Torneo torneo = new Torneo();

        when(torneoRepository.save(torneo))
                .thenReturn(torneo);

        when(jugadorRepository.save(new Jugador()))
                .thenReturn(new Jugador());
    }*/

    @Test
    public void whenValid_thenGanadorNotNull() {
        TorneoDTO torneoDTO = new TorneoDTO();
        torneoDTO.setNombre("Torneo");
        torneoDTO.setTipo(TipoTorneoEnum.MASCULINO);
        List<JugadorDTO> listaJugadores = new ArrayList<>();
        JugadorDTO jugador1 = new JugadorDTO();
        jugador1.setNombre("Juan");
        jugador1.setFuerza(new Double("15"));
        jugador1.setHabilidad(new Double("50"));
        jugador1.setVelocidaddesplazamiento(new Double("5"));
        jugador1.setSexo(TipoTorneoEnum.MASCULINO);
        JugadorDTO jugador2 = new JugadorDTO();
        jugador2.setNombre("Luis");
        jugador2.setFuerza(new Double("1"));
        jugador2.setHabilidad(new Double("10"));
        jugador2.setVelocidaddesplazamiento(new Double("1"));
        jugador2.setSexo(TipoTorneoEnum.MASCULINO);
        JugadorDTO jugador3 = new JugadorDTO();
        jugador3.setNombre("Jose");
        jugador3.setFuerza(new Double("1"));
        jugador3.setHabilidad(new Double("18"));
        jugador3.setVelocidaddesplazamiento(new Double("1"));
        jugador3.setSexo(TipoTorneoEnum.MASCULINO);
        JugadorDTO jugador4 = new JugadorDTO();
        jugador4.setNombre("Manuel");
        jugador4.setFuerza(new Double("1"));
        jugador4.setHabilidad(new Double("18"));
        jugador4.setVelocidaddesplazamiento(new Double("30"));
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
        jugador1.setFuerza(new Double("15"));
        jugador1.setHabilidad(new Double("50"));
        jugador1.setVelocidaddesplazamiento(new Double("5"));
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
        jugador1.setFuerza(new Double("15"));
        jugador1.setHabilidad(new Double("50"));
        jugador1.setVelocidaddesplazamiento(new Double("5"));
        jugador1.setSexo(TipoTorneoEnum.MASCULINO);
        JugadorDTO jugador2 = new JugadorDTO();
        jugador2.setNombre("Luis");
        jugador2.setFuerza(new Double("1"));
        jugador2.setHabilidad(new Double("10"));
        jugador2.setVelocidaddesplazamiento(new Double("1"));
        jugador2.setSexo(TipoTorneoEnum.FEMENINO);
        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        torneoDTO.setJugadores(listaJugadores);
        Assertions.assertThrows(ValidationException.class,()->torneoService.simularTorneo(torneoDTO));

    }
}
