package com.gp.ejerciciotorneo.model.repository.torneo;

import com.gp.ejerciciotorneo.model.domain.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TorneoRepository extends JpaRepository <Torneo,Integer> {

}
