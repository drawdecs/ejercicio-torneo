package com.gp.ejerciciotorneo.model.domain;
import com.gp.ejerciciotorneo.enumerator.TipoTorneoEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "torneo")
public class Torneo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtorneo")
    private Integer idtorneo;

    @Column
    String nombre;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    TipoTorneoEnum tipo;

    @Column
    Integer numeroparticipante;

}
