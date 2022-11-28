package com.gp.ejerciciotorneo.repository.torneo;

import com.gp.ejerciciotorneo.model.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository <Jugador,Integer> {

}
