package com.gp.ejerciciotorneo.model.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("1")
public class JugadorMasculino extends Jugador {

    private static final long serialVersionUID = 1L;

    @Column
    private Double fuerza;

    @Column
    private Double velocidaddesplazamiento;
}
