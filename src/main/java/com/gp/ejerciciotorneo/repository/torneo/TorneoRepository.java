package com.gp.ejerciciotorneo.repository.torneo;

import com.gp.ejerciciotorneo.enumerator.TipoTorneoEnum;
import com.gp.ejerciciotorneo.model.domain.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface TorneoRepository extends JpaRepository <Torneo,Integer> {

    List<Torneo> findByTipo(TipoTorneoEnum tipo);
}
