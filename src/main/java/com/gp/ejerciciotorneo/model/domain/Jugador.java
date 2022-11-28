package com.gp.ejerciciotorneo.model.domain;

import com.gp.ejerciciotorneo.enumerator.TipoTorneoEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "jugador")
public class Jugador {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idjugador")
    private Integer idjugador;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    TipoTorneoEnum sexo;

    @Column
    String nombre;

    @Column
    Double habilidad;

    @JoinColumn(name = "idtorneo", referencedColumnName = "idtorneo")
    @ManyToOne(fetch = FetchType.LAZY)
    private Torneo idtorneo;

    @Column
    private Double tiemporeaccion;

    @Column
    private Double fuerza;

    @Column
    private Double velocidaddesplazamiento;

}
