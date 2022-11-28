package com.gp.ejerciciotorneo.model.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("0")
public class JugadorFemenino extends Jugador {

    private static final long serialVersionUID = 1L;

    @Column
    private Double tiemporeaccion;
}
