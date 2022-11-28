package com.gp.ejerciciotorneo.service.impl;

import com.gp.ejerciciotorneo.enumerator.TipoTorneoEnum;
import com.gp.ejerciciotorneo.model.domain.Jugador;
import com.gp.ejerciciotorneo.model.domain.Torneo;
import com.gp.ejerciciotorneo.model.dto.EnfrentamientoDTO;
import com.gp.ejerciciotorneo.model.dto.JugadorDTO;
import com.gp.ejerciciotorneo.model.dto.TorneoDTO;
import com.gp.ejerciciotorneo.model.mapper.dtoentity.JugadorMapper;
import com.gp.ejerciciotorneo.model.mapper.dtoentity.TorneoMapper;
import com.gp.ejerciciotorneo.repository.torneo.JugadorRepository;
import com.gp.ejerciciotorneo.repository.torneo.TorneoRepository;
import com.gp.ejerciciotorneo.service.TorneoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.gp.ejerciciotorneo.util.NumeroUtils.esPotenciaDeDos;

@Service
public class TorneoServiceImpl implements TorneoService {

    @Autowired
    private TorneoRepository torneoRepository;

    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private TorneoMapper mapper;

    @Autowired
    private JugadorMapper jugadorMapper;

    @Override
    public JugadorDTO simularTorneo(TorneoDTO torneoDTO) {
        validateTorneo(torneoDTO);
        Torneo torneo = mapper.toEntity(torneoDTO);
        torneo.setNumeroparticipante(torneoDTO.getJugadores().size());
        torneoRepository.save(torneo);
        Jugador entidad;
        for(JugadorDTO jugador: torneoDTO.getJugadores()){
            entidad = jugadorMapper.toEntity(jugador);
            entidad.setIdtorneo(torneo);
            jugadorRepository.save(entidad);
        }
        List<EnfrentamientoDTO>ronda= generarPares(torneoDTO.getJugadores());
        List<JugadorDTO> ganadores= simularRondas(ronda,torneoDTO.getSuerte());
        return ganadores.get(0);
    }

    @Override
    public List<TorneoDTO> listar(TipoTorneoEnum tipo) {
        if(tipo!=null){
            return torneoRepository.findByTipo(tipo).stream().map(mapper::toDto).collect(Collectors.toList());
        }
        return torneoRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public TorneoDTO obtener(Integer id) {
        return mapper.toDto(torneoRepository.findById(id).orElse(null));
    }

    private List<JugadorDTO> simularRondas(List<EnfrentamientoDTO> ronda,Double suerte) {
        List<JugadorDTO> jugadores= new ArrayList<>();
        if(ronda.size()==1){
            jugadores.add(simularGanador(ronda.get(0),suerte));
            return jugadores;
        }else{
            for(EnfrentamientoDTO eDTO: ronda){
                jugadores.add(simularGanador(eDTO,suerte));
            }
            return simularRondas(generarPares(jugadores),suerte);
        }
    }

    private JugadorDTO simularGanador(EnfrentamientoDTO eDTO,Double suerte) {
        Random random = new Random();
        Double jugador1=new Double(0),jugador2=new Double(0);
        if(suerte !=null && suerte>=0 && suerte <=100){
            jugador1 = random.nextInt(100)*suerte;
            jugador2 = random.nextInt(100)*suerte;
        }
        jugador1 += (jugador1>0?(jugador1/100):0)+eDTO.getIdjugadoruno().getHabilidad();
        jugador1+=eDTO.getIdjugadoruno().getSexo().equals(TipoTorneoEnum.FEMENINO)?
                eDTO.getIdjugadoruno().getTiemporeaccion():
                eDTO.getIdjugadoruno().getVelocidaddesplazamiento()+eDTO.getIdjugadoruno().getFuerza();
        jugador2 += (jugador2>0?(jugador2/100):0)+eDTO.getIdjugadordos().getHabilidad();
        jugador2+=eDTO.getIdjugadordos().getSexo().equals(TipoTorneoEnum.FEMENINO)?
                eDTO.getIdjugadordos().getTiemporeaccion():
                eDTO.getIdjugadordos().getVelocidaddesplazamiento()+eDTO.getIdjugadordos().getFuerza();
        if(jugador1>jugador2){
            return eDTO.getIdjugadoruno();
        }else{
            return eDTO.getIdjugadordos();
        }

    }

    private List<EnfrentamientoDTO> generarPares(List<JugadorDTO> jugadores) {

        List<EnfrentamientoDTO>lista = new ArrayList<>();
        EnfrentamientoDTO enfrentamiento;
        for(int i=0;i<jugadores.size();i+=2){
            enfrentamiento = new EnfrentamientoDTO();
            enfrentamiento.setIdjugadoruno(jugadores.get(i));
            enfrentamiento.setIdjugadordos(jugadores.get(i+1));
            lista.add(enfrentamiento);
        }
        return lista;
    }

    private void validateTorneo(TorneoDTO torneoDTO){
        if (!esPotenciaDeDos(torneoDTO.getJugadores().size())){
            throw new ValidationException("El numero de Jugadores debe ser potencia de 2");
        }
        if(!torneoDTO.getJugadores().stream().allMatch(o -> o.getSexo().equals(torneoDTO.getTipo()))){
            throw new ValidationException("Todos los jugadores deben coincidir con el tipo de Torneo");
        }
    }


}
