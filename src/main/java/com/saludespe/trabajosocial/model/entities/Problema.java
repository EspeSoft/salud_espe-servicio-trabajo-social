package com.saludespe.trabajosocial.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "PROBLEMA")
public class Problema implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ficha_socioeconomica",
            referencedColumnName = "id_ficha_socioeconomica")
    private FichaSocioeconomica fichaSocioeconomica;

    @Column(name = "detalle")
    private String detalle;

    @Column(name = "observacion")
    private String observacion;

}
