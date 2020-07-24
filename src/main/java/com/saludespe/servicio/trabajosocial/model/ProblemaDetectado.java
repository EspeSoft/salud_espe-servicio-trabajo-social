package com.saludespe.servicio.trabajosocial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "PROBLEMAS_DETECTADOS")
public class ProblemaDetectado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(name = "detalle")
    private String detalle;

    @Column(name = "observacion")
    private String observacion;

    @JoinColumn(name = "id_ficha_socioeconomica", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private FichaSocioeconomica fichaSocioeconomica;

}
