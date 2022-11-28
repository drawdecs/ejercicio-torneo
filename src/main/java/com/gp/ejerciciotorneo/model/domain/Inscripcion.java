package com.gp.ejerciciotorneo.model.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "inscripcion")
public class Inscripcion {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idenfrentamiento")
    private Integer idenfrentamiento;

    @JoinColumn(name = "idtorneo", referencedColumnName = "idtorneo")
    @ManyToOne(fetch = FetchType.LAZY)
    private Torneo idtorneo;

    @Column
    private Integer ganador;

    @JoinColumn(name = "idjugador", referencedColumnName = "idjugador")
    @ManyToOne(fetch = FetchType.LAZY)
    private Jugador idjugadoruno;

    @JoinColumn(name = "idjugadordos", referencedColumnName = "idjugador")
    @ManyToOne(fetch = FetchType.LAZY)
    private Jugador idjugadordos;

}
